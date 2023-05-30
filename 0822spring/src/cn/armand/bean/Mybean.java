package cn.armand.bean;

import java.util.Date;

public class Mybean {
	private String name;
	private Date time;
	private Tomato tomato;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Tomato getTomato() {
		return tomato;
	}
	public void setTomato(Tomato tomato) {
		this.tomato = tomato;
	}
	@Override
	public String toString() {
		return "Mybean [name=" + name + ", time=" + time + ", tomato=" + tomato + "]";
	}
	
}
