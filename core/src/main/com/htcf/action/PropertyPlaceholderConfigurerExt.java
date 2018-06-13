package com.htcf.action;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class PropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer {  
   
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, java.util.Properties props)  
        throws BeansException {
     	 String  username = props.getProperty("username"); 
    	 String password = props.getProperty("password");  
    	  ThreeDes des = new ThreeDes();  
    	  if (username != null) { 
              
              des.getKey(ThreeDes.generateKeyStr);  
              
              String strDes = des.getDesString(username); 
              props.setProperty("username", strDes); 
          }  
    	  if (password != null) { 
           
             des.getKey(ThreeDes.generateKeyStr);  
             
             String strDes = des.getDesString(password); 
             props.setProperty("password", strDes); 
         }  
         super.processProperties(beanFactory, props); 
            
    }
    
    
    public static void main(String[] args) {
    String  username = "shswpt"; 
   	 String password = "admin";  
   	  ThreeDes des = new ThreeDes();  
   	  if (username != null) { 
             des.getKey(ThreeDes.generateKeyStr);  
             String strEnc = des.getEncString(username); 
             System.out.println("加密用户"+strEnc);
             String strDes = des.getDesString(strEnc); 
             System.out.println("解密用户"+strDes);

   	  }  
   	  if (password != null) { 
          
            des.getKey(ThreeDes.generateKeyStr);  
            String strEnc = des.getEncString(password); 
            System.out.println("加密密码"+strEnc);
            String strDes = des.getDesString(strEnc); 
            System.out.println("加密密码"+strDes);

        }  
//   	加密用户hPXzsKQl4wc=
//   		解密用户root
//   		加密密码vGde+VHky3mJAsoSeR+Suw==
//   		加密密码HTCF5510157

   	  
	}
}
        
