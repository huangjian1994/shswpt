package com.htcf.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.User;
import com.htcf.entity.Video;
import com.htcf.service.VideoStoreService;


@Controller("VideoStoreAction")
@Scope("prototype")
public class VideoStoreAction extends BaseAction {
    //
    @Autowired
    private VideoStoreService videoStoreService;
    //实体
    private Video video = new Video();

    //List
    private List<?> videoList;

    //变量
    private File upload;
    private String uploadFileName;// 文件名
    private String uploadContentType; // 上传的文件类型

    private String uploadMessage;//上传后消息
    private String videoDistrit;//查询标签VIDEO_DISTRIT
    private String zjID;
    private String fileName;

    private String videoFileName;

    /**
     * Description :获取时间
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */
    public String getTime() {
        //入库时间
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println("系统当前时间：" + date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * Description :获取日期
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */
    public String getDate() {
        //入库时间
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println("系统当前时间：" + date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String datetime = dateFormat.format(date);
        return datetime;
    }


    /**
     * Description :上传视频
     *
     * @param
     * @return String
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */
    public String uploadVideo() {
        System.out.println("进入到上传数据表界面");
        System.out.println("视频名称：" + video.getVideo_name());
        System.out.println("视频查询标签：" + video.getVideo_distrit());
//		System.out.println("upload:   " + upload);
//		System.out.println("文件名:   " + uploadFileName);
//		System.out.println("文件类型:   " + uploadContentType);
        String veido_path = uploadFile();//上传到对应盘下
        //视频转码，统一转为标准码

        //截取视频的缩略图-//视频截图PICTURE
        Snapshot snapshot = new Snapshot();

        //Tomcat下相对路径
//		String picPath = ServletActionContext.getServletContext().getRealPath("/video/videoPicture");

        //本地路径
        String picPath = "C:/shswpt/videoPicture";
        File serFile = new File(picPath);
        //判断服务器上该目录是否存在，不存在则创建目录
        if (!serFile.exists()) {
            serFile.mkdirs();
        }

        //截图的文件名得注意：目前是截取视频文件名，若用户上传多次文件名一样，则会替换
        String[] strarray = uploadFileName.split("\\.");//截取视频文件名的前半段
        System.out.println("图片名：" + strarray[0]);
        String picName = strarray[0] + ".jpg";
        picPath += File.separator + picName;
        System.out.println("图片地址" + picPath);
        try {
            snapshot.getPictrue(veido_path, picPath);//获取视频的截图
        } catch (Exception e) {
            System.out.println("获取视频的截图报错");
        }

        video.setPicture(picName);//视频截图

        //建议将视频的截图保存到数据库，存为BLOB字段，前端显示也需调整


        video.setVideo_address(veido_path);//视频上传地址
        video.setVideo_route(veido_path);//视频路径
        video.setVideo_filename(uploadFileName);//视频文件名称
        video.setVideo_type(uploadContentType);
        video.setVideo_date(this.getTime());//视频上传时间
        video.setDescription("本地上传");//视频来源类型
        //视频上传者-姓名
        //视频上传者-用户ID
//		String userDw = "";//
//		String rolename = "";//
//		try{
//			userDw = ((User)session.get("user")).getDepartment();//
//			rolename = ((User)session.get("user")).getRole().getRoleName();//
//		}catch(Exception e){
//			return "dlCs";
//		}

        videoStoreService.addEntity(video);
        uploadMessage = "<script type='text/javascript'>alert('视频上传成功！')</script>";
        return "goVideoUpload";
    }

    /**
     * Description :视频上传成功后跳转到上传页面
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */
    public String goVideoUpload() {
        uploadMessage = "<script type='text/javascript'>alert('视频上传成功！')</script>";
        return "goLoad";
    }

    /**
     * Description :上传文件项目中
     *
     * @param
     * @return String
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */
    public String uploadFile() {
        System.out.println("进入上传EXCEL。。。。 ");
        FileInputStream fis = null; // 为了关闭资源
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String path = null;
        try {
            System.out.println("upload:   " + upload);
            System.out.println("文件名:   " + uploadFileName);
            System.out.println("文件类型:   " + uploadContentType);
            fis = new FileInputStream(upload);
            // FileReader 一次只能读一个字符，一个汉字字符流 读汉字
            // 封装成，缓冲一下，可以读一行
            bis = new BufferedInputStream(fis);

            String realPath = "C:/shswpt/videoUpload";
//			String realPath = ServletActionContext.getServletContext().getRealPath("/video/videoUpload");
            System.out.println("文件路径：" + realPath);
            System.out.println("文件详细路径：" + realPath + File.separator
                    + uploadFileName);
            path = realPath + File.separator + uploadFileName;

            File serFile = new File(realPath);
            // 判断服务器上该目录是否存在，不存在则创建目录
            if (!serFile.exists()) {
                serFile.mkdirs();
            }
            // 封装成IO流对象，以便输出文件内容
            fos = new FileOutputStream(path); // 从内存走
            bos = new BufferedOutputStream(fos); // 从内存往硬盘走
            int count = bis.read();
            // 如果没有读取到文件末行
            while (count != -1) {
                // 把读取到的一行 输出到硬盘上
                bos.write(count);
                count = bis.read();
            }
            // 上传文件完毕，关闭IO流资源
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("路径：" + path);
        return path;
    }

    /**
     * Description :查出库中的视频
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */

    public String fetchVideo() {
        System.out.println("视频名称=" + video.getVideo_name() + ",查询标签=" + video.getVideo_distrit());
        HttpServletRequest request = this.getHttpServletRequest();
        pageBean = this.processPageBean(request);
        pageBean.setPageRecord(18);
        videoList = videoStoreService.fetchVideoList(video, pageBean);
        return "videostore";
    }

    /**
     * Description :展示视频详情
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-26
     */
    public String fetchVideoDetail() {
        System.out.println("zjID=" + zjID);
        video = videoStoreService.fetchVideoDetail(zjID);
        return "videostoreDetail";
    }


    /**
     * @param
     * @return
     * @Description：下载视频库视频
     * @author:hj
     * @2017-5-21下午02:38:12
     */
    public String downloadVideo() {
        System.out.println("下载插件.....");
        fileName = videoFileName;
        return "successCj";
    }

    /**
     * @param
     * @return
     * @Description：从下载视频文件原始存放路径读取得到文件输出流
     * @author:hj
     * @2017-5-21下午03:50:46
     */
    public InputStream getDownloadFileVideo() {
        System.out.println("进入getDownloadFile.....");
        System.out.println(ServletActionContext.getServletContext().getResourceAsStream(fileName));
        //FileInputStream fis=ServletActionContext.getServletContext().getResourceAsStream("/hcbdmb/"+fileName);
        return ServletActionContext.getServletContext().getResourceAsStream(fileName);
    }


    /**
     * @param
     * @return
     * @Description：下载插件
     * @author:hj
     * @2017-5-21下午02:38:12
     */
    public String downloadCj() {
        System.out.println("下载插件.....");
        fileName = "Desktop.rar";
        return "successCj";
    }

    /**
     * @param
     * @return
     * @Description：下载操作手册
     * @author:hj
     * @2017-5-21下午02:38:30
     */
    public String downloadCzsc() {
        System.out.println("下载操作手册.....");
        fileName = "操作手册.docx";
        return "successCzsc";
    }


    /**
     * @param
     * @return
     * @Description：从下载文件原始存放路径读取得到文件输出流
     * @author:hj
     * @2017-5-21下午03:50:46
     */
    public InputStream getDownloadFileCzsc() {
        System.out.println("进入getDownloadFile.....");
        System.out.println(ServletActionContext.getServletContext().getResourceAsStream("/files/" + fileName));
        //FileInputStream fis=ServletActionContext.getServletContext().getResourceAsStream("/hcbdmb/"+fileName);
        return ServletActionContext.getServletContext().getResourceAsStream("/files/" + fileName);
    }


    /**
     * @param
     * @return
     * @Description：如果下载文件名为中文，进行字符编码转换
     * @author:hj
     * @2017-5-21下午03:51:00
     */
    public String getDownloadChineseFileNameCzsc() {
        String downloadChineseFileName = fileName;
        System.out.println("文件名：" + fileName);
        try {
            downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return downloadChineseFileName;
    }

    /**
     * Description :查出库中待审核的视频
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-25
     */

    public String shVideo() {
        System.out.println("视频名称=" + video.getVideo_name() + ",查询标签=" + video.getVideo_distrit());
        HttpServletRequest request = this.getHttpServletRequest();
        pageBean = this.processPageBean(request);
        pageBean.setPageRecord(10);
        videoList = videoStoreService.fetchVideoList(video, pageBean);
        return "shvideo";
    }

    /**
     * Description :展示视频详情
     *
     * @param
     * @return
     * @throws
     * @Author：yinying
     * @Create 2017-04-26
     */
    public String shVideoDetail() {
        System.out.println("zjID=" + zjID);
        video = videoStoreService.fetchVideoDetail(zjID);
        return "videostoreDetail";
    }

	/*----------------------------------------------------------------------*/


    public VideoStoreService getVideoStoreService() {
        return videoStoreService;
    }

    public void setVideoStoreService(VideoStoreService videoStoreService) {
        this.videoStoreService = videoStoreService;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getUploadMessage() {
        return uploadMessage;
    }

    public void setUploadMessage(String uploadMessage) {
        this.uploadMessage = uploadMessage;
    }

    public List<?> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<?> videoList) {
        this.videoList = videoList;
    }

    public String getVideoDistrit() {
        return videoDistrit;
    }

    public void setVideoDistrit(String videoDistrit) {
        this.videoDistrit = videoDistrit;
    }

    public String getZjID() {
        return zjID;
    }

    public void setZjID(String zjID) {
        this.zjID = zjID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }


}
