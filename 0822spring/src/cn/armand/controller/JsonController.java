package cn.armand.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.armand.domain.Emp;

@Controller
@RequestMapping("/json")
public class JsonController {
	@RequestMapping("/obj")
	@ResponseBody // 将当前方法的返回值自动转成json格式的数据，且不经过视图解析器
	public Emp getObj() {
		return new Emp(9,"cherry","0494949", new Date());
	}
	@RequestMapping("/map")
	@ResponseBody // 当一个方法需要返回两个值，可以使用hashmap
	public Map<String, Object> getMap() {
		Map<String,Object> map= new HashMap<>();
		map.put("success", true);
		map.put("naruto", "op");
		return map;
	}
}
