package com.basepackage;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reporting_implement {
	
	private static ExtentReports report;
	private static ExtentSparkReporter spark;
	private static ExtentTest test;
	
	
	public void init_Report() {
		 report=new ExtentReports();
		 spark=new ExtentSparkReporter("suit.html");
		 spark.config().setDocumentTitle("suit");
		 spark.config().setTheme(Theme.STANDARD);
		 spark.config().setDocumentTitle("new document");
	     report.attachReporter(spark);	
	}
	
	
	public void flush() {
		report.flush();
		
	}
	
	public void createTestCase(String name) {
		test=report.createTest(name);
	}
	
	public void pass_status(String status) {
		test.pass(status);
		
	}
	
	public void fail_status(String status) {
		test.fail(status);
		
	}
	
	public void skip_status(String status) {
		test.skip(status);
		
	}
	
}
