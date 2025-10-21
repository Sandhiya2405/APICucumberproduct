package com.app.functional;

import io.restassured.builder.RequestSpecBuilder;

public class TestBase {

	//Test git pull
	
	public RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();

	public void handleProxy(){

	String proxyip ="";
	String proxyPort ="";

	if(proxyip !=null && proxyPort!=null){

	requestspecbuilder.setProxy(proxyip,Integer.valueOf(proxyPort));
	}
	}

	
}
