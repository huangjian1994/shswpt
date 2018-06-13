package com.htcf.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.htcf.util.PageBean;



/**
 * DAO上层接口定义，包含基本实体操作
 * 
 * @创建日期 2013-09-04
 * @作者	刘运龙
 * @版本	 1.0
 * @修改历史 
 * 	
*/
public interface IBaseDAO<T, ID extends Serializable> {
	/**
	 * 保存实体对象
	 * @param entity
	 * @return
	 */
	public void save(T entity);
	/**
	 * 
		 * 
		 *Description:保存list
		 * @return
		 * boolean
	 	 * @author:ytc
		 * @2014-3-5 下午03:19:06
	 */
	public boolean saveList(List<Object> l);

	
	/**
	 * 删除实体
	 * @param entity
	 */
	public void delete(T entity);
	
	
	
	/**
	 * 更新实体对象 
	 * @param entity
	 * @return
	 */
	public void update(T entity);

	/**
	 * 根据SQL语句更新
	 * @param sql
	 * @return 返回更新的条数
	 */
	public Integer updateBySql(final String sql);
	
	
	/**
	 * 根据ID获得实体
	 * @param id
	 * @return
	 */
	public T getById(Serializable id);
	
	/**
	 * 根据JPA QL 查找实体对象集合
	 * @param jpql
	 * @return 返回实体对象集合
	 */
	public List<T> findByJPQL(String jpql, Map<String, Object> paramsMap);
	
	/**
	 * 根据SQL查询
	 * @param sql
	 * @return 返回数组集合
	 */
	public  List<T> findBySQL(String sql);
	
	
	
	/**
	 * 根据配置参数的本地sql查询结果集
	 * 
	 * @param sql
	 * @param paramsMap 参数集合
	 * @return 返回数组集合
	 */
	public List<Object[]> findBySQL(String sql, Map<String, Object> paramsMap);
	
	/**
	 * 查询全部
	 * @return 实体对象集合
	 */
	public  List<T> findAll();
	
	
	/**
	 * 返回实体对象总量
	 * @return
	 */
	public int findRowCount(String jqpl);
	
	/**
	 * 返回实体对象总量
	 * @return
	 */
	public int findRowCount(String jqpl, Map<String, Object> args);
	
	/**
	 * 根据JPQL分页查询，若pageBean为NULL，则查询全部
	 * @param jpql
	 * @param page
	 * @return 对象集合数组
	 */
	public  List<T> findPageByJPQL(String jpql, PageBean pageBean);
	
	/**
	 * 根据JPQL分页查询，若pageBean为NULL，则查询全部
	 * @param jpql
	 * @param args 传入的参数，没有则传入NULL
	 * @param page 分页参数，没有则传入NULL
	 * @return 对象集合数组
	 */
	public  List<T> findPageByJPQL(String jpql,  Map<String, Object> args, PageBean pageBean);
	
	/**
	 * 根据JPQL 更新数据
	 * @param jpql
	 * @param args
	 * @return 返回更新的记录数
	 */
	public Integer updateByJPQL(String jpql,  Map<String, Object> args);
	
	

}
