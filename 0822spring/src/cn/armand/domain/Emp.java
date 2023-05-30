package cn.armand.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Emp {
	private Integer id;
	private String username;
	private String password;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8") // 设置时间戳格式
	private Date birthday;
	public Emp() {};
	public Emp(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Emp(Integer id, String username, String password, Date birthday) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EMP[ id="+id+", username="+username+", password="+password;
	}
	
	
}
