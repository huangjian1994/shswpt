package com.htcf.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.ast.QueryTranslatorImpl;

public class GenerateSQLUtil {
	
	private static List<Class> clazzList=new ArrayList<Class>();
	
	static{
		
		clazzList.add(String.class);
		clazzList.add(Long.class);
		clazzList.add(Integer.class);
		clazzList.add(Date.class);
		clazzList.add(Double.class);
		clazzList.add(Float.class);
		
	}
	
	public static String hql2Sql(SessionFactory sf,String hql,Map<String,Object> map){
		
		
		QueryTranslatorImpl queryTranslator=new QueryTranslatorImpl(hql,hql,Collections.EMPTY_MAP,(SessionFactoryImplementor)sf);
		
		queryTranslator.compile(Collections.EMPTY_MAP, false);

		String sql= queryTranslator.getSQLString();

		return toSql(sql, map);
		
	}
		
	
	
	public  static String toSql(String sql,Map<String,Object> map){
			
		if(map !=null && !map.isEmpty()){
			
			int index=sql.indexOf("?");
			//设置参数
			Iterator<Entry<String,Object>> it=map.entrySet().iterator();
			
			while(index !=-1 && it.hasNext()){
				
				String value=it.next().getValue().toString();
				sql=sql.substring(0,index)+"'"+value+"'"+sql.substring(index+1);
				index=sql.indexOf("?");
					
			}
		}
			
		return sql;
	}
	
	

