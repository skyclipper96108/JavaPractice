package cn.armand.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtil {
	/**
	 * 
	 * @param templatePath 模板的路径
	 * @param templateName 模板的名称
	 * @param data 数据
	 * @param suffix 后缀
	 * @return 静态页面的名称
	 */
	public static String getStaticFile(String templatePath, String templateName, Object data, String suffix) {
		OutputStreamWriter osw = null;
		try {
			// 1.生成模板
			// 创建Configuration对象，为了获取模板对象，传递一个最高版本
			Configuration config = new Configuration(Configuration.VERSION_2_3_28);
			File file = new File(templatePath);
			//设置模板的加载路径
			config.setDirectoryForTemplateLoading(file);
			//设置模板的编码
			config.setDefaultEncoding("UTF-8");
			Template template = config.getTemplate(templateName);
			// 2.数据
			// 3.生成静态页面
			//生成文件名------时间戳+后缀
			String fileName = System.currentTimeMillis()+suffix;
			// 获取字节流
			FileOutputStream fos = new FileOutputStream(new File(file, fileName));
			// 获取字符流------设置内容编码
			osw = new OutputStreamWriter(fos,"UTF-8");
			template.process(data, osw);
			// 返回静态页面的名称
			return fileName;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(osw!=null) {
				try {
					osw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
