package com.htcf.service;

import java.util.List;

import com.htcf.entity.BaseDictionary;

import com.htcf.util.PageBean;

public interface IConfigService {
	
	List<BaseDictionary> retrieveDictionaryByName(BaseDictionary dictionary, PageBean pageBean); 
	boolean addKey(BaseDictionary dictionary);
	boolean delkey(BaseDictionary dictionary);
	Object editkey(BaseDictionary dictionary);
	boolean updateKey(BaseDictionary dictionary);
	
}
