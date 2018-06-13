package com.htcf.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Sjzd;
import com.htcf.service.ISjzdService;
import com.htcf.util.StringUtil;


@Controller("sjzdAction")
@Scope("prototype")
public class SjzdAction extends BaseAction {
	@Autowired
	private ISjzdService sjzdService;
	
	private List<Sjzd> onLevSjzdList=new ArrayList<Sjzd>(); 
	
	private List<Sjzd> childSjzdList=new ArrayList<Sjzd>(); 
	
	private String sid ;	//数据字典ID
	
	private Sjzd sjzd;	//数据字典实体
	
	private Sjzd parentSjzd;	//数据字典父节点

	private String content;
	/**
	 * 进入数据字典首页面
	 * @author wsg
	 * @return
	 */
	public String view(){
		onLevSjzdList = this.sjzdService.getSjzdListByLayer("1");
		System.out.println("数据字典的长度:"+onLevSjzdList.size());
		return "viewInfo";
	}
	
	
	public String loadSjzd(){
		HttpServletResponse response = this.getHttpServletResponse();
		//获取数据字典的下拉列表
		if(StringUtil.isNotBlank(sid)){
			childSjzdList = this.sjzdService.getSjzdListByFid(sid);
			StringBuffer childJson = new StringBuffer();
			childJson.append("[");
			for(int i=0;i<childSjzdList.size();i++){
				Sjzd s = childSjzdList.get(i);
				if(i!=childSjzdList.size()-1){
					childJson.append("{id:").append(s.getId())
						.append(",state:'closed',").append("text:'").append(s.getContent())
						.append("'},");
				}else{
					childJson.append("{id:").append(s.getId())
						.append(",state:'closed',").append("text:'").append(s.getContent())
						.append("'}");
				}
			}
			childJson.append("]");
			try {
				//解决ajax从action传递数据到jsp页面中文乱码问题
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(childJson.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	/**
	 * 查看数据字典详情
	 * @author wsg
	 * @return
	 */
	public String show(){
		sjzd = this.sjzdService.getSjzdListById(sid);
		parentSjzd = this.sjzdService.getSjzdListById(String.valueOf(sjzd.getFid()));
		return "showInfo";
	}
	
	/**
	 * 增加数据字典
	 * @author wsg
	 * @return
	 */
	public String add(){
		if(StringUtil.isNotBlank(sid)){
			sjzd = this.sjzdService.getSjzdListById(sid);
		}
		return "addInfo";
	}
	
	/**
	 * 保存数据字典
	 * @author wsg
	 * @return
	 */
	public String save(){
		HttpServletResponse response = this.getHttpServletResponse();
		boolean returnInfo = false;
		//判断是否有父节点
		if(StringUtil.isNotBlank(sid)){
			//获得父数据字典
			Sjzd parentSjzd = this.sjzdService.getSjzdListById(sid);
			sjzd.setFid(Long.valueOf(sid));
			sjzd.setIsLeaf("是");
			sjzd.setLayer(parentSjzd.getLayer()+1);
			parentSjzd.setIsLeaf("否");
			returnInfo = this.sjzdService.saveSjzd(sjzd);
		}else{
			//是根节点
			sjzd.setFid(Long.valueOf(0));
			sjzd.setIsLeaf("是");
			sjzd.setLayer(Long.valueOf(1));
			returnInfo = this.sjzdService.saveSjzd(sjzd);
		}
		if(returnInfo){
		
		}else{
			
		}
		try{
			response.getWriter().print("<script type='text/javascript'>window.parent.location.reload()</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 保存数据字典
	 * @author wsg
	 * @return
	 */
	public String edit(){
		sjzd = this.sjzdService.getSjzdListById(sid);
		parentSjzd = this.sjzdService.getSjzdListById(String.valueOf(sjzd.getFid()));
		return "editInfo";
	}
	
	
	/**
	 * 保存修改后的数据字典
	 * @author wsg
	 * @return
	 */
	public String saveEdit(){
	    HttpServletResponse response = this.getHttpServletResponse();
		boolean returnInfo = false;
		Sjzd s= this.sjzdService.getSjzdListById(sid);
	    s.setContent(sjzd.getContent());
	    s.setBz(sjzd.getBz());
	    returnInfo = this.sjzdService.updateSjzd(s);
		if(returnInfo){
			
		}else{
			
		}
		try {
			response.getWriter().print("<script type='text/javascript'>window.parent.location.reload()</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 删除数据字典
	 * @author wsg
	 * @return
	 */
	public String delete(){
	    HttpServletResponse response = this.getHttpServletResponse();
	    Sjzd s = this.sjzdService.getSjzdListById(sid);
	    List<Sjzd> list = new ArrayList<Sjzd>();
	    Sjzd parentSjzd = this.sjzdService.getSjzdListById(String.valueOf(s.getFid()));
		List<Sjzd> childList = this.sjzdService.getSjzdListByFid(String.valueOf(s.getFid()));
	    if(childList.size()==1&&parentSjzd!=null){
			parentSjzd.setIsLeaf("是");
			this.sjzdService.updateSjzd(parentSjzd);
		}
	    if("是".equals(s.getIsLeaf())){
    		this.sjzdService.deleteSjzd(s);
    	}else{
    		deleteSjzd(s, list);
    		for(int i=0;i<list.size();i++){
    			Sjzd o = list.get(i);
    			this.sjzdService.deleteSjzd(o);
    		}
			this.sjzdService.deleteSjzd(s);
    	}
		onLevSjzdList = this.sjzdService.getSjzdListByLayer("1");
		return "viewInfo";
	}

	//递归删除数据字典
	public void deleteSjzd(Sjzd s,List<Sjzd> list){
    	List<Sjzd> childSjzdList= this.sjzdService.getSjzdListByFid(String.valueOf(s.getId()));
    	for(int i=0;i<childSjzdList.size();i++){
    		Sjzd sjzd = childSjzdList.get(i);
    		list.add(sjzd);
    		deleteSjzd(sjzd, list);
    	}
	}
	
	//查询数据字典
	public String searchSjzd(){
		if(StringUtil.isNotBlank(content)){
			onLevSjzdList = this.sjzdService.getListByContent(content);
		}else{
			onLevSjzdList = this.sjzdService.getSjzdListByLayer("1");
		}
		return "viewInfo";
	}
	
	/**getter方法和setter方法*/
	public List<Sjzd> getOnLevSjzdList() {
		return onLevSjzdList;
	}

	public void setOnLevSjzdList(List<Sjzd> onLevSjzdList) {
		this.onLevSjzdList = onLevSjzdList;
	}


	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}


	public List<Sjzd> getChildSjzdList() {
		return childSjzdList;
	}


	public void setChildSjzdList(List<Sjzd> childSjzdList) {
		this.childSjzdList = childSjzdList;
	}


	public Sjzd getSjzd() {
		return sjzd;
	}


	public void setSjzd(Sjzd sjzd) {
		this.sjzd = sjzd;
	}


	public Sjzd getParentSjzd() {
		return parentSjzd;
	}

	public void setParentSjzd(Sjzd parentSjzd) {
		this.parentSjzd = parentSjzd;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
