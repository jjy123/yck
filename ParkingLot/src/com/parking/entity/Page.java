package com.parking.entity;
import java.io.Serializable;

/*
 * 实现分页效果
 * currentpage
 * 	当前页面
 * startpage
 * 	起始页面
 * pagesize
 * 	一页显示的数据数
 */
public class Page implements Serializable{
	private  Integer currentpage;//默认设置为1
	private Integer startpage;//默认设置为0
	private Integer pagesize;//默认设置为10

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(Integer currentpage, Integer startpage, Integer pagesize) {
		super();
		this.currentpage = currentpage;
		this.startpage = startpage;
		this.pagesize = pagesize;
	}

	public Integer getCurrentpage() {
		if(currentpage==null){
			currentpage=1;
		}
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getStartpage() {
		if(startpage==null){
			startpage=0;
		}
		return startpage;
	}

	public void setStartpage(Integer startpage) {
		this.startpage = startpage;
	}

	public Integer getPagesize() {
		if(pagesize==null){
			pagesize=5;
		}
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public String toString() {
		return "PageEntity [currentpage=" + currentpage + ", startpage="
				+ startpage + ", pagesize=" + pagesize + "]";
	}
	
	
	
}
