package com.binmma.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadFile {
	@RequestMapping("/uploadFile")
	public ModelAndView uploadFile(ModelAndView modelAndView,MultipartFile fileupload) throws IllegalStateException, IOException{
		//文件名称
		String fileName = StringUtils.replace(UUID.randomUUID().toString(), "-", "");
		String oldName = fileupload.getOriginalFilename();
		String suffixName = StringUtils.substring(oldName, oldName.indexOf("."));
		File file = new File("C:\\GitOut\\pic\\"+fileName+suffixName);
		fileupload.transferTo(file);
		modelAndView.setViewName("MyJsp");
//		modelAndView.addObject("picUrl", "C:\\GitOut\\pic\\")
		modelAndView.addObject("msg", "上传成功");
		return modelAndView;
		
	}

}
