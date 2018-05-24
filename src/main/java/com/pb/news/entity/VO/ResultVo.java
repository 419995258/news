package com.pb.news.entity.VO;

import com.pb.news.util.StringContentUtil;

import java.util.List;


public class ResultVo {
	private String currentpage;
	private String pageNum; // 当前第几页
	private String pageSize; // 每页几条
	private String pages; // 总页数
	private String total; // 总记录数 jqgrid总页数
	private List rows; // 查询后的具体内容
	private String records; // jqgrid总记录数
	private String page;// 当前页码



	public String getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(String currentpage) {
		this.currentpage = currentpage;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}


}
