package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class multiple_reports {
	
	//i have to generate reports for only failed testcases

	@Test(priority = 1)
	void before_Class() throws IOException {
		
		//initializing the report
		ExtentReports extent = new ExtentReports();//creating object for extent report
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");//this is the path your html file will be generated
		//Extendsparkreporter is a kind of reporter
		//we can add more than one reporter
		//extent.attachReporter(spark,object,object)-this is the format
		
		// create file for failed test cases
		ExtentSparkReporter spark_failed=new ExtentSparkReporter("failed.html").filter().statusFilter().as(new Status [] {Status.FAIL}).apply();
		spark_failed.config().setDocumentTitle("fail report generation");//config fail report
		
 
		extent.attachReporter(spark_failed);
		//step node,test node-in extent report?
		
		
		
		//we can config extent report
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My_Extent_Report");
		spark.config().setReportName("extend report demo");
		//spark.config().  -view types of config available-type set & get to know
		
		
		
		extent.attachReporter(spark);
		
		
		
		//first set of testcases
		ExtentTest test=extent.createTest("week_Test");//name the test
		test.assignAuthor("authour name");//who created this report
		test.assignCategory("smoke test");//what type of test is performed
		test.assignDevice("chrome");//what type of browser or device name
		test.pass("days_Passed");
		test.fail("days_Fail");
		test.skip("days_Skipped");
		test.info("test_Started");
		
		extent.flush();//unless you call this method your report will not be generated
		Desktop.getDesktop().browse(new File("failed.html").toURI());
}}
