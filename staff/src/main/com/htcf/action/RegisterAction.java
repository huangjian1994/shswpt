package com.htcf.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.EquipmentSelf;
import com.htcf.entity.EquipmentShare;
import com.htcf.entity.Uav;
import com.htcf.service.RegisterService;


@Controller("RegisterAction")
@Scope("prototype")
/**
*Description :设备注册
*@author：hj
*@Create 2018-6-13 14:28
*/
public class RegisterAction {
	
	@Autowired
	private RegisterService registerServer;

	/**
	 *共享摄像头
	 */
	private EquipmentShare share = new EquipmentShare();

	/**
	 * 自建摄像头设备
	 */
	private EquipmentSelf self = new EquipmentSelf();

	/**
	 * 无人机设备
	 */
	private Uav uav =new Uav();

	/**
	 * 自建视频集合
	 */
	private List<?> selfList;
	private List<?> shareList;
	private List<?> uavList;

	/**
	 * equipmentName 设备名称
	 * equipmentUser 设备所属单位
	 * equipmentLocation 设备位置
	 * equipmentCode 设备编码
	 * equipmentType 设备型号
	 * Type设备种类0：自建摄像机  1：共享摄像机 2：无人机
	 * equipmentJd 摄像头经度
	 * equipmentWd 摄像头纬度
	 * ssgc 设备所属工程
	 */
	private String equipmentName;
	private String equipmentUser;
	private String equipmentLocation;
	private String equipmentCode;
	private String equipmentType;
	private String Type;
	private String equipmentJd;
	private String equipmentWd;
	private String ssgc;
	


	/**
	*Description :获取时间
	*@param
	*@return
	*@author：hj
	*@Create 2018-6-13 14:35
	*/
	public String getTime(){
		//入库时间
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = dateFormat.format(date);
		System.out.println("系统当前时间："+datetime);
		return datetime;
	}
	/**
	 * @Description：设备注册
	 *@author:hj
	 *@Time2017-3-23下午02:54:43 
	 *@return
	 */
	public String Register(){
		System.out.println("设备名称："+equipmentName);
		System.out.println("设备所属单位："+equipmentUser);
		System.out.println("设备位置："+equipmentLocation);
		System.out.println("设备编码："+equipmentCode);
		System.out.println("设备型号："+equipmentType);
		System.out.println("设备种类："+Type);
		System.out.println("摄像头经度："+equipmentJd);
		System.out.println("摄像头纬度："+equipmentWd);
		System.out.println("所属工程："+ssgc);
		String qydm = this.registerServer.fetchDm(equipmentLocation);
		String dwdm = this.registerServer.fetchDm(equipmentUser);
		System.out.println("位置代码："+qydm);
		System.out.println("单位代码："+dwdm);
		//自建攝像頭
		if("0".equals(Type)){
			self.setName(equipmentName);
			self.setUser(equipmentUser);
			self.setDm(qydm);
			self.setAddress(equipmentLocation);
			self.setCode(equipmentCode);
			self.setType(equipmentType);
			self.setLongitude(equipmentJd);
			self.setLatitude(equipmentWd);
			self.setDwdm(dwdm);
			self.setSsgc(ssgc);
			self.setApprove("否");
			self.setDate(this.getTime());
			self.setUseful("否");
			System.out.println(share.getApprove());
			boolean RegisterSucceedSelf = this.registerServer.saveEquipmentSelf(self);
		}
		//共享摄像头
		else if( "1".equals(Type)){
			share.setName(equipmentName);
			share.setUser(equipmentUser);
			share.setAddress(equipmentLocation);
			share.setDm(qydm);
			share.setCode(equipmentCode);
			share.setType(equipmentType);
			share.setLogitude(equipmentJd);
			share.setLatitude(equipmentWd);
			share.setDwdm(dwdm);
			share.setSsgc(ssgc);
			
			share.setApprove("否");
			share.setDate(this.getTime());
			share.setUseful("否");
			System.out.println(share.getApprove());
			boolean RegisterSucceedShare = this.registerServer.saveEquipmentShare(share);
		//无人机
		}else if("2".equals(Type)){
			uav.setName(equipmentName);
			uav.setUser(equipmentUser);
			uav.setCode(equipmentCode);
			uav.setType(equipmentType);
			
			uav.setApprove("否");
			uav.setDate(this.getTime());
			uav.setUseful("否");
			
			boolean RegisterSucceedUav = this.registerServer.saveUav(uav);
			System.out.println("成功");
		}
		System.out.println("进入测试");
		return "succeed";
	}
	
	/**
	 * @Description：获取设备
	 *@author:
	 *@Time2017-3-30下午02:31:05
	 */
	public String getE(){

		selfList = registerServer.fetSelf(equipmentLocation, equipmentUser);
		if(selfList.size()!=0){
			self = new EquipmentSelf();
			for(int i  =0;i<selfList.size();i++){
				self = (EquipmentSelf)selfList.get(i);
				System.out.println("1231313131313131"+self.getName());
			}
			
		}
		shareList = registerServer.fetShare(equipmentLocation, equipmentUser);
		uavList = registerServer.fetUav(equipmentLocation, equipmentUser);
		return "zhanshi";
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*---------------------------get   set ----------------------------- */
	
	public RegisterService getRegisterServer() {
		return registerServer;
	}

	public void setRegisterServer(RegisterService registerServer) {
		this.registerServer = registerServer;
	}
	
	public EquipmentSelf getSelf() {
		return self;
	}
	public void setSelf(EquipmentSelf self) {
		this.self = self;
	}
	
	public Uav getUav() {
		return uav;
	}
	public void setUav(Uav uav) {
		this.uav = uav;
	}
	
	
	
	
	
	
	public String getSsgc() {
		return ssgc;
	}
	public void setSsgc(String ssgc) {
		this.ssgc = ssgc;
	}
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentUser() {
		return equipmentUser;
	}

	public void setEquipmentUser(String equipmentUser) {
		this.equipmentUser = equipmentUser;
	}

	public String getEquipmentLocation() {
		return equipmentLocation;
	}

	public void setEquipmentLocation(String equipmentLocation) {
		this.equipmentLocation = equipmentLocation;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getEquipmentJd() {
		return equipmentJd;
	}

	public void setEquipmentJd(String equipmentJd) {
		this.equipmentJd = equipmentJd;
	}

	public String getEquipmentWd() {
		return equipmentWd;
	}

	public void setEquipmentWd(String equipmentWd) {
		this.equipmentWd = equipmentWd;
	}

	public EquipmentShare getShare() {
		return share;
	}

	public void setShare(EquipmentShare share) {
		this.share = share;
	}
	public List<?> getSelfList() {
		return selfList;
	}
	public void setSelfList(List<?> selfList) {
		this.selfList = selfList;
	}
	public List<?> getShareList() {
		return shareList;
	}
	public void setShareList(List<?> shareList) {
		this.shareList = shareList;
	}
	public List<?> getUavList() {
		return uavList;
	}
	public void setUavList(List<?> uavList) {
		this.uavList = uavList;
	}

	
	

}
