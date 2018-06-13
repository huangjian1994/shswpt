package com.htcf.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Cxzd;
import com.htcf.entity.Sjzd;
import com.htcf.service.ICxzdService;
import com.htcf.service.ISjzdService;


@Controller("cxzdAction")
@Scope("prototype")
public class CxzdAction extends BaseAction {
	@Autowired
	private ICxzdService cxzdService;
	@Autowired
	private ISjzdService sjzdService;
	
	private List cxzdList;
	private List<Sjzd> sjzdList;
	private Cxzd cxzd;
	/**
	 * 进入查询字段列表
	 * @author wsg
	 * @return
	 */
	public String view(){
		HttpServletRequest request = this.getHttpServletRequest();
		pageBean = this.processPageBean(request);
		pageBean.setPageRecord(15);
		cxzdList = this.cxzdService.getCxzdList(pageBean);
		return "viewInfo";
	}
	
	/**
	 * 增加查询字段
	 * @author wsg
	 * @return
	 */
	public String add(){
		sjzdList = this.sjzdService.getSjzdListByFid("0");
		return "addInfo";
	}
	
	
	/**
	 * 保存查询字段
	 * @author wsg
	 * @return
	 */
	public String save(){
		System.out.println(cxzd.getMenu() + cxzd.getSid());
		this.cxzdService.saveInfo(cxzd);
		HttpServletResponse response = this.getHttpServletResponse();
		try {
			 response.getWriter().print("<script>window.parent.wclose();</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**getter方法setter方法*/
	public List getCxzdList() {
		return cxzdList;
	}
	public void setCxzdList(List cxzdList) {
		this.cxzdList = cxzdList;
	}

	public List<Sjzd> getSjzdList() {
		return sjzdList;
	}

	public void setSjzdList(List<Sjzd> sjzdList) {
		this.sjzdList = sjzdList;
	}

	public Cxzd getCxzd() {
		return cxzd;
	}

	public void setCxzd(Cxzd cxzd) {
		this.cxzd = cxzd;
	}
	
	
}
