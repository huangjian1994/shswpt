package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.htcf.dao.IConfigDAO;
import com.htcf.dao.IIndexDAO;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;



@Repository(value="indexDAO")
public class IndexDAOImpl  extends BaseDAOImpl<Object,Serializable>  implements IIndexDAO {

	/**
	 * 
	 *Description:
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountBySldw(String rylb){
		Map<String,String> map = new HashMap<String, String>();
		String sql = "";
		if(StringUtil.isBlank(rylb)){
		 sql = "select sldw,count(*) from Shfk_Ryjbxx group by sldw";
		}else{
			sql = "select sldw,count(*) from Shfk_Ryjbxx where rylb like ";
			sql+="'%"+rylb+"%'";
			sql+=" group by sldw";
		}
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}
	
	/**
	 * 
	 *Description:人员状态
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRyzt(String rylb){
		Map<String,String> map = new HashMap<String, String>();
		String sql = "";
		if(StringUtil.isBlank(rylb)){
			sql = "select ryzt,count(*) from Shfk_Ryjbxx group by ryzt";
		}else{
			sql = "select ryzt,count(*) from Shfk_Ryjbxx where rylb like ";
			sql+="'%"+rylb+"%'";
			sql+=" group by ryzt";
		}
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}

	
	/**
	 * 
	 *Description:获取基本信息的总人数
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public String getJbxxCount(String rylb){
		String sql="";
		if(StringUtil.isBlank(rylb)){
			sql = "select count(*) from Shfk_Ryjbxx ";
		}else{
			sql = "select count(*) from Shfk_Ryjbxx where rylb like ";
			sql+="'%"+rylb+"%'";
		}
		Object obj = this.findBySQL(sql).get(0);
		return obj.toString();
	}
	
	
	
	/**
	 * 
	 *Description:民族
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByMz(String rylb){
		Map<String,String> map = new HashMap<String, String>();

		String sql = "";
		if(StringUtil.isBlank(rylb)){
			sql = "select mz,count(*) from Shfk_Ryjbxx group by mz";
		}else{
			sql = "select mz,count(*) from Shfk_Ryjbxx where rylb like ";
			sql+="'%"+rylb+"%'";
			sql+=" group by mz";
		}
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}
	
	
	/**
	 * 
	 *Description:来沪事由
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByLhsy(String rylb){
		Map<String,String> map = new HashMap<String, String>();
		String sql="";
		if(StringUtil.isBlank(rylb)){
			sql = "select lhsq,count(*) from shfk_ryjz z"
					+" left join shfk_ryjbxx j on j.id=z.glid group by lhsq";
		}else{
			sql = "select lhsq,count(*) from shfk_ryjz z"
					+" left join shfk_ryjbxx j on j.id=z.glid where rylb like ";
			sql+="'%"+rylb+"%'";
			sql+=" group by lhsq";
		}
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}
	
	/**
	 * 
	 *Description:采集时间
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByCjsj(String rylb){
		return null;
	}
	
	
	/**
	 * 
	 *Description:年龄
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByAge(String rylb){
		/*Map<String,String> map = new HashMap<String, String>();
		String sql = "select ,count(*) from Shfk_Ryjbxx group by mz";
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;*/
		return null;
	}
	
	
	/**
	 * 
	 *Description:人员类别
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRylb(String rylb){
		Map<String,String> map = new HashMap<String, String>();
		String sql = "select rylb,count(*) from Shfk_Ryjbxx group by rylb";
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				map.put(obj[0].toString(),obj[1].toString());
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}
	
	
	
	/**
	 * 
	 *Description:根据暂住地类型
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByZzdlx(String rylb){
		Map<String,String> map = new HashMap<String, String>();
		String sql="";
		if(StringUtil.isBlank(rylb)){
			sql = "select zzdlx,count(*) from shfk_ryjz_zzd z "+
				" left join shfk_ryjbxx j on z.idjbxx = j.id group by zzdlx";
		}else{
			sql = "select zzdlx,count(*) from shfk_ryjz_zzd z "+
					" left join shfk_ryjbxx j on z.idjbxx = j.id where rylb like ";
			sql+="'%"+rylb+"%'";
			sql+=" group by zzdlx";
		}
		List<Object[]> list = this.findBySQL(sql, null);
		for(Object[] obj:list){
			try{
				if(obj[0]==null||obj[0].toString().equals("")){
					map.put("",obj[1].toString());
				}else{
					map.put(obj[0].toString(),obj[1].toString());
				}
			}catch (Exception e) {
				continue;
			}
		}
		return map;
	}
	
}
