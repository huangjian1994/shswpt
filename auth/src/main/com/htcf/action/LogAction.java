package com.htcf.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.htcf.entity.Menu;
import com.htcf.entity.OperateLog;
import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserRole;
import com.htcf.service.IMenuService;
import com.htcf.service.IOperateLogService;
import com.htcf.service.IRoleService;
import com.htcf.service.IUserService;


@Controller("logAction")
@Scope("prototype")
public class LogAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	

	@Autowired
	private IUserService userService;
	private String page;
	private String rows;
	@Autowired
	private IOperateLogService operateLogService;
	
	private User user=new User();
	private OperateLog opLog = new OperateLog();
	private OperateLog oprateLog = new OperateLog();
	
	private List<?> opLogList;
	private String userName;
	private Long operateType;
	private String opTime;
	private String operateName;

	
	public String goLog(){
		System.out.println("进入日志管理");
		return "logList";
	}
	//详情
	public String fetchBq(){
		//System.out.println("^^_^^ ^^_^^ ^^_^^");
		//System.out.println("主键="+opLog.getId());
		List<?> list = operateLogService.fetchOperateLog(opLog);	
		//System.out.println("SQL语句="+oprateLog.getOperateCondition());
		HttpServletResponse response=this.getHttpServletResponse();		 
		response.setContentType("text/plain;charset=utf-8");		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		JsonConfig config=new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  //自动为我排除circle
		JSONArray arr=JSONArray.fromObject(list,config);
		out.print(arr.toString());		
		out.flush();		
		return null;
	}
	
	public void list(){
		HttpServletRequest request = this.getHttpServletRequest();
		HttpServletResponse response = this.getHttpServletResponse();
		//分页显示
		//System.out.println(page + "页数代码");
		//System.out.println(rows + "页数代码");
		//System.out.println(page + "page");
		int pageNo = Integer.parseInt(page)-1;
		int pageSize = Integer.parseInt(rows);
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(pageSize);
		pageBean.setCurPage(pageNo+1);
//		System.out.println("operateName="+operateName);
//		System.out.println("operateType="+operateType);
//		System.out.println("userName="+userName);
//		System.out.println("opTime="+opTime);
		oprateLog.setUserName(userName);
		oprateLog.setOperateType(operateType);
		oprateLog.setOpTime(opTime);
		oprateLog.setOperateName(operateName);
		try{
			opLogList=operateLogService.retrieveLogs(user,oprateLog,pageBean);
			Map<String, Object>[] rows =null;
			try{
				rows = new LinkedHashMap[opLogList.size()];
			}catch (Exception e) {
				rows = new LinkedHashMap[0];
			}
			System.out.println("opLogList="+opLogList);
			if(opLogList!=null&&opLogList.size()>0){
				OperateLog operateLog = null;
				String temp ="";
				String temp1="";
				for (int i = 0; i < opLogList.size(); i++) {
					operateLog = new OperateLog();
					operateLog = (OperateLog) opLogList.get(i);
					rows[i] = new LinkedHashMap<String, Object>();
					//rows[i].put("userId",operateLog.getUserId());
					rows[i].put("operateName",operateLog.getOperateName());
					rows[i].put("userName",operateLog.getUserName());
					rows[i].put("opTime",operateLog.getOpTime());
					if(operateLog.getOperateType()==0){
						temp="登录";
					}else if(operateLog.getOperateType()==-1){
						temp="未知";
					}else if(operateLog.getOperateType()==1){
						temp="查询";
					}else if(operateLog.getOperateType()==2){
						temp="新增";
					}else if(operateLog.getOperateType()==3){
						temp="修改";
					}else if(operateLog.getOperateType()==4){
						temp="删除";
					}
					rows[i].put("operateType",temp);
					rows[i].put("terminalId",operateLog.getTerminalId());
					if(operateLog.getOperateResult()==0){
						temp1="失败";
					}else if(operateLog.getOperateResult()==1){
						temp1="成功";
					}
					rows[i].put("operateResult",temp1);
					rows[i].put("organization",operateLog.getOrganization());
					rows[i].put("organizationId",operateLog.getOrganizationId());
					rows[i].put("operateCondition",operateLog.getOperateCondition());
					rows[i].put("errorCode",operateLog.getErrorCode());
					rows[i].put("id",operateLog.getId());
					//System.out.println("operateCondition="+operateLog.getOperateCondition());
//					rows[i].put("userId",oprateLog.getUserId()!=null?oprateLog.getUserId().toString():"");
//					rows[i].put("userName",oprateLog.getUserName()!=null?oprateLog.getUserName().toString():"");
//					rows[i].put("organization",oprateLog.getOrganization()!=null?oprateLog.getOrganization().toString():"");
//					rows[i].put("organizationId",oprateLog.getOrganizationId()!=null?oprateLog.getOrganizationId().toString():"");
//					rows[i].put("terminalId",oprateLog.getTerminalId()!=null?oprateLog.getTerminalId().toString():"");
//					rows[i].put("operateType",oprateLog.getOperateType()!=null?oprateLog.getOperateType().toString():"");
//					rows[i].put("opTime",oprateLog.getOpTime()!=null?oprateLog.getOpTime().toString():"");
//					rows[i].put("operateCondition",oprateLog.getOperateCondition()!=null?oprateLog.getOperateCondition().toString():"");
//					rows[i].put("operateResult",oprateLog.getOperateResult()!=null?oprateLog.getOperateResult().toString():"");
//					rows[i].put("errorCode",oprateLog.getErrorCode()!=null?oprateLog.getErrorCode().toString():"");
//					rows[i].put("operateName",oprateLog.getOperateName()!=null?oprateLog.getOperateName().toString():"");
				
				}
			}
			//转换为json格式
			Map<String,Object> map = new LinkedHashMap<String,Object>(2);
			map.put("total", pageBean.getTotalRecord());
			map.put("rows", rows);
			response.setCharacterEncoding("utf-8");
			JSONObject json = JSONObject.fromObject(map);
			System.out.println(json.toString());
			response.getWriter().write(json.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OperateLog getOpLog() {
		return opLog;
	}

	public void setOpLog(OperateLog opLog) {
		this.opLog = opLog;
	}

	

	public OperateLog getOprateLog() {
		return oprateLog;
	}




	public void setOprateLog(OperateLog oprateLog) {
		this.oprateLog = oprateLog;
	}




	public List<?> getOpLogList() {
		return opLogList;
	}




	public void setOpLogList(List<?> opLogList) {
		this.opLogList = opLogList;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Long getOperateType() {
		return operateType;
	}




	public void setOperateType(Long operateType) {
		this.operateType = operateType;
	}




	public String getOpTime() {
		return opTime;
	}




	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}




	public String getOperateName() {
		return operateName;
	}




	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}




	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	
	
	
}
