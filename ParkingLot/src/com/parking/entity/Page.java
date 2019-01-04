package com.parking.entity;
import java.io.Serializable;

/*
 * ʵ�ַ�ҳЧ��
 * currentpage
 * 	��ǰҳ��
 * startpage
 * 	��ʼҳ��
 * pagesize
 * 	һҳ��ʾ��������
 */
public class Page implements Serializable{
	private  Integer currentpage;//Ĭ������Ϊ1
	private Integer startpage;//Ĭ������Ϊ0
	private Integer pagesize;//Ĭ������Ϊ10

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
