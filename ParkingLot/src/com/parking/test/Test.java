package com.parking.test;

public class Test {

	public static void main(String[] args) {
		String url="/ParkingLot/servlet/UserServlet/login";
		boolean contains = url.contains("login");
		System.out.println(contains);
	}
}
