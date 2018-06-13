package com.htcf.dao.impl;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.htcf.dao.IBaseDAO;
import com.htcf.entity.TreadInfo;
import com.htcf.util.GenerateSQLUtil;
import com.htcf.util.MyThread;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;




public class BaseDAOImpl<T, ID extends Serializable> implements IBaseDAO<T, ID> {

	
	@Autowired
	private SessionFactory sessionFacotry;
	
	private Class persistentClass;


	/**
	 * 保存实体
	 */
	public void  save(T entity) {
	
		
		try {
			
			String sql=GenerateSQLUtil.saveEntity2Sql(entity);
			
			this.setSQL2Thread(sql, null);
			
		} catch (Exception e) {
			
			System.out.println("保存+【"+entity.getClass().getName()+"】转成操作日志SQL出现问题");
		}
		
		
		this.getSession().save(entity);
		this.getSession().flush();
		this.getSession().clear();
		
	
	}
	/**
	 * 
		 * 
		 *Description:保存list
		 * @return
		 * boolean
	 	 * @author:ytc
		 * @2014-3-5 下午03:19:06
	 */
	public boolean saveList(List<Object> l){
		try {
			Session session =  sessionFacotry.openSession();
			Transaction tx = session.beginTransaction();
			for(int i = 0 ;i<l.size();i++){
				session.save(l.get(i));
				if(i%20==0){
					session.flush();
					session.clear();
				}
			}
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除实体（持久态）
	 */
	public void delete(T entity) {
		

		try {
			
			String sql=GenerateSQLUtil.delEntity2Sql(entity);
			this.setSQL2Thread(sql, null);
			
		} catch (Exception e) {
			
			System.out.println("删除+【"+entity.getClass().getName()+"】转成操作日志SQL出现问题");
		}
		
		this.getSession().delete(entity);
	}

	
	/**
	 * 更新实体
	 * 根据参数实体id对应的数据库记录，参数实体的字段把数据库中记录的字段值覆盖
	 */
	public void update(T entity) {
		
		try {
			
			String sql=GenerateSQLUtil.updateEntity2Sql(entity);
			this.setSQL2Thread(sql, null);
			
		} catch (Exception e) {
			
			System.out.println("修改+【"+entity.getClass().getName()+"】转成操作日志SQL出现问题");
		}
		
		this.getSession().merge(entity);
		
	}
	
	
	
	/**
	 * 根据编号查询对实体
	 */
	public T getById(Serializable id) {
		try {
			
			String sql=GenerateSQLUtil.getById2Sql(this.getPersistentClass(), id);
			this.setSQL2Thread(sql, null);
			
		} catch (Exception e) {
			
			System.out.println("根据编号查询+【"+this.getPersistentClass().getName()+"】转成操作日志SQL出现问题");
		}
		
		
		return (T)this.getSession().get(this.getPersistentClass(), id);
		
	}



	
	/**************************************        JPQL操作开始              ***************************************/
	
	

	/**
	 * 查询所有记录
	 */
	public List findAll() {
		StringBuffer jpql = new StringBuffer("from ");
		jpql.append(getPersistentClass().getName());
		jpql.append(" obj");
		
		this.setHQL2Thread(jpql.toString(), null);
		
		return this.getSession().createQuery(jpql.toString()).list();
		
	}

	


	

	public int findRowCount(String jpql) {
		
		
		int result=0;
		
		if(StringUtil.isNotBlank(jpql)){
			
			StringBuffer strBuff = new StringBuffer("select count(*)");
			
			strBuff.append(jpql.substring(jpql.indexOf("from")));
			
			Query query =this.getSession().createQuery(strBuff.toString());
			
			result=((Long) query.list().get(0)).intValue();
		}

		
		return result;
	}
	
	
	public int findRowCount(String jpql, Map<String, Object> args) {
		
	
		
		int result=0;
		
		if(StringUtil.isNotBlank(jpql)){
			
			StringBuffer strBuff = new StringBuffer("select count(*)");
			
			strBuff.append(jpql.substring(jpql.indexOf("from")));
			
			Query query = this.getSession().createQuery(strBuff.toString());
			
			this.setParams(query, args);
			
		
			
			result=((Long) query.list().get(0)).intValue();
		}
		
		
		return result;
		
	}
	
	
	public List findPageByJPQL(String jpql, PageBean pageBean) {
		
		
		List list=null;
		
		if(StringUtil.isNotBlank(jpql)){
			

			Query query = this.getSession().createQuery(jpql);

			if (null != pageBean && pageBean.isPaginate()) {
				// 查询总量
				pageBean.setTotalRecord(this.findRowCount(jpql));

				// 根据总量及PAGE信息计算起始与结数值
				query.setFirstResult(pageBean.getStartRecordIndex()).setMaxResults(pageBean.getPageRecord());
			}
			
			// 返回
			list=query.list();
			
			this.setHQL2Thread(jpql, null);
			
		}
		
		return list;
		
	}

	

	public List findByJPQL(String jpql, Map<String, Object> args) {
		
		
		List list=null;
		
		if(StringUtil.isNotBlank(jpql)){
			
			Query query = this.getSession().createQuery(jpql);
			
			this.setParams(query, args);
			
			list= query.list();
			
		}
		
		this.setHQL2Thread(jpql, args);
		
		return list;
		
	}
	
	

	public List findPageByJPQL(String jpql, Map<String, Object> args, PageBean pageBean) {
		
		List list=null;
		
		if(StringUtil.isNotBlank(jpql)){
			
			Query query = this.getSession().createQuery(jpql);
			
			this.setParams(query, args);
			
			if(null != pageBean && pageBean.isPaginate()){
				
				// 查询总量
				pageBean.setTotalRecord(this.findRowCount(jpql, args));
				
				// 根据总量及PAGE信息计算起始与结数值
				query.setFirstResult(pageBean.getStartRecordIndex()).setMaxResults(pageBean.getPageRecord());
				
			}
			
			
			
			list= query.list();
			
			this.setHQL2Thread(jpql, args);
			
		}
		
		return list;
	}


	public Integer updateByJPQL(String jpql, Map<String, Object> args) {
		
		int result=0;
		
		if(StringUtil.isNotBlank(jpql)){
			
			Query query = this.getSession().createQuery(jpql);
			
			this.setParams(query, args);
			
			result= query.executeUpdate();
			
		}
		
		this.setHQL2Thread(jpql, args);
		
		return result;
		
	}

	
	

	/**************************************        JPQL操作结束              ***************************************/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************************        SQL操作开始              ***************************************/
	
	

	/**
	 * 返回：list中装入的是对象数组(Object[])
	 */

	public List findBySQL(final String sql) {
		
		List list=null;
		
		if(StringUtil.isNotBlank(sql)){
			
			list=this.getSession().createSQLQuery(sql).list();
			
		}
		
		this.setSQL2Thread(sql,null);
		
		return list ;
	}
	
	
	
	
	public List<Object[]> findBySQL(String sql, Map<String, Object> paramsMap) {
		
		List<Object[]> list=null;
		
		if (StringUtil.isNotBlank(sql)) {
	
			SQLQuery query=this.getSession().createSQLQuery(sql);
		
			this.setParams(query, paramsMap);
			
			list=query.list();
		}
		
		this.setSQL2Thread(sql, null);
		
		return  list;
	}
	
	
	
	
	
	
	public List findPageBySQL(String sql, PageBean pageBean, Map<String, Object> args) {
		
		
		List list=null;
		
		if(StringUtil.isNotBlank(sql)){
			

			Query query = this.getSession().createSQLQuery(sql);
			
			
			this.setParams(query, args);

			if (null != pageBean && pageBean.isPaginate()) {
				// 查询总量
				pageBean.setTotalRecord(this.findSQLRowCount(sql,args));

				// 根据总量及PAG信息计算起始与结数值
				query.setFirstResult(pageBean.getStartRecordIndex()).setMaxResults(pageBean.getPageRecord());
			}
			
			// 返回
			list=query.list();
			
		}
		
		this.setSQL2Thread(sql, null);
		
		return list;
		
	}
	
	
	public List findPageBySQL(String sql, PageBean pageBean) {
		
		
		List list=null;
		
		if(StringUtil.isNotBlank(sql)){
			

			Query query = this.getSession().createSQLQuery(sql);

			if (null != pageBean && pageBean.isPaginate()) {
				// 查询总量
				pageBean.setTotalRecord(this.findSQLRowCount(sql));

				// 根据总量及PAG信息计算起始与结数值
				query.setFirstResult(pageBean.getStartRecordIndex()).setMaxResults(pageBean.getPageRecord());
			}
			
			// 返回
			list=query.list();
			
		}
		
		this.setSQL2Thread(sql, null);
		
		return list;
		
	}

	
	

	/**
	 * sql语句更新记录
	 */
	public Integer updateBySql(final String sql) {
	
		this.setSQL2Thread(sql, null);
		return this.getSession().createSQLQuery(sql).executeUpdate();
		
		

	}

	
	

	public int findSQLRowCount(String sql) {
		
		//StringBuffer strBuff = new StringBuffer("select count(*) ");
		StringBuffer strBuff = new StringBuffer("select count(*) from (");
		strBuff.append(sql+") as a");
		
			
			int result=0;
			
			if(StringUtil.isNotBlank(sql)){
				
				
				//strBuff.append(jpql.substring(jpql.indexOf("FROM")));
				
				
				Query query =this.getSession().createSQLQuery(strBuff.toString());
				
				String  v=query.list().get(0).toString();
				
				if(StringUtils.isNotBlank(v)){
					result=Integer.parseInt(v);
				}
			}
			return result;
		}
		
	
	
	public int findSQLRowCount(String jpql,Map<String, Object> args) {
		
		//StringBuffer strBuff = new StringBuffer("select count(*) ");
		StringBuffer strBuff = new StringBuffer("select count(*) from (");
		strBuff.append(jpql+") as total");
		
			
			int result=0;
			
			if(StringUtil.isNotBlank(jpql)){
				
				
				//strBuff.append(jpql.substring(jpql.indexOf("FROM")));
				
				
				Query query =this.getSession().createSQLQuery(strBuff.toString());
				
				this.setParams(query, args);
				
				String  v=query.list().get(0).toString();
				
				if(StringUtils.isNotBlank(v)){
					result=Integer.parseInt(v);
				}
			}
			return result;
		}
		
		
	
	
	
	/**************************************      SQL操作结束           ***************************************/
	
	
	public void setParams( Query query ,Map<String, Object> args){
		
		if (args != null && !args.isEmpty()){
			
			Iterator<Entry<String, Object>> entries = args.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<String, Object> entry = entries.next();
				query.setParameter(entry.getKey(), entry.getValue());
				
			}
			
			
		}
	
		
	}
	
	private void setHQL2Thread(String hql,Map<String, Object> args){
		
		try {
			
				TreadInfo treadInfo=MyThread.getTread();
				treadInfo.setSql(GenerateSQLUtil.hql2Sql(sessionFacotry,hql, args));
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void setSQL2Thread(String sql,Map<String, Object> args){
		
		try {
			
				TreadInfo treadInfo=MyThread.getTread();	
				treadInfo.setSql(GenerateSQLUtil.toSql(sql, args));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	public BaseDAOImpl() {
		this.persistentClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class getPersistentClass() {
		return persistentClass;
	}


	public SessionFactory getSessionFacotry() {
		return sessionFacotry;
	}


	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	
	private Session getSession (){
		
		Session session=sessionFacotry.getCurrentSession();
		
		if(session ==null){
			
			session= sessionFacotry.openSession();
		}
		
		return session;
		
	}
	

}

