package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htcf.dao.SsuDao;
import com.htcf.util.PageBean;


@Repository(value="SsuDao")
public class SsuDaoImpl extends BaseDAOImpl<Object, Serializable> implements SsuDao{

	/**
	 * 
	* @Description：查询无人机设备，返回列表
	*@author:hj
	*@2017-4-11上午10:34:33
	*@param 
	*@return
	 */
	public List<?> fetchUav() {
		System.out.println("++++++++++++++++++++++"+2);
		String sql="select UAVVIDEO_NAME,UAVVIDEO_USEFUL from uav where UAVVIDEO_APPROVE ='是' ";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}

	/**
	 * 
	* @Description：查询自建设备，返回列表
	*@author:hj
	*@2017-4-11上午10:35:04
	*@param 
	*@return
	 */
	public List<?> fetchSelf() {
		System.out.println("++++++++++++自建设备json++++++++++");
		String sql="select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE," +
				"INVIDEO_USER,INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' order by id ";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}

	public List<?> fetShare() {
		System.out.println("++++++++++++++++++共享设备json+++++");
		String sql="select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date,"+
				" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, "+
				" outvideo_user,outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' order by id ";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}

	/**
	 * 
	* @Description：查询父节点
	*@author:hj
	*@2017-4-12下午03:52:33
	*@param 
	*@return
	 */
	public List<Object[]> fetF() {
		String sql = "select id,name from t where 1=1";
		return this.findPageBySQL(sql, null);
	}

	/**
	 * 
	* @Description：树形列表查询自建视频设备单位
	*@author:hj
	*@2017-4-13下午03:49:15
	*@param 
	*@return
	 */
	public List<Object[]> fetSelfList() {
		String sql="select distinct(dwdm), invideo_user FROM in_video where invideo_approve ='是'";
		
		return this.findPageBySQL(sql, null);
	}

	public List<Object[]> fetShareList() {
		String sql="select distinct(dwdm), outvideo_user FROM share_video where outvideo_approve ='是'";
		return this.findPageBySQL(sql, null);
	}

	/**
	 * 
	* @Description：树形列表查询共享视频设备
	*@author:hj
	*@2017-4-17上午11:05:05
	*@param 
	*@return
	 */
	public List<Object[]> fetSelfobj(String dwdm) {
		String sql="select id,dm,dwdm,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE," +
				"INVIDEO_USER,INVIDEO_TYPE,SSGC,gcsx from in_video where invideo_APPROVE ='是' ";
		if(dwdm != null && !dwdm.equals("")){
			sql += "and dwdm = '"+dwdm+"' ";
		}
		return this.findBySQL(sql);
	}
	
	/**
	 * 
	* @Description：树形列表查询自建视频设备
	*@author:hj
	*@2017-4-17上午11:05:05
	*@param 
	*@return
	 */
	public List<Object[]> fetShareobj(String dwdm) {
		String sql="select id,dm,dwdm,outvideo_name, outvideo_code, outvideo_approve, outvideo_date,"+
					" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_user, "+
					" outvideo_latitude, outvideo_type,SSGC,gcsx from share_video where OUTVIDEO_APPROVE ='是' ";
		
		if(dwdm != null && !dwdm.equals("")){
			sql += "and dwdm = '"+dwdm+"' ";
		}
		return this.findBySQL(sql);
		
	}

	/**
	 * @Description：根据单位代码查出个数（自建）
	 *@author:
	 *@Time2017-4-23下午07:10:22 
	 *@param Dwdm
	 *@return
	 */
	public String fetchzjgs(String Dwdm) {
		String sql = "select count(*) from in_video where dwdm  = '"+Dwdm+"' and invideo_approve='是' ";
		List l = this.findBySQL(sql);
		String gs = l.get(0).toString();
		return gs;
	}

	/**
	 * @Description：根据单位代码查出个数（共享）
	 *@author:
	 *@Time2017-4-23下午07:10:22 
	 *@param Dwdm
	 *@return
	 */
	public String fetchgxgs(String Dwdm) {
		String sql = "select count(*) from share_video where dwdm  = '"+Dwdm+"' and outvideo_approve='是'";
		List l = this.findBySQL(sql);
		String gs = l.get(0).toString();
		return gs;
	}
	
	public String fetchgxgs1(String Dwdm,PageBean pageBean) {
		String sql = "select count(*) from share_video where dwdm  = '"+Dwdm+"' and outvideo_approve='是' ";
		List l = this.findPageBySQL(sql, pageBean);
		String gs = l.get(0).toString();
		return gs;
	}
	
