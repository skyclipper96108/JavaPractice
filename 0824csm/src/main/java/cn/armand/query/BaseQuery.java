package cn.armand.query;
/**
 * 封装公有的查询信息
 *
 */
public class BaseQuery {
	private Integer localPage;
	private Integer pageSize;
	
	public Integer getBegin() {
		return (this.localPage-1)*this.pageSize;
	}
	public Integer getLocalPage() {
		return localPage;
	}
	public void setLocalPage(Integer localPage) {
		this.localPage = localPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
