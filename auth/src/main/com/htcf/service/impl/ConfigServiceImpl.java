package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IConfigDAO;
import com.htcf.entity.BaseDictionary;
import com.htcf.service.IConfigService;
import com.htcf.util.PageBean;

@Service(value="configService")
public class ConfigServiceImpl implements IConfigService {
	@Autowired
	private IConfigDAO congfigDAO;
	public List<BaseDictionary> retrieveDictionaryByName(BaseDictionary dictionary,
			PageBean pageBean) {
		return this.congfigDAO.retrieveDictionaryByName(dictionary,pageBean);
	}
	 /**
	  * 增加配置键值对
	  */
	public boolean addKey(BaseDictionary dictionary) {
		
		return this.congfigDAO.addKey(dictionary);
	}
	/**
	 * 删除配置键值对
	 */
	public boolean delkey(BaseDictionary dictionary) {
		
		return this.congfigDAO.delkey(dictionary);
	}
	/**
	 * 进入修改界面
	 */
	public Object editkey(BaseDictionary dictionary) {
		
		return this.congfigDAO.editkey(dictionary);
	}
	/**
	 * 修改字典键值对
	 */
	public boolean updateKey(BaseDictionary dictionary) {
	
		return this.congfigDAO.updateKey(dictionary);
	}
	public IConfigDAO getCongfigDAO() {
		return congfigDAO;
	}
	public void setCongfigDAO(IConfigDAO congfigDAO) {
		this.congfigDAO = congfigDAO;
	}
	
	


	

}
