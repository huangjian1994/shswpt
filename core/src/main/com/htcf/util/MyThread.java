package com.htcf.util;

import com.htcf.entity.TreadInfo;

public class MyThread  {

	static ThreadLocal <TreadInfo> threadLocal = new ThreadLocal<TreadInfo>();   
	    
	public static void setThread(TreadInfo treadInfo) {  
		threadLocal.set(treadInfo);
	   }   
	       
	public static TreadInfo getTread(){ 
		
	      return (TreadInfo)threadLocal.get();   
	} 
	
}
