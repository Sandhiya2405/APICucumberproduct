package com.app.functional;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateOauthToken extends TestBase {
	
	
	public String generateOauth(){

		String res = null;

		Response response = RestAssured.given(requestspecbuilder.build())
		.baseUri("")
		.formParam("Clientid","")
		.formParam("Client_secret","")
		.formParam("grant_access","Client_crendential")
		.formParam("scope","APPIDclaimtrust")
		.contentType(ContentType.URLENC)
		.accept(ContentType.JSON).post();

		return res = response.jsonPath().getString("access_token");
		}


}
