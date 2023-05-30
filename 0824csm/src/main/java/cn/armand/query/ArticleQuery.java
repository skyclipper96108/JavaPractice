package cn.armand.query;


public class ArticleQuery extends BaseQuery{
	//文章标题
	private String title;
	//文章类型ID
	private Long typeId;
	//默认启用状态
	private Boolean enable;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