	/**
	 * @Description：分享设备视频树
	 *@author:
	 *@Time2017-5-11上午09:45:30 
	 *@return
	 */
	public List<?> fetchFxTree(){
		System.out.println("++++++++++++分享设备视频树json++++++++++");
		String sql="select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE," +
				" INVIDEO_USER,INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' " +
				" union all " +
				" select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
				" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, outvideo_user," +
				" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' " ;
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}
	
	
	/**
	 * 
	* @Description：查询自建设备，返回列表
	*@author:hj
	*@2017-4-11上午10:35:04
	*@param 
	*@return
	 */
	public List<?> fetchSe() {
		System.out.println("++++++++++++自建设备json++++++++++");
		String sql="select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE," +
				"INVIDEO_USER,INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' order by id ";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}
	
	/**
	 * 自建和共享设备中查询属于重大工程的设备
	* @Description：
	*@author:hj
	*@2017-5-12下午02:41:30
	*@param 
	*@return
	 */
	public List<?> fetchZdgc(){
		System.out.println("------查询重大工程------");
		String sql = "select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE,INVIDEO_USER," +
				" INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' and ssgc = '重大工程'" +
				" union all " +
				" select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
				" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, outvideo_user," +
				" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' and ssgc ='重大工程'";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
		
	}
	
	/**
	 * 自建和共享设备中查询属于防汛重点的设备
	* @Description：
	*@author:hj
	*@2017-5-12下午02:41:30
	*@param 
	*@return
	 */
	public List<?> fetchFxzd(){
		System.out.println("------查询防汛重点------");
		String sql = "select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE,INVIDEO_USER," +
				" INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' and ssgc = '防汛重点'" +
				" union all " +
				" select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
				" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, outvideo_user," +
				" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' and ssgc ='防汛重点'";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
		
	}
	
	/**
	 * 自建和共享设备中查询属于中小河道整治的设备
	* @Description：
	*@author:hj
	*@2017-5-12下午02:41:30
	*@param 
	*@return
	 */
	public List<?> fetchYxht(){
		System.out.println("------查询中小河道整治------");
		String sql = "select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_ADDRESS,INVIDEO_LONGITUDE,INVIDEO_LATITUDE,INVIDEO_USER," +
				" INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_user='信息中心' and invideo_APPROVE ='是'and  ssgc='中小河道整治'";
				
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
		
	}

	/**
	 * 自建和共享设备中查询不同分区的设备
	* @Description：
	*@author:hj
	*@2017-5-12下午02:41:30
	*@param 
	*@return
	 */
	public List<?> fetchFqsp(){
		System.out.println("++++++++++++分享设备视频树json++++++++++");
		String sql="select id,INVIDEO_NAME,INVIDEO_CODE,INVIDEO_APPROVE,INVIDEO_DATE," +
				" INVIDEO_USEFUL,INVIDEO_user,INVIDEO_LONGITUDE,INVIDEO_LATITUDE," +
				" INVIDEO_address,INVIDEO_TYPE,dm,dwdm,ssgc,gcsx from in_video where invideo_APPROVE ='是' " +
				" union all " +
				" select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
				" outvideo_useful, outvideo_user, outvideo_longitude, outvideo_latitude, outvideo_address," +
				" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' " ;
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}
	
	/**
	 * 自建和共享设备中查询属于中国对外博览会的设备
	* @Description：
	*@author:hj
	*@2017-5-12下午02:41:30
	*@param 
	*@return
	 */
	public List<?> fetchZwbl(){
		System.out.println("------查询中国对外博览会------");
		String sql = " select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
		" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, outvideo_user," +
		" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' and ssgc ='中国对外博览会'";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
		
	}

	/**
	 * @return
	 * @Description：共享设备查询 质检站设备
	 * @author:
	 * @Time2017-5-10下午01:58:47
	 */
	@Override
	public List<?> fetchZjz() {
		System.out.println("--------查询质监站的设备-----------");
		String sql = " select id,outvideo_name, outvideo_code, outvideo_approve, outvideo_date, " +
				" outvideo_useful, outvideo_address, outvideo_longitude, outvideo_latitude, outvideo_user," +
				" outvideo_type,dm,dwdm,ssgc,gcsx from share_video where OUTVIDEO_APPROVE ='是' and gcsx ='重大危险源'";
		List<?> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){
			return l ;
		}
		return null;
	}

}
