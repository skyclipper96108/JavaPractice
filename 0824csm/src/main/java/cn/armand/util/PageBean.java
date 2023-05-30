package cn.armand.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 方便前台取值
 *
 */
public class PageBean<T>{
	private Integer totals=0;
	private List<T> data = new ArrayList<>();
	public PageBean(Integer totals, List<T> data) {
		this.totals = totals;
		this.data = data;
	}
	public PageBean() {
	}
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageBean [totals=" + totals + ", data=" + data + "]";
	}
	

}
