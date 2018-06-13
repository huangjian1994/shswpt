package com.htcf.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

/**
 * 分页JavaBean
 * 
 * 
 */
public class PageBean {
	
	
	/* 当前页 */
	private int curPage = 1;

	/* 总记录数 */
	private int totalRecord = 0;

	/* 每页记录数 */
	private int pageRecord = 10;

	/* 是否分页，默认分页 */
	private boolean paginate = true;

	/* 请求的URL */
	private String url;

	/* 请求中的参数 */
	private Map<String, String[]> parameters = new HashMap<String, String[]>();

	public PageBean() {
		super();
	}

	public PageBean(HttpServletRequest request) {
		super();
		this.setRequest(request);
	}

	/**
	 * 使用HttpServletRequest对象对分页Bean进行初始化
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void setRequest(HttpServletRequest request) {
		String flag = (String)request.getAttribute("flag");
		if("red".equals(flag)) {
			this.setCurPage((String)request.getAttribute("curPage"));// 从请求中获取当前页
			this.setPageRecord((String)request.getAttribute("pageRecord"));// 从请求中获取页大小
			this.setPaginate((String)request.getAttribute("paginate"));// 获取用来判断是否分页的参数
			this.setUrl(request.getContextPath() + request.getServletPath());// 获取表示请求资源的URL
			this.setParameters(new HashMap<String, String[]>(request
					.getParameterMap()));// 获取请求中的所有参数
		} else {
			this.setCurPage(request.getParameter("curPage"));// 从请求中获取当前页
			this.setPageRecord(request.getParameter("pageRecord"));// 从请求中获取页大小
			this.setPaginate(request.getParameter("paginate"));// 获取用来判断是否分页的参数
			this.setUrl(request.getContextPath() + request.getServletPath());// 获取表示请求资源的URL
			this.setParameters(new HashMap<String, String[]>(request
					.getParameterMap()));// 获取请求中的所有参数
		}
	}

	/**
	 * true表示进行分页
	 * 
	 * @return
	 */
	public boolean isPaginate() {
		return paginate;
	}

	/**
	 * 设置是否分页true分页，false不分页
	 * 
	 * @param paginate
	 */
	public void setPaginate(boolean paginate) {
		this.paginate = paginate;
	}

