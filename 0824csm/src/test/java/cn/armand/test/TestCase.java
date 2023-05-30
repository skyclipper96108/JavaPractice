package cn.armand.test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import cn.armand.domain.ArticleType;
import cn.armand.util.FreeMarkerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestCase {
	@Test
	public void testMap() throws Exception {
		// 1.模板对象
		// 创建Configuration对象，是为了获取模板对象
		Configuration config = new Configuration(Configuration.VERSION_2_3_28);
		// 指定模板的路径以及编码
		config.setDirectoryForTemplateLoading(new File("src/main/webapp/static/template"));
		config.setDefaultEncoding("UTF-8");
		// 生成模板
		Template template = config.getTemplate("test1.ftl");
		// 2.数据
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "tom");
		map.put("age", 34);
		// 3.生成静态界面
		// 获取字符输出流
		FileWriter writer = new FileWriter(new File("src/main/webapp/static/template/test1.html"));
		template.process(map, writer);
		writer.close();
	}
	@Test
	public void testObject() throws Exception {
//		// 1.生成模板
//		Configuration config = new Configuration(Configuration.VERSION_2_3_28);
//		File file = new File("src/main/webapp/static/template");
//		config.setDirectoryForTemplateLoading(file);
//		config.setDefaultEncoding("UTF-8");
//		Template template = config.getTemplate("test2.ftl");
//		// 2.数据
		ArticleType articleType1 = new ArticleType("人文关怀", "person1");
		ArticleType articleType2 = new ArticleType("人文关怀", "person2");
//		// 3.生成静态页面
//		FileOutputStream fos = new FileOutputStream(new File(file, "test2.html"));
//		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
//		template.process(articleType, osw);
//		osw.close();
		List<ArticleType> types = new ArrayList<ArticleType>();
		types.add(articleType1);
		types.add(articleType2);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("maptypes", types);
		String fileName = FreeMarkerUtil.getStaticFile("src/main/webapp/static/template", "test2.ftl", map, ".html");
		System.out.println(fileName);
	}
}
