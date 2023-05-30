package cn.armand.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
/**
 * 文件上传三要素
 * 1. post
 * 2. multipart/form-data
 * 3. type="file"
 *  文件上传解析器
 */
@Controller
public class UploadController {
	@RequestMapping("/upload")
	public String fileUpload(String name, String pwd, MultipartFile photo, Model model, HttpServletRequest req) throws IOException {
		System.out.println("用户"+name);
		System.out.println("密码"+name);
		//		复杂表单项
		long size = photo.getSize();
		if(size>0) {
			InputStream in = photo.getInputStream();
			String fileName = photo.getOriginalFilename();
			System.out.println("submitted photo"+fileName);
			// 动态获取时间戳存取路径
			String path = req.getServletContext().getRealPath("/images");
			File file = new File(path);
			if(!file.exists())file.mkdir();
			//取文件后缀名
			// String fileExtention = fileName.substring(fileName.lastIndexOf("."));
			// 随机文件名 或者使用时间戳
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			fileName = fileName+uuid;
			// 获取输出流并指定上传位置
			FileOutputStream out = new FileOutputStream(new File(file, fileName));
			// 复制
			IOUtils.copy(in, out);
			out.close();
			in.close(); 
		}else {
			model.addAttribute("error", "no image");
		}
		return null;
	}
}
