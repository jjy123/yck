package com.parking.entity;

public class Info extends Page{

	private String id;
	private String cardnum;
	private String licensenum;
	private String starttime;
	private String endtime;
	private String state;
	private String manager;
	private double amount;
	private String url;
	
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Info(Integer currentpage, Integer startpage, Integer pagesize) {
		super(currentpage, startpage, pagesize);
		// TODO Auto-generated constructor stub
	}



	public Info(String id, String cardnum, String licensenum, String starttime,
			String endtime, String state, String manager, double amount,
			String url) {
		super();
		this.id = id;
		this.cardnum = cardnum;
		this.licensenum = licensenum;
		this.starttime = starttime;
		this.endtime = endtime;
		this.state = state;
		this.manager = manager;
		this.amount = amount;
		this.url = url;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCardnum() {
		return cardnum;
	}



	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}



	public String getLicensenum() {
		return licensenum;
	}



	public void setLicensenum(String licensenum) {
		this.licensenum = licensenum;
	}



	public String getStarttime() {
		return starttime;
	}



	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}



	public String getEndtime() {
		return endtime;
	}



	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getManager() {
		return manager;
	}



	public void setManager(String manager) {
		this.manager = manager;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public String toString() {
		return "Info [id=" + id + ", cardnum=" + cardnum + ", licensenum="
				+ licensenum + ", starttime=" + starttime + ", endtime="
				+ endtime + ", state=" + state + ", manager=" + manager
				+ ", amount=" + amount + ", url=" + url + "]";
	}
	
}
