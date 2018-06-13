package com.htcf.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.BaseDictionary;
import com.htcf.entity.BaseDictionary;

import com.htcf.service.IConfigService;



@Controller("configAction")
@Scope("prototype")
public class ConfigAction extends BaseAction {
	
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private IConfigService configService;
	private BaseDictionary dictionary=new BaseDictionary();
	private List<BaseDictionary> configList=new ArrayList<BaseDictionary>();
    /**
     * 
     *Description:查询字典内容
     * @return
     * @author:胡战旗
     * @2013-12-4下午4:00:34
     */
	public String list(){
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(10);
		configList=configService.retrieveDictionaryByName(dictionary,pageBean);
		
		return "configListSuc";
		
	}
	/**
	 * 
	 *Description:增加键值对
	 * @return
	 * @author:胡战旗
	 * @2013-12-4下午4:01:24
	 */
	public String addKey(){
		boolean remessage = configService.addKey(dictionary);
		return "addKeySuc";
	}
	/**
	 * 
	 *Description:删除键值对
	 * @return
	 * @author:胡战旗
	 * @2013-12-4下午4:22:38
	 */
	public String delkey(){
		boolean remessage = configService.delkey(dictionary);
		return "delkeySuc";
	}
	/**
	 * 
	 *Description:进入修改页面
	 * @return
	 * @author:胡战旗
	 * @2013-12-4下午5:02:03
	 */
	public String editkey(){
		dictionary=(BaseDictionary)configService.editkey(dictionary);
		return "editkeySuc";
	}
	/**
	 * 
	 *Description:修改字典键值对
	 * @return
	 * @author:胡战旗
	 * @2013-12-4下午5:23:52
	 */
	public String updateKey(){
		boolean remessage = configService.updateKey(dictionary);
		return "updateKeySuc";
	}
	
	public IConfigService getConfigService() {
		return configService;
	}
	public void setConfigService(IConfigService configService) {
		this.configService = configService;
	}
	public BaseDictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(BaseDictionary dictionary) {
		this.dictionary = dictionary;
	}
	public List<BaseDictionary> getConfigList() {
		return configList;
	}
	public void setConfigList(List<BaseDictionary> configList) {
		this.configList = configList;
	}
	
}
