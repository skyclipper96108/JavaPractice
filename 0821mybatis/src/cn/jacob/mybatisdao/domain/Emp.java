package cn.jacob.mybatisdao.domain;



public class Emp {
	private Integer id;
	private String username;
	private String password;
	public Emp() {};
	public Emp(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Emp(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
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
	//∑Ω±„≤‚ ‘
	@Override
	public String toString() {
		return "EMP[ id="+id+", username="+username+", password="+password+"]";
	}
	
	
}