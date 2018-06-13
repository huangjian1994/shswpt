package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.htcf.dao.IConfigDAO;
import com.htcf.entity.BaseDictionary;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;



@Repository(value="configDAO")
public class ConfigDAOImpl  extends BaseDAOImpl<Object,Serializable>  implements IConfigDAO {

	public List<BaseDictionary> retrieveDictionaryByName(BaseDictionary dictionary,
			PageBean pageBean) {
		StringBuffer jpql=new StringBuffer("from BaseDictionary where 1=1");
		Map<String,Object> args =new HashMap<String,Object>();
		if(StringUtil.isNotBlank(dictionary.getKey())){
			jpql.append(" and key like :key");
			args.put("key", "%"+dictionary.getKey()+"%");
		}
		if(StringUtil.isNotBlank(dictionary.getValue())){
			jpql.append(" and value like :value");
			args.put("value", "%"+dictionary.getValue()+"%");
		}
		jpql.append(" order by id desc");
		return this.findPageByJPQL(jpql.toString(), args, pageBean);
		
	}
    /**
     * 增加配置键值对
     */
	public boolean addKey(BaseDictionary dictionary) {
        this.save(dictionary);
		return true;
	}
	/**
	 * 删除配置键值对
	 */
	public boolean delkey(BaseDictionary dictionary) {
		String sql="delete from BASE_DICTIONARY WHERE ID='"+dictionary.getId()+"'";
		this.updateBySql(sql);
		return true;
	}
	/**
	 * 进入修改界面
	 */
	public Object editkey(BaseDictionary dictionary) {
		String sql = "from BaseDictionary where id = '"+dictionary.getId()+"'";
		List l = this.findPageByJPQL(sql, null);
		Object o = l.get(0);
		return o;
	}
	/**
	 * 修改字典键值对
	 */
	public boolean updateKey(BaseDictionary dictionary) {
		String sql="UPDATE BASE_DICTIONARY SET zhi='"+dictionary.getKey()+"',VALUE='"+dictionary.getValue()+"',dm='"+dictionary.getDm()+"' where ID='"+dictionary.getId()+"'";
		this.updateBySql(sql);
		return true;
	}

	
}
