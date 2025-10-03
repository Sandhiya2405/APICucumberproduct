package com.app.functional;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\mkpan\\eclipse-workspace\\sand\\APICucumberTest_Product\\src\\test\\java\\com\\app\\functional\\Product.feature",
glue = "com.app.functional",
dryRun = false,

publish = true,
monochrome = true,
plugin = {
		"pretty",
		"html:target/cucumberreport.html",
		"json:target/cucumberreport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})

public class Runners {

}
