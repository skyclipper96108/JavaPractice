package cn.armand.domain;

public class Empp{ 
	private Integer eid;
	private String ename;
	private String sex;
	private String address;
	private String tel;
	private String card;
	public Empp() {
		super();
	}
	public Empp(Integer eid, String ename, String sex, String address, String tel, String card) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.address = address;
		this.tel = tel;
		this.card = card;
	}
	public Empp(String ename, String sex, String address, String tel, String card) {
		super();
		this.ename = ename;
		this.sex = sex;
		this.address = address;
		this.tel = tel;
		this.card = card;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Empp[eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", address=" + address + ", tel=" + tel + ", card=" + card + "]";
	}
}