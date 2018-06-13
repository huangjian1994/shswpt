package com.htcf.action;


import java.text.SimpleDateFormat;
import java.util.Date;


import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htcf.entity.OperateLog;
import com.htcf.entity.TreadInfo;
import com.htcf.service.IOperateLogService;
import com.htcf.util.Operate;
import com.htcf.util.MyThread;



@Component
@Aspect
public class OperateLogAspect {
	
	@Autowired                 
	private IOperateLogService operateLogService;

	@Around("execution(* com.htcf.service.*.*(..)) && @annotation(operate)")
	public Object  doSystemLog(ProceedingJoinPoint pjp,Operate operate) throws Throwable {
		OperateLog opLog=new OperateLog();
		Object result=null;
		try {
			result =pjp.proceed();
			opLog.setOperateResult(new Long(1));
		} catch (Exception e) {
			opLog.setErrorCode("1001");
			opLog.setOperateResult(new Long(0));
			e.printStackTrace();
			
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
		TreadInfo treadInfo=MyThread.getTread();
		System.out.println("截取的sql语句为==="+treadInfo.getSql());
		System.out.println("SQL语句长度="+treadInfo.getSql().length());
		String methodName=pjp.getSignature().getName();
		System.out.println("注解的值为=="+operate.description());
		System.out.println("方法名为："+methodName);
		opLog.setOperateCondition(treadInfo.getSql());
		opLog.setOperateName(operate.description());
		opLog.setOpTime(sdf.format(new Date()));
		opLog.setOperateType(new Long(getOperateType(methodName)));
		opLog.setTerminalId(treadInfo.getLogAddr());
	
		opLog.setOrganization(treadInfo.getOrganization());
		opLog.setOrganizationId(treadInfo.getOrganizationId());
		opLog.setUserName(treadInfo.getName());
		opLog.setUserId(treadInfo.getUserId());
		
		try {
			operateLogService.add(opLog);
		} catch (Exception e) {
			System.out.println("保存操作日志出现问题");
		}
		
	
		return result;
		
	}
	
	
	public int getOperateType(String methodName){
		
		//1:fetch;2:add;3:edit;4:delete;0:login;
		if(methodName.startsWith("fetch")||methodName.startsWith("retrieve")){
			
			return 1;
			
		}else if(methodName.startsWith("add")){
			
			return 2;
			
		}else if(methodName.startsWith("edit")){
			
			return  3;
			
		}else if(methodName.startsWith("delete")){
			
			return 4;
			
		}else {
			
			return -1;
		}
		
	}
	

	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}
}
