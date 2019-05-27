package entity;

import java.io.Serializable;
import java.util.List;

/**
 * totalPage总页数
 * rows总记录数
 * @author Administrator
 *
 */
public class PageResult implements Serializable{
	 
	private Long totalPage;
	private List rows;
	public PageResult(Long totalPage, List rows) {
		super();
		this.totalPage = totalPage;
		this.rows = rows;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

	
}
