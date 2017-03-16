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
		System.out.println("��ʼ�ϴ�������");
		//��ȡ���ش洢·��
		String path = this.servletContext.getRealPath("/upload");  
		
		//��ȡԭʼ����
        String fileName = file.getOriginalFilename();  
        //�ļ�����
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //��ʱ���������ļ�
        String dateFileName = new Date().getTime()+fileType;  
        System.out.println(path);  
        //����Ŀ���ļ�
        File targetFile = new File(path, dateFileName);  
        //����  
        try {  
        	//���ϴ����ļ�д���½����ļ���
        	//springmvc�ṩ�ķ�ʽ Ҳ������file.write  io����ʽ�ϴ�
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
