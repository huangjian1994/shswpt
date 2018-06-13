package com.htcf.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import net.sf.json.JSONObject;



@MappedSuperclass
public abstract class AbstractPOJO implements Serializable  {

private static final long serialVersionUID = 1L;



	
	public String toString(){
			
			JSONObject jso=JSONObject.fromObject(this);
			return jso.toString();
			
	}


}
