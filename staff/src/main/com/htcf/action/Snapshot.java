package com.htcf.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class Snapshot {
	public static void main(String[] args) {
		//需要提取截图的视频地址
		String s1 = "E:/shswpt/video/a2.wmv";
		//将生成的截图存放在什么位置
		String s2 = "E:/shswpt/video/a22.jpg";
		if(take(s1, s2)){
			System.out.println("截图提取成功");
		}else{
			System.out.println("截图提取失败");
		}
	}
	/**
	 * 
	Description :
	@param
	@return
	@throws
	@Author：yinying
	@Create
	 */
	public boolean getPictrue(String veido_path,String picPath){
		if(take(veido_path, picPath)){
			System.out.println("截图提取成功");
			return true;
		}else{
			System.out.println("截图提取失败");
			return false;
		}
	}
	
	public static boolean take(String videoLocation, String imageLocation){
		// 低精度
		List commend = new java.util.ArrayList();
		String picPath = ServletActionContext.getServletContext().getRealPath("/video/videoPicture");
		commend.add(picPath+File.separator+"ffmpeg.exe");//视频提取工具的位置
		commend.add("-i");
		commend.add(videoLocation);
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		commend.add("00.10");//视频第1秒截图
		commend.add("-t");
		commend.add("0.001");
		commend.add("-s");
		commend.add("800x800");
		commend.add(imageLocation);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
