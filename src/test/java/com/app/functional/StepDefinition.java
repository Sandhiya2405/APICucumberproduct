package com.app.functional;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

import java.io.File;
import java.util.Map;

import org.junit.Assert;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.datatable.DataTable;

public class StepDefinition {

	@Given("Set base url {string}")
	public void set_base_url(String url) {
		RestAssured.baseURI = url;
	}

	@Given("Set basepath {string}")
	public void set_basepath(String basepath) {
		RestAssured.basePath = basepath;

	}

	@When("Set headers")
	public void set_headers(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();
		asMap.forEach((key, value) -> GlobalProperties.addGlobalHeaders(key, value));
	}

	@When("Set inputpayload {string}")
	public void set_inputpayload(String filepath) {
		File inputpayload = new File(filepath);
		GlobalProperties.setInputpayload(inputpayload);
	}

	@When("Make GET call")
	public void make_get_call() {
		new Implementations().getTest();
	}

	@When("make POST call")
	public void make_post_call() {
		new Implementations().postTest();
	}

	@When("Make PUT call")
	public void make_put_call() {
		new Implementations().putTest();
	}

	@Then("Validate status code {int}")
	public void validate_status_code(Integer int1) {
		GlobalProperties.getResponse().getStatusCode();
	}

	@Then("Validate the response {string}")
	public void validate_the_response(String value) {
		String result = GlobalProperties.getResponse().body().asString();
		result.contains(value);
	}

	@Then("Validate the id {string} as {string}")
	public void validate_the_id_as(String value, String attr) {
		String response = GlobalProperties.getResponse().body().asString();
		String actualvalue = JsonPath.parse(response).read(attr).toString();
		Assert.assertEquals(actualvalue, value);

	}

	@Then("Validate the title {string} as {string}")
	public void validate_the_title_as(String value, String attr) {
		String asString = GlobalProperties.getResponse().body().asString();
		String actualvalue = JsonPath.parse(asString).read(attr).toString();
		Assert.assertEquals(actualvalue, value);
	}

	@Then("Validate the price {string} as {string}")
	public void validate_the_price_as(String value, String attr) {
		String asString = GlobalProperties.getResponse().body().asString();
		String actualvalue = JsonPath.parse(asString).read(attr).toString();
		Assert.assertEquals(actualvalue, value);

	}

	@Then("teardown")
	public void teardown() {
		GlobalProperties.reset();
	}

}
