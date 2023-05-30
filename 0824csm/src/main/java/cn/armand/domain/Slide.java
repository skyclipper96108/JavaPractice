package cn.armand.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Slide {
		//主键id
		private Long id;
		//图片名
		private String name;
		//图片路径
		private String path;
		//创建时间
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date createDate = new Date();
		//默认启用状态
		private Boolean enable;
		public Slide(Long id, String name, String path, Date createDate, Boolean enable) {
			super();
			this.id = id;
			this.name = name;
			this.path = path;
			this.createDate = createDate;
			this.enable = enable;
		}
		public Slide(String name, String path, Date createDate, Boolean enable) {
			this.name = name;
			this.path = path;
			this.createDate = createDate;
			this.enable = enable;
		}
		public Slide() {}
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
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public Date getCreateDate() {
			return createDate;
		}
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
			return "Slide [id=" + id + ", name=" + name + ", path=" + path + ", createDate=" + createDate + ", enable="
					+ enable + "]";
		}
		
}
