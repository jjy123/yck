package com.parking.entity;

public class Picture {

	private String id;
	private String name;
	private String url;
	
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Picture(String id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	
}
