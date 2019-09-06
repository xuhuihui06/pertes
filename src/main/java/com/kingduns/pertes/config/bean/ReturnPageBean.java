package com.kingduns.pertes.config.bean;

import java.io.Serializable;
import java.util.List;


public class ReturnPageBean<T> implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 3116340845776697894L;
	
	
	private Integer page=0;// 当前页数
	private Integer total=0;// 总记录数
	private Integer totalPage=0;// 总页数
	private Integer limit=0;// 每页显示的记录数
	private List<T> rows;// 每页显示数据的集合
	private Integer begin=0;//查询起始条数
	
	public Integer getBegin() {
		if(page!=0 && limit !=0) {
			begin=(page-1)*limit;
		}
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public ReturnPageBean() {
		super();
		
	}
	
	public ReturnPageBean(Integer total, List<T> rows) {
		super();
		if(total<0) {
			total=0;
		}
		if(rows==null ||rows.size()<1) {
			total=0;
		}
		this.total = total;
		this.rows = rows;
		if(total%limit==0) {
			this.totalPage = total/limit;
		}else {
			this.totalPage = (total/limit)+1;
		}
		
	}

	
	public ReturnPageBean(Integer page, Integer total, Integer limit, List<T> rows) {
		super();
		if(total==null||total<0) {
			total=0;
		}
		if(rows==null ||rows.size()<1) {
			total=0;
		}
		if(page==null||page <1) {
			page=1;
		}
		if(limit<Constants.MINLIMIT) {
			limit =Constants.MINLIMIT;
		}
		if(limit>Constants.MAXLIMIT) {
			limit = Constants.MAXLIMIT;
		}
		this.page = page;
		this.total = total;
		this.limit = limit;
		this.rows = rows;
		if(total%limit==0){
			this.totalPage=total/limit;
        }else{
        	this.totalPage=total/limit+1;
        }
		
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		if(page==null ||page <1) {
			page=1;
		}
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		if(limit ==null || limit<Constants.MINLIMIT) {
			limit =Constants.MINLIMIT;
		}else if(limit>Constants.MAXLIMIT) {
			limit = Constants.MAXLIMIT;
		}
		this.limit = limit;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
