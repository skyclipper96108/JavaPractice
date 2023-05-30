package cn.armand.domain;

public class Dept{ 
	private Integer id;
	private String dname;
	private String manager;
	private String tel;
	private Integer num;
	public Dept() {
		super();
	}
	public Dept(Integer id, String dname, String manager, String tel, Integer num) {
		super();
		this.id = id;
		this.dname = dname;
		this.manager = manager;
		this.tel = tel;
		this.num = num;
	}
	public Dept(String dname, String manager, String tel, Integer num) {
		super();
		this.dname = dname;
		this.manager = manager;
		this.tel = tel;
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Dept[id=" + id + ", dname=" + dname + ", manager=" + manager + ", tel=" + tel + ", num=" + num + "]";
	}
}