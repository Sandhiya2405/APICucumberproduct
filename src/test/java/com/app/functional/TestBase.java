package com.app.functional;

import io.restassured.builder.RequestSpecBuilder;

public class TestBase {

	//Test git pull

	public TestBase(){
		handleProxy();
	}
	
	//generate token and add it to the header
	
	public RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();

	public void handleProxy(){

	String proxyip ="";
	String proxyPort ="";

	if(proxyip !=null && proxyPort!=null){

	requestspecbuilder.setProxy(proxyip,Integer.valueOf(proxyPort));
	}
	}

	
}
