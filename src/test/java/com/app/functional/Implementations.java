package com.app.functional;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Implementations extends TestBase{
	
	
	public RequestSpecification setHeaders(){

		RequestSpecification request = RestAssured.given(requestspecbuilder.build());

		List<Header> headerlist = new ArrayList<Header>();

		GlobalProperties.getGlobalHeaders().forEach((key,value)->headerlist.add(new Header(key,value)));
		Headers headers = new Headers(headerlist);
		return request.headers(headers);

		}

		public Response getTest(){

		RequestSpecification request = setHeaders();
		request.log().all();

		Response response = null;
		response = request.get(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setResponse(response);
		return response;
		}

		public Response postTest(){
		RequestSpecification request = setHeaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();
		Response response = null;
		response=request.post(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setResponse(response);
		return response;
		}

		public Response putTest(){

		RequestSpecification request = setHeaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();

		Response response = null;
		response = request.put(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setResponse(response);
		return response;
		}


}
