package com.wanzhon.controller;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wanzhon.model.User;

//文件的上传控制器
@Controller
@RequestMapping("/file")
public class FileUpLoadController {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception{
	    MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
	    MultipartFile file = mreq.getFile("file");
	    String fileName = file.getOriginalFilename();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");        
	    FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
	            "upload/"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')));
	    fos.write(file.getBytes());
	    fos.flush();
	    fos.close();
	     
	    return "upLoadSuccess";
	}
	@RequestMapping(value="/preUpload",method=RequestMethod.GET)
	public String fileUpload(User user) throws Exception{
	
	    return "hello";
	}
}