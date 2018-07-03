package com.htcf.action;
import java.util.ArrayList;
import java.util.List;

import com.htcf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.Sjzd;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.entity.UserRole;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISjzdService sjzdService;
	
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IOperateLogService operateLogService;
	/****/
	
	
	private List<Object[]> ExamEasyUIList=new ArrayList<Object[]>();
	
	private List<Object[]> KpProctorList=new ArrayList<Object[]>();
	private List<?> khList;
	
	private String stuClass;
	

	/****/
	private User user=new User();
	private UserForm userform=new UserForm();
	private UserRole ur=new UserRole();
	
	private List<Object[]> userList=new ArrayList<Object[]>();
	
	private List<Role> roleList=new ArrayList<Role>();
	private List<?> deptmentList;
	private List<?> classList;
	private String roleIds;
	
	private String xtglDisabled;	//隐藏系统管理
	
	private String userid;    //密码修改
	
	private String pwd2;
	
	private List<Menu> oneLevMenus;	//一级菜单

	private String page;
	
	private String rows;
	
	private String queryParams;
	
	private String name;
	private String policeNo;
	private String role;
	private String department;
	private String userclassno;
	

	private List<Sjzd> orgList = new ArrayList<Sjzd>();
	
	private String IndexCon;
	
//	public String loginSignIn(){
//		session.clear();
//		
//		System.out.println("身份证号登录="+user.getUserId());
//		UserForm newUser=userService.fetchUserByName(user);
//		//User users=userService.fetchUsersByName(user);
//		if(newUser !=null){
//			addLog(newUser);
//			List<Menu> menuList=menuService.retrieveMenusByUser(newUser);
//			Map<String,List<Menu>> menusMap=new HashMap<String,List<Menu>>();
//			for (Menu menu : menuList) {
//				menusMap.put(menu.getCode(), menu.getSubList());
//				if("systemSet".equals(menu.getCode())){
//					for(Menu m:menu.getSubList()){
//					}
//				}
//			}
//			session.put("userForm", newUser);
//			session.put("user", newUser);//users
//			session.put("menuList", menuList);
//			session.put("menusMap", menusMap);
//			
//			if("教官".equals(newUser.getRolename())){
//				//查询该教官有无考试情况
//				String ksmc="";
//				String ksrq="";
//				String kslx="";
//				String bjmc="";
//				String username=newUser.getId();
//				String rolename="教官";
//				//要查待监考的记录-取大于当天的监考记录
//				khList = xlkhService.fecthKhList(ksmc, ksrq, kslx, bjmc, username, rolename, pageBean);		
//				if(khList.size()!=0){
//					System.out.println("监考记录khList()="+khList.size());
//					String date=this.getNowDate();
//					String time=this.getNowTime2();
//					String datetime=date+" "+time;
//					System.out.println("date="+date);
//					System.out.println("time="+time);
//					System.out.println("datetime="+datetime);
//					XlkhForm xlkhForm = null;
//					for(int i=0;i<khList.size();i++){
//						xlkhForm = new XlkhForm();
//						//now>=exdate && now-long <= exdte
//						xlkhForm = (XlkhForm) khList.get(i);
//						
//						System.out.println("考试日期="+xlkhForm.getExdate()+"，考试时长="+xlkhForm.getExlongtime());
//						//开始时间   现在时间    结束时间
//						int comp1=xlkhForm.getExdate().compareTo(datetime);
//						int comp2=datetime.compareTo(getStopTime(date,time,xlkhForm.getExdate(),xlkhForm.getExlongtime()));
//							
//						System.out.println("此时是否有考试="+(comp1<0 && comp2<0));
//						if(comp1<0 && comp2<0){
//							System.out.println("有考试");
//							//有则查询是否有监考班级
//							System.out.println("班级编号="+xlkhForm.getClassno());
//							stuClass=xlkhForm.getClassno();
//							//判断此场考试是否还有学员未考，否则不需要进入
//							int wkrs = xlkhService.fetchKhWkrs(xlkhForm.getExno(), stuClass);
//							System.out.println("考试人数="+wkrs);
//							if(wkrs == 0){
//								System.out.println("此场考试学生人数为0");
//								//继续循环
//								if(i==khList.size()-1){
//									return "success";
//								}else{
//									continue;
//								}
//							}else{
//								session.put("stuClass", stuClass);
//								session.put("exName", xlkhForm.getExno());
//								session.put("exNameAll", xlkhForm.getExno());
//								return "toFullExamSuc";
//							}
//						}else{
//							System.out.println("对不起，今天您没有任何需要监考的信息。");
//							//继续循环
//							if(i==khList.size()-1){
//								return "success";
//							}else{
//								continue;
//							}
//						}
//					}
//				}else{
//					System.out.println("对不起，您没有任何需要监考的信息。");
//					return "success";
//				}
//			}else{
//				System.out.println("非教官登录");
//			}
//			return "success";
//		}else{
//			message="对不起，您没有权限登录本系统，请向管理员申请账号。";
//			return "input";
//		}
//	}
//	
//	
//	//登录
//	public String login(){
//		session.clear();
//		System.out.println("用户名登录="+user.getUserName());
//		UserForm newUser=userService.fetchUserByName(user);
//		//User users=userService.fetchUsersByName(user);
//		if(newUser !=null){
//			if(!newUser.getPassword().equals(user.getPassword())){
//				message="密码不正确";
//				return "input";
//			}
//			addLog(newUser);
//			List<Menu> menuList=menuService.retrieveMenusByUser(newUser);
//			Map<String,List<Menu>> menusMap=new HashMap<String,List<Menu>>();
//			for (Menu menu : menuList) {
//				//System.out.println("code=="+menu.getCode());
//				menusMap.put(menu.getCode(), menu.getSubList());
//				if("systemSet".equals(menu.getCode())){
//					for(Menu m:menu.getSubList()){
//						//System.out.println(m.getMenuName());
//					}
//				}
//			}
//			//System.out.println("角色="+newUser.getRole().getRoleName());
//			session.put("userForm", newUser);
//			session.put("user", newUser);//users
//			session.put("menuList", menuList);
//			session.put("menusMap", menusMap);
//			
//			
//			//属于管理员用户
////			if("system".equals(user.getUserName()) || "admin".equals(user.getUserName())){
////				xtglDisabled = "false";
////			}
////			Menu menu = new Menu();
////			menu.setMenuLevel(Long.valueOf(1));
////			oneLevMenus = this.menuService.retrieveMenusByLevel(menu);
////			System.out.println(newUser.getRole().getRoleName());
//			System.out.println(newUser.getRolename());
//			if("教官".equals(newUser.getRolename())){
////				System.out.println("user.getIsSystem()="+user.getIsSystem());
////				if("on".equals(user.getIsSystem())){
//					//查询该教官有无考试情况
//					String ksmc="";
//					String ksrq="";
//					String kslx="";
//					String bjmc="";
//					String username=newUser.getId();
//					String rolename="教官";
//					//要查待监考的记录-取大于当天的监考记录
//					khList = xlkhService.fecthKhList(ksmc, ksrq, kslx, bjmc, username, rolename, pageBean);		
//					if(khList.size()!=0){
//						System.out.println("监考记录khList()="+khList.size());
//						String date=this.getNowDate();
//						String time=this.getNowTime2();
//						String datetime=date+" "+time;
//						System.out.println("date="+date);
//						System.out.println("time="+time);
//						System.out.println("datetime="+datetime);
//						XlkhForm xlkhForm = null;
//						for(int i=0;i<khList.size();i++){
//							xlkhForm = new XlkhForm();
//							//now>=exdate && now-long <= exdte
//							xlkhForm = (XlkhForm) khList.get(i);
//							
//							System.out.println("考试日期="+xlkhForm.getExdate()+"，考试时长="+xlkhForm.getExlongtime());
//							//开始时间   现在时间    结束时间
//							int comp1=xlkhForm.getExdate().compareTo(datetime);
//							int comp2=datetime.compareTo(getStopTime(date,time,
//									xlkhForm.getExdate(),
//									xlkhForm.getExlongtime()));
//							
//							System.out.println("此时是否有考试="+(comp1<0 && comp2<0));
//							if(comp1<0 && comp2<0){
//								System.out.println("有考试");
//								//有则查询是否有监考班级
//								System.out.println("班级编号="+xlkhForm.getClassno());
//								stuClass=xlkhForm.getClassno();
//								
//								//判断此场考试是否还有学员未考，否则不需要进入
//								int wkrs = xlkhService.fetchKhWkrs(xlkhForm.getExno(), stuClass);
//								System.out.println("考试人数="+wkrs);
//								if(wkrs == 0){
//									System.out.println("此场考试学生人数为0");
//									//继续循环
////									if(i==khList.size()-1){
////										return "success";
////									}else{
////										continue;
////									}
//								}else{
//									session.put("stuClass", stuClass);
//									session.put("exName", xlkhForm.getExno());
//									session.put("exNameAll", xlkhForm.getExno());
//									//查询该考试的信息//根据ID查询该考试的信息
//	//								kpexam=xlkhService.fetchJkList(classno,exno);
//	//								KpExam=this.iffService.getKpExamInfoUseID(xlkhForm.getExno());
//									//根据所选择的范围确定名单。(在异步的方法中)
//									return "toFullExamSuc";
//									//return "khpfxzksSuc";
//								}
//							}else{
//							//	message="对不起，今天您没有任何需要监考的信息。";
//								System.out.println("对不起，今天您没有任何需要监考的信息。");
//								//继续循环
////								if(i == khList.size()-1){
//////									return "success";
//////									return "input";
//////									return "notExamSuc";
////								}else{
////									continue;
////								}
//							}
//						}
//					}else{
////						message="对不起，您没有任何需要监考的信息。";
//						System.out.println("对不起，您没有任何需要监考的信息。");
//						//一场考试都没有，所以属于没有考试,跳到提示页面
////						return "input";
//						return "success";
//					}
////					return "toFullExamSuc";
////				}
//			}else{
//				System.out.println("非教官登录");
//			}
//			
//			return "success";
//		}else{
//			message="用户名不正确";
//			return "input";
//		}
//		
//		
//	}
//	//数字证书登录
//	public String loginuk(){
//		String v=(String) session.get("ukinfo");
//		String a[]=v.split(",");
//		String m=a[0];
//		String m1[]=m.split("=");
//		String m2[]=m.split(" ");
//		//System.out.println(m2[1]);
//		user.setUserId(m2[1]);
//		UserForm newUser=userService.fetchUserByUserID(user);
//		//User newUser=userService.fetchUsersByUserID(user);
//		//数字证书登录获取菜单
//		List<Menu> menuList=menuService.retrieveMenusByUser(newUser);
//		Map<String,List<Menu>> menusMap=new HashMap<String,List<Menu>>();	
//		for (Menu menu : menuList) {
//			//System.out.println("code=="+menu.getCode());
//			menusMap.put(menu.getCode(), menu.getSubList());
//		}
//		session.put("userForm", newUser);
//		session.put("user", user);
//		session.put("menuList", menuList);
//		session.put("menusMap", menusMap);
//		return "success";
//	}
//	
//	
//	public String toIndex(){
//		//System.out.println("toIndex");
//		String reT="";
//		
//		userform=(UserForm)session.get("userForm");
//		//System.out.println("toIndex="+user.getUserName());
//		if(userform!=null){
//			reT="toIndexSuc";
//		}else{
//			reT="logOut";
//		}
//		
//		return reT;
//	}
//	public String toHomePage(){
//		return "success";
//	}
//	
//	private void addLog(UserForm user){
//		
//		HttpServletRequest req= this.getHttpServletRequest();
//		
//		String ip =  this.getIpAddr(req); 
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
//		OperateLog opLog=new OperateLog();
//		opLog.setOperateCondition("select * from base_user t where t.username='"+user.getUserName()+"' and t.password='"+user.getPassword()+"' ");
//		opLog.setOperateName("用户登录");
//		opLog.setOpTime(sdf.format(new Date()));
//		opLog.setOperateType(new Long(0));
//		opLog.setTerminalId(ip);
//		System.out.println("user.getUserId()="+user.getUserId());
//		opLog.setOrganization("");
//		opLog.setOrganizationId("");
//		opLog.setUserName(user.getName());
//		opLog.setUserId(user.getUserId());
//		opLog.setOperateResult(new Long(1));
//	
//		operateLogService.add(opLog);
//	}
//	
//	//新增用户
//	public String add(){
//		
//		if(StringUtils.hasLength(method)){
//			
//			roleList=roleService.retrieveAllRoles();
//			//查出部门
//			deptmentList = typzService.fetchDeptment();
//			//查出班级
//			classList = typzService.fetchClassname();
//			
//			return "toUserAdd";
//			
//		}
//		
//		System.out.println("角色ID="+user.getRole().getId());
//		userService.addUser(user);
//		
//		return "toUserList";
//		
//	}
//	
//	
//	public String list(){
//		//HttpServletRequest request= this.getHttpServletRequest();
//		//pageBean=this.processPageBean(request);
//		//orgList = this.sjzdService.getSjzdListByFid("186");
//		//查出部门
//		deptmentList = typzService.fetchDeptment();
//		//查出班级
//		classList = typzService.fetchClassname();
//		
//		roleList =roleService.retrieveAllRoles();
//		//userList=this.userService.retrieveUsersByCondtions(user, pageBean);
//		return "userList";
//		
//	}
//	
//	
//	/**
//	 * 
//	 *Description:加载用户表
//	 * @return
//	 * @author:wsg
//	 * @2014-6-16下午4:56:16
//	 */
//	public void loadUserList(){
//		HttpServletRequest request = this.getHttpServletRequest();
//		HttpServletResponse response = this.getHttpServletResponse();
//		//分页显示
//		int pageNo = Integer.parseInt(page)-1;
//		int pageSize = Integer.parseInt(rows);
//
//		pageBean=this.processPageBean(request);
//		pageBean.setPageRecord(pageSize);
//		pageBean.setCurPage(pageNo+1);
//		HttpSession session = this.getHttpSession();
//		String flag = (String)session.getAttribute("flag");
//		String backPage = (String)session.getAttribute("backPage");
//		if("red".equals(flag)) {
//			request.setAttribute("flag", flag);
//			request.setAttribute("curPage", backPage);
//			session.setAttribute("flag", "");
//			session.setAttribute("backPage", "");
//		} 
//		user.setDepartment(department);
//		user.setName(name);
//		user.setPoliceNo(policeNo);
//		user.setRoleId(role);
//		user.setUserclassno(userclassno);
//		System.out.println("userid="+userid);
//		user.setUserId(userid);
//		
//		
//		userList=this.userService.retrieveUsersByCondtions(user, pageBean);
//		Map<String, Object>[] rows =null;
//		try{
//			rows = new LinkedHashMap[userList.size()];
//		}catch (Exception e) {
//			rows = new LinkedHashMap[0];
//		}
//		if(userList!=null&&userList.size()>0){
//			for (int i = 0; i < userList.size(); i++) {
//				Object[] obj = userList.get(i);
//				rows[i] = new LinkedHashMap<String, Object>();
//				rows[i].put("id",obj[0]!=null?obj[0].toString():"");
//				rows[i].put("name",obj[1]!=null?obj[1].toString():"");
//				rows[i].put("policeNo",obj[11]!=null?obj[11].toString():"");
//				rows[i].put("roleName",obj[23]!=null?obj[23].toString():"");
//				rows[i].put("department",obj[7]!=null?obj[7].toString():"");
//				rows[i].put("classname",obj[24]!=null?obj[24].toString():"");
//				rows[i].put("userid",obj[12]!=null?obj[12].toString():"");
//			} 
//		}
//		//转换为json格式
//		Map<String,Object> map = new LinkedHashMap<String,Object>(2);
//		map.put("total", pageBean.getTotalRecord());
//		map.put("rows", rows);
//		response.setCharacterEncoding("utf-8");
//		JSONObject json = JSONObject.fromObject(map);
//		try {
//			response.getWriter().write(json.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public String checkUserName(){
//		user=userService.fetchUsersByName(user);
//		 
//		String result="";
//		 
//	 	HttpServletResponse response=this.getHttpServletResponse();
//	 
//		response.setContentType("text/plain;charset=utf-8");
//		
//		PrintWriter out=null;
//		try {
//			out = response.getWriter();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		result=(user ==null)?"1":"0";
//		out.print(result);
//		out.flush();
//		return null;
//		
//	}
//	
//	//详情
//	public String showDetail(){
//		userList = (List<Object[]>) userService.fetchUserByID(user);
//		//user=userService.fetchUserById(user);
//		//roleList=roleService.retrieveRolesByUser(user);
//		return "toUserDetail";
//	}
//	
//	//修改
//	public String edit(){
//		System.out.println("主键="+user.getId());
//		if(StringUtils.hasLength(method)){
//			user=userService.fetchUserById(user);
//			System.out.println("姓名="+user.getName());
//			roleList=roleService.retrieveAllRoles();
//			//查出部门
//			deptmentList = typzService.fetchDeptment();
//			//查出班级
//			classList = typzService.fetchClassname();
//			return "toUserEdit";
//		}
//		userService.editUser(user);
//		
//		return "toUserList";
//	}
//	
//	
//	
//	//删除
//	public String delete(){
//		userService.deleteUser(user);
//		return "toUserList";
//	}
//
//	//校验用户名
//	public String checkUser(){
//		
//		 try {
//			 
//			 user.setUserName(new String(user.getUserName().getBytes("ISO8859-1"),"UTF-8"));
//				
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		
//		 User newUser=userService.fetchUser(user);
//		 
//		
//		 String result="";
//		 
//		 
//	 	HttpServletResponse response=this.getHttpServletResponse();
//	 
//		response.setContentType("text/plain;charset=utf-8");
//		
//		PrintWriter out=null;
//		try {
//			out = response.getWriter();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		result=(newUser ==null)?"1":"0";
//		out.print(result);
//		out.flush();
//		return null;
//		
//	}
//	
//	
//	//退出
//	public String logOut(){
//		
//		session.clear();
//		
//		return "logOut";
//		
//		
//	}
//	
//	
//	public  String getIpAddr(HttpServletRequest request) { 
//		
//		String ip = request.getHeader("x-forwarded-for");     
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     	   
//			ip = request.getHeader("Proxy-Client-IP");     	     }     	
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     	    
//			ip = request.getHeader("WL-Proxy-Client-IP");     	      }     	
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     	   
//			ip = request.getRemoteAddr();     	  
//			}     	   
//			return ip;     
//		}    
//	
//	
//	//密码修改
//	public String savePwd(){
//		User user = (User)this.getHttpSession().getAttribute("user");
//		//System.out.println("--------------------"+user.getId());
//		//System.out.println("--------------------"+user.getPassword());
//		//System.out.println("--------------------"+pwd2);
//		//String userid = user.getId();
//		boolean Pwd = this.userService.updatePwd(userid,pwd2);
//		
//		if(Pwd){
//			message = "<script type='text/javascript'>alert('修改密码成功！');window.close();window.opener.location.reload()</script>";
//			return "pwd";
//		}else{
//			message = "<script type='text/javascript'>alert('修改密码失败！请联系管理员')</script>";
//			return "pwd";
//		}
//	}
//	
//	public String getNowDate(){
//		Calendar c = Calendar.getInstance();
//		Date date = c.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
//		String datestr = dateFormat.format(date);
//		return datestr;
//	}
//	
//	public String getNowTime2(){
//		Calendar c = Calendar.getInstance();
//		Date date = c.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");//可以方便地修改日期格式
//		String datestr = dateFormat.format(date);
//		return datestr;
//	}
//	
//	public String getStopTime(String date,String time,String exdate,String howlong){
//		String[] exda=exdate.split(" ");
//		String[] t=exda[1].split(":");
//		String[] l=howlong.split(":");
//		//秒部分
//		String m=String.valueOf(Integer.valueOf(t[2])+Integer.valueOf(l[2]));
//		int mm=0;
//		if(Integer.valueOf(m)>= 60){
//			mm++;
//			m=String.valueOf(Integer.valueOf(m)-60);
//		}
//		if(m.length()==1){
//			m="0"+m;
//		}
//		//分部分
//		String f=String.valueOf(Integer.valueOf(t[1])+Integer.valueOf(l[1])+mm);
//		int ff=0;
//		if(Integer.valueOf(f)>= 60){
//			ff++;
//			f=String.valueOf(Integer.valueOf(f)-60);
//		}
//		if(f.length()==1){
//			f="0"+f;
//		}
//		//时部分
//		String s=String.valueOf(Integer.valueOf(t[0])+Integer.valueOf(l[0])+ff);
//		int ss=0;
//		if(Integer.valueOf(s)>= 24){
//			ss++;
//			s=String.valueOf(Integer.valueOf(s)-24);
//			//得到明天的日期
//			exda[0]=getTomorrowDate(exdate);
//		}
//		if(s.length()==1){
//			s="0"+s;
//		}
//		
//		System.out.println(exda[0]+" "+s+":"+f+":"+m);
//		
//		return exda[0]+" "+s+":"+f+":"+m;
//	}
//	
//
//	
//	
//	public static String getTomorrowDate(String sdd){
//		String[] sddStr=sdd.split(" ");
//		sdd=sddStr[0];
//		System.out.println("sdd="+sdd);
//		//1.由用户输入日期
//		String input = sdd; //这个客户端输入
//		//把用户输入的日期转成 java 日期类
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = null;
//		try {
//			d1 = df.parse(input);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		//输出结果
//		Calendar cal = Calendar.getInstance();
//		if(d1.equals(null)){
//			
//		}else{
//			cal.setTime(d1); 
//		}
//		cal.add(cal.DATE, 1);//日期往后增加一天。
//		Date d = cal.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
//		String moday1 = dateFormat.format(d);
//		return moday1;
//	}
//	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	public IMenuService getMenuService() {
		return menuService;
	}



	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List<Object[]> getUserList() {
		return userList;
	}

	public void setUserList(List<Object[]> userList) {
		this.userList = userList;
	}

	public UserRole getUr() {
		return ur;
	}


	public void setUr(UserRole ur) {
		this.ur = ur;
	}


	public IRoleService getRoleService() {
		return roleService;
	}


	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}




	public String getRoleIds() {
		return roleIds;
	}




	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}


	public List<Role> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}




	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}




	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}

	public String getXtglDisabled() {
		return xtglDisabled;
	}

	public void setXtglDisabled(String xtglDisabled) {
		this.xtglDisabled = xtglDisabled;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public List<Menu> getOneLevMenus() {
		return oneLevMenus;
	}

	public void setOneLevMenus(List<Menu> oneLevMenus) {
		this.oneLevMenus = oneLevMenus;
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

	public String getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliceNo() {
		return policeNo;
	}

	public void setPoliceNo(String policeNo) {
		this.policeNo = policeNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public ISjzdService getSjzdService() {
		return sjzdService;
	}

	public void setSjzdService(ISjzdService sjzdService) {
		this.sjzdService = sjzdService;
	}

	public List<Sjzd> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Sjzd> orgList) {
		this.orgList = orgList;
	}

	public String getIndexCon() {
		return IndexCon;
	}

	public void setIndexCon(String indexCon) {
		IndexCon = indexCon;
	}

	public List<Object[]> getExamEasyUIList() {
		return ExamEasyUIList;
	}

	public void setExamEasyUIList(List<Object[]> examEasyUIList) {
		ExamEasyUIList = examEasyUIList;
	}



	public List<Object[]> getKpProctorList() {
		return KpProctorList;
	}

	public void setKpProctorList(List<Object[]> kpProctorList) {
		KpProctorList = kpProctorList;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public List<?> getDeptmentList() {
		return deptmentList;
	}

	public void setDeptmentList(List<?> deptmentList) {
		this.deptmentList = deptmentList;
	}

	public String getUserclassno() {
		return userclassno;
	}

	public void setUserclassno(String userclassno) {
		this.userclassno = userclassno;
	}

	public List<?> getClassList() {
		return classList;
	}

	public void setClassList(List<?> classList) {
		this.classList = classList;
	}

	
}
