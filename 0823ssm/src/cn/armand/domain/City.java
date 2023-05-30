package cn.armand.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 城市对象
 * 
 * @author ZhaoYi
 */
public class City {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City() {

	}

	public City(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 根据省份id查询省份中的城市!
	 * 
	 * @return
	 */
	public static List<City> getCityByProvinceId(Long id) {
		
		List<City> citys = new ArrayList<City>();
		
		if (id == 1) {
			citys = Arrays.asList(
					new City(1L,"成都"),
					new City(2L,"南充"),
					new City(3L,"绵阳"),
					new City(4L,"遂林"),
					new City(5L,"达州"),
					new City(6L,"德阳"),
					new City(7L,"乐山")
			);
		} else if (id == 2) {
			citys = Arrays.asList(
					new City(11L,"广州"),
					new City(12L,"佛山"),
					new City(13L,"东莞")
			);
		} else if (id == 3) {
			citys = Arrays.asList(
					new City(21L,"昆明"),
					new City(22L,"玉溪"),
					new City(23L,"丽江")
			);
		}
		return citys;
	}
}