	public  static  String saveEntity2Sql(Object entity){
		
		Class clazz=entity.getClass();
		
		Table tab=(Table) clazz.getAnnotation(Table.class);
		
		String tableName=tab.name();
		
		Field [] fields=clazz.getDeclaredFields();
	
		
		//插入语句
		String insertStr="insert into "+tableName;
		
		//列名
		String colNames="";
		
		//列值
		String colValues="";
		
		//主键列
		
		String primaryName="";
		
		//主键值
		String primaryValue="";
		
		
		
		try {
			
			for (Field field : fields) {
				
				String colName="";
				
				String colValue="";
				
				String fieldName=field.getName();
			
				if(field.isAnnotationPresent(Id.class)){
					
					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
						colName=col.name();
					}
					
	
					if(StringUtils.isBlank(colName)){
						colName=fieldName;
					}
					
					primaryName=colName;
					
					if(field.isAnnotationPresent(SequenceGenerator.class)){
						
						SequenceGenerator seq=field.getAnnotation(SequenceGenerator.class);
						
						primaryValue=""+seq.sequenceName()+".nextval";
						
					}else{
						
						primaryValue="hibernate_sequence.nextval";
					}
					
				}else {
					
					

					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
						
						colName=col.name();
						
						if(StringUtils.isBlank(col.name())){
							
							colName=fieldName;
						}
						colValue=getFieldValue(field,entity);
						
						colNames+=","+colName;
						
						colValues+=","+colValue;
						
						
					}else if(field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(ManyToOne.class)){
						
						
						if(field.isAnnotationPresent(JoinColumn.class)){
							
							JoinColumn jc=field.getAnnotation(JoinColumn.class);

							colName=jc.name();
						}
						
						if(StringUtils.isBlank(colName)){
							
							colName=fieldName+"_id";
						}
						
						colValue=getFieldValue(field,entity);
						
						colNames+=","+colName;
						
						colValues+=","+colValue;
						
					}
					
				}
					
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		insertStr=insertStr+" ("+primaryName+colNames+") values"+"("+primaryValue+colValues+")";
		
		return insertStr;
	}
	
	
	public static String delEntity2Sql(Object entity){
		String colName="";
		
		String colValue="";
		
		
		Class clazz=entity.getClass();
		
		Table tab=(Table) clazz.getAnnotation(Table.class);
		
		String tableName=tab.name();
		
		Field [] fields=clazz.getDeclaredFields();
		
		String delSql="delete from "+tableName;
		
		
		try {
			
			for (Field field : fields) {
				
				if(field.isAnnotationPresent(Id.class)){
					
					String fieldName=field.getName();
					
					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
						colName=col.name();
					}

					if(StringUtils.isBlank(colName)){
						colName=fieldName;
					}
					colValue=getFieldValue(field,entity);
					
					delSql+=" where "+colName+"="+colValue;
					
					break;
					
				}
			}
			
			
		} catch (Exception e) {
			
		}
		
		
		return delSql;
	}
	
	public static String updateEntity2Sql(Object entity){
		
		
		
		
		
		Class clazz=entity.getClass();
		
		Table tab=(Table) clazz.getAnnotation(Table.class);
		
		String tableName=tab.name();
		
		Field [] fields=clazz.getDeclaredFields();
		
		String updateSql="update "+tableName +"	set ";
		
		
		String where="";
		
		String colValues="";
		
		try {
			
			for (Field field : fields) {
				

				String colName="";
				
				String colValue="";
				
				String fieldName=field.getName();
				
				if(field.isAnnotationPresent(Id.class)){
					
					
					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
						colName=col.name();
					}
					
					if(StringUtils.isBlank(colName)){
						colName=fieldName;
					}
					
					colValue=getFieldValue(field,entity);
					
					where=" where "+colName+"="+colValue;
					
					
				}else{
					
					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
			
						colName=col.name();
						
						if(StringUtils.isBlank(colName)){
							colName=fieldName;
						}
						colValue=getFieldValue(field,entity);
						
						colValues+=colName+"="+colValue+",";
						
					}else if(field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(ManyToOne.class)){
						
						
						if(field.isAnnotationPresent(JoinColumn.class)){
							
							JoinColumn jc=field.getAnnotation(JoinColumn.class);

							colName=jc.name();
						}
						
						if(StringUtils.isBlank(colName)){
							
							colName=fieldName+"_id";
						}
						
						colValue=getFieldValue(field,entity);

						colValues+=colName+"="+colValue+",";
						
					}
					
					
				}

				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(StringUtils.isNotBlank(colValues)){
			
			colValues=colValues.substring(0,colValues.length()-1);
		}
		
		updateSql=updateSql+colValues+where;
		
		
		
		return updateSql;
		
		
	}
	

	
	
	public static String getById2Sql(Class clazz,Serializable id){
		
		String colName="";
		
		
		Table tab=(Table) clazz.getAnnotation(Table.class);
		
		String tableName=tab.name();
		
		Field [] fields=clazz.getDeclaredFields();
		
		String getByIdSql="select *  from "+tableName;
		
		
		try {
			
			for (Field field : fields) {
				
				if(field.isAnnotationPresent(Id.class)){
					
					String fieldName=field.getName();
					
					if(field.isAnnotationPresent(Column.class)){
						
						Column col=field.getAnnotation(Column.class);
						colName=col.name();
					}

					if(StringUtils.isBlank(colName)){
						colName=fieldName;
					}
					
					getByIdSql+=" where "+colName+"="+id;
					
					break;
					
				}
			}
			
			
		} catch (Exception e) {
			
		}
		
		
		return getByIdSql;
	
	}
	
	
	
	public static String getFieldValue(Field field,Object obj){
		
	
		
		try {
			
			String fieldName=field.getName();
			
			//获得字段了类型
			Class clazz=field.getType();
			
			
			if(clazzList.contains(clazz)){
				
				String methodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				Method method=obj.getClass().getMethod(methodName, new Class[]{});
				Object o=method.invoke(obj, null);
				if(o==null){
					
					return "''";
				}
				
				return o.toString();
				
				
			}else {
				
				String methodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				Method method=obj.getClass().getMethod(methodName, new Class[]{});
				Object o=method.invoke(obj, null);
				
				Field [] fields=clazz.getDeclaredFields();
				
				for (Field subField : fields) {
					
					String subFieldName=subField.getName();
					
					if(subField.isAnnotationPresent(Id.class)){
						
						
						methodName="get"+subFieldName.substring(0,1).toUpperCase()+subFieldName.substring(1);
						method=clazz.getMethod(methodName, new Class[]{});
						o=method.invoke(o, null);
	
						if(o ==null){
							
							return "''";
						}
						
						return o.toString();
						
						
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "''";
	}
	
	
}
