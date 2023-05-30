package cn.armand.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Article {
	//主键id
	private Long id;
	//文章标题
	private String title;
	//文章url地址
	private String url;
	//文章类型ID
	private Long typeId;
	//文章类型
	private ArticleType type;
	//点击次数
	private Integer clickCount = 0;
	//文章内容
	private String content;
	//创建时间
	private Date createDate = new Date();
	//默认启用状态
	private Boolean enable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public ArticleType getType() {
		return type;
	}
	public void setType(ArticleType type) {
		this.type = type;
	}
	public Integer getClickCount() {
		return clickCount;
	}
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", url=" + url + ", typeId=" + typeId + ", type=" + type
				+ ", clickCount=" + clickCount + ", content=" + content + ", createDate=" + createDate + ", enable="
				+ enable + "]";
	}
}
