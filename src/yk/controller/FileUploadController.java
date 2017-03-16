package yk.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Controller
@RequestMapping(value="u")
public class FileUploadController implements ServletContextAware{
	
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
	}
	
	
	@RequestMapping(params="method=upload", method = RequestMethod.POST)
	public String handleUploadData(String name,@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request){
		int start=(int) System.currentTimeMillis();
		System.out.println("开始上传。。。");
		//获取本地存储路径
		String path = this.servletContext.getRealPath("/upload");  
		
		//获取原始名称
        String fileName = file.getOriginalFilename();  
        //文件类型
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //以时间重命名文件
        String dateFileName = new Date().getTime()+fileType;  
        System.out.println(path);  
        //建立目标文件
        File targetFile = new File(path, dateFileName);  
        //保存  
        try {  
        	//将上传的文件写入新建的文件中
        	//springmvc提供的方式 也可以用file.write  io流方式上传
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        int end=(int) System.currentTimeMillis();
		   System.out.println("time..."+(end-start));
		   String filePath="upload/"+dateFileName;
		   request.setAttribute("imgSrc",filePath );
        return "upload_success.jsp";
		
	}
}