	/**
	 * 设置是否分页true分页，false不分页
	 * 
	 * @param paginate
	 */
	public void setPaginate(String paginate) {
		if (null != paginate && paginate.trim().equalsIgnoreCase("false")) {
			this.setPaginate(false);
		} else {
			this.setPaginate(true);
		}
	}

	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		if (curPage > 1) {
			this.curPage = curPage;
		}
	}

	public void setCurPage(String curPage) {
		if (null == curPage || curPage.trim().equals("")) {
			return;
		}
		int acurPage = Integer.parseInt(curPage);
		this.setCurPage(acurPage);
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public void setPageRecord(String pageRecord) {
		if (null != pageRecord && !pageRecord.trim().equals("")) {
			this.pageRecord = Integer.parseInt(pageRecord);
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		if (null != totalRecord && !totalRecord.trim().equals("")) {
			this.totalRecord = Integer.parseInt(totalRecord);
		}
	}

	/**
	 * 返回下一页页码
	 * 
	 * @return
	 */
	public int getNextPageNumber() {
		int nextPageNumber = this.curPage + 1;
		if (nextPageNumber > this.getMaxPageNumber()) {
			nextPageNumber = this.getMaxPageNumber();
		}
		return nextPageNumber;
	}

	/**
	 * 返回上一页页码
	 * 
	 * @return
	 */
	public int getPreviousPageNumber() {
		int previousPageNumber = this.curPage - 1;
		if (previousPageNumber < 1) {
			previousPageNumber = 1;
		}
		return previousPageNumber;
	}

	/**
	 * 返回最大页码编号
	 * 
	 * @return
	 */
	public int getMaxPageNumber() {
		int maxPageNumber = 1;
		if (this.totalRecord > this.pageRecord) {
			if (0 == this.totalRecord % this.pageRecord) {
				maxPageNumber = this.totalRecord / this.pageRecord;
			} else {
				maxPageNumber = this.totalRecord / this.pageRecord + 1;
			}
		}
		return maxPageNumber;
	}

	/**
	 * 获取起始记录下标
	 * 
	 * @return
	 */
	public int getStartRecordIndex() {
		return this.pageRecord * (this.curPage - 1);
	}

	/**
	 * 获取结束记录下标
	 * 
	 * @return
	 */
	public int getEndRecordIndex() {
		int end = this.pageRecord * this.curPage - 1;
		if (end > (this.totalRecord - 1)) {
			end = (this.totalRecord - 1);
		}
		return end;
	}

	@SuppressWarnings("unchecked")
	public String toString() {
		// 保存请求的参数到一个表单对象中，以供下次查询使用
		StringBuffer bf = new StringBuffer();
		bf.append("<form name='pageBeanForm' action='" + this.getUrl()
				+ "' method='post'>");
		bf.append("<input type='hidden' name='curPage' value=''/>");// 当前页是目前是空，但在点击分页按钮时会进行设置
		Map<String, String[]> parameters = this.getParameters();// 请求中的所有参数
		String paramName = null;
		String[] paramValues = null;
		Iterator it = parameters.keySet().iterator();
		while (it.hasNext()) {
			paramName = (String) it.next();// 参数名
			if ("curPage".equals(paramName)) {
				continue;// 把当前页参数忽略掉
			}
			paramValues = parameters.get(paramName);// 参数值
			for (int i = 0; null != paramValues && i < paramValues.length; i++) {
				bf.append("<input type='hidden' name='" + paramName
						+ "' value='" + paramValues[i] + "'/>");
			}
		}
		bf.append("</form>");
		bf.append("<br /><table class='tttt' align='center' style='border:none;width:600px;table-layout : auto;'>");
		// 显示分页按钮
		bf.append("<tr><td  style='border:0px solid red:width:550px' >");
		bf.append("<a  plain='true'  class='easyui-linkbutton' >");
		bf.append("<strong>每页 " + this.getPageRecord() + " 行");
		bf.append(" 共 " + this.getTotalRecord() + " 行");
		bf.append(" 第 " + this.getCurPage() + " 页");
		bf.append(" 共 " + this.getMaxPageNumber() + " 页");
		bf.append("</strong></a></td>");
		bf.append(" <td style='border:none'  ><a style='border:1px solid #9DC9E1;' plain='true' class='easyui-linkbutton' href='javascript:gotoPage(" + 1 + ")'><strong>首页</strong></a>");
		bf.append(" <a style='border:1px solid #9DC9E1;' plain='true' class='easyui-linkbutton' href='javascript:gotoPage("
				+ this.getPreviousPageNumber() + ")'><strong>上一页</strong></a>");
		bf.append(" <a style='border:1px solid #9DC9E1;' plain='true' class='easyui-linkbutton' href='javascript:gotoPage(" + this.getNextPageNumber()
				+ ")'><strong>下一页</strong></a>");
		bf.append(" <a style='border:1px solid #9DC9E1;' plain='true' class='easyui-linkbutton'  href='javascript:gotoPage(" + this.getMaxPageNumber()
				+ ")'><strong>尾页</strong></a></td>");
		bf
				.append("<td style='border:none'><a plain='true' class='easyui-linkbutton'><strong>页数</strong></a></td><td style='border:none'> <input type='text' id='pageNumber'  style='width:30px;' /></td><td style='border:none'> <a plain='true' class='easyui-linkbutton' style='border:1px solid #9DC9E1;' href='javascript:jumpPage()'><strong>GO</strong></a></td>");
		// 动态生成js
		bf.append("</tr></table>");
		bf.append("<script>");
		bf
				.append("function gotoPage(curPage){document.pageBeanForm.curPage.value=curPage;document.pageBeanForm.submit();}");
		bf.append("var maxPageNumber =" + this.getMaxPageNumber() + ";");
		bf
				.append("function jumpPage(){var curPage=document.getElementById('pageNumber').value;if(curPage==''||isNaN(curPage)||-1!=curPage.indexOf('.')||parseInt(curPage)<1||parseInt(curPage)>maxPageNumber){alert('请输入一个正确的页码');return;}gotoPage(curPage);}");
		bf.append("</script>");
		return bf.toString();
	}

	public String toJson() {
		
		JSONObject jso=JSONObject.fromObject(this);
		return jso.toString();
		
	}
}
