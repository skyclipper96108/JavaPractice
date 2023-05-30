package cn.armand.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	@RequestMapping("/downLoad")
	public String download(String fileName, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println(fileName);
		// 获取输入流
		String path = req.getServletContext().getRealPath("/download");
		FileInputStream in = new FileInputStream(new File(path, fileName));
		
		// 文件上传时，不同浏览器编码格式不同导致中文名无法正常显示2
		if(req.getHeader("User-Agent").toUpperCase().indexOf("TRIDENT")!=-1) fileName = URLEncoder.encode(fileName, "UTF-8");
		else if(req.getHeader("User-Agent").toUpperCase().indexOf("EDGE")!=-1) fileName = URLEncoder.encode(fileName, "UTF-8");
		else fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		// 获取输出流
		resp.setHeader("Content-Disposition", "attachment; filename="+fileName);
		ServletOutputStream out = resp.getOutputStream();
		IOUtils.copy(in,out);
		out.close();
		in.close();
		// 如果当前浏览器支持该格式，就直接显示，不支持才让用户选择下载
		return null;
		
	}
}
