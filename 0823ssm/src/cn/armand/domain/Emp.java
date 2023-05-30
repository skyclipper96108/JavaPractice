package cn.armand.domain;

public class Emp{ 
	private Integer eid;
	private String eno;
	private String ename;
	private Integer age;
	private String sex;
	private String tel;
	private String address;
	private Double sal;
	private Integer deptno;
	public Emp() {
		super();
	}
	public Emp(Integer eid, String eno, String ename, Integer age, String sex, String tel, String address, Double sal, Integer deptno) {
		super();
		this.eid = eid;
		this.eno = eno;
		this.ename = ename;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.sal = sal;
		this.deptno = deptno;
	}
	public Emp(String eno, String ename, Integer age, String sex, String tel, String address, Double sal, Integer deptno) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.sal = sal;
		this.deptno = deptno;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Emp[eid=" + eid + ", eno=" + eno + ", ename=" + ename + ", age=" + age + ", sex=" + sex + ", tel=" + tel + ", address=" + address + ", sal=" + sal + ", deptno=" + deptno + "]";
	}
}