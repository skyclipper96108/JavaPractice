package cn.armand.query;

public class EmpQuery {
	private String ename;
	private String address;
	private Double sal;
	private Integer deptno;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
		return "EmpQuery [ename=" + ename + ", address=" + address + ", sal=" + sal + ", deptno=" + deptno + "]";
	}
}
