package cn.armand.query;

public class SlideQuery extends BaseQuery {
	//图片名称
	private String name;
	//默认启用状态
	private Boolean enable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
