package reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class week_config_program {
	
public static ExtentReports extent;
public static ExtentTest test;

	/*@Test (enabled = false)
	void first() {
		System.out.println("sunday");
	}
	@Test
	void second() {
		System.out.println("monday");
	}
	@Test
	void third() {
		System.out.println("tuesday");
	}
	@Test
	void fourth() {
		System.out.println("wednesday");
	}
	@Test
	void fifth() {
		System.out.println("thursday");
	}
	@Test
	void sixth() {
		System.out.println("friday");
	}
	@Test
	void seventh() {
		System.out.println("saturday");
	}*/
	
	@Test(priority = 2)
	void before_Class() {
		
		//initializing the report
		ExtentReports extent = new ExtentReports();//creating object for extent report
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");//this is the path your html file will be generated
		//Extendsparkreporter is a kind of reporter
		//we can add more than one reporter
		//extent.attachReporter(spark,object,object)-this is the format
		
		

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
		
		
		//second set of testcases
		ExtentTest test2=extent.createTest("week_Test2");//name the test
		test2.pass("days_Passed");
		test2.fail("days_Fail");
		test2.skip("days_Skipped");
		test2.info("test_Started");
		extent.flush();//unless you call this method your report will not be generated
		
	}
	
	
}
