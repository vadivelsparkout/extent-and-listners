package reports;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewConfigurer;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class customizing_report {
	@Test
    void json() throws IOException {
	ExtentReports extent = new ExtentReports();//creating object for extent report
	
	//customizing view of report
	ExtentSparkReporter spark = new ExtentSparkReporter("custom.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("My_Extent_Report");
	
	extent.attachReporter(spark);
	
	ExtentTest test=extent.createTest("week_Test");//name the test
	test.assignAuthor("authour name");//who created this report
	test.assignCategory("smoke test");//what type of test is performed
	test.assignDevice("chrome");//what type of browser or device name
	test.pass("days_Passed");
	
	
	//printing list of string in report
	ArrayList<String> words=new	ArrayList<String>();
	words.add("new");
	words.add("extent report");
	words.add("for loop");
	
	for (String newss : words) {
		System.out.println(newss);
		
		//passing the list-inside loop diff line
		test.pass(MarkupHelper.createOrderedList(newss));
	}
	
	

	//if you don't want to be numbered -create unorderlist-outside loop same line
	test.pass(MarkupHelper.createUnorderedList(words));
	
	
	//want to log Map
	Map<String,Integer> value=new HashMap<String, Integer>();
	value.put("one", 1);
	value.put("two", 2);
	value.put("three", 3);
	
	for (Map.Entry<String, Integer> entry : value.entrySet()) {
		String key = entry.getKey();
		Integer val = entry.getValue();
		
		System.out.println(key+":"+val);
		
		//log map-diff line
		test.pass(key+":"+val);
	}
	
	//log map-sameline
	test.pass(MarkupHelper.createOrderedList(value));
	
	
	
	
	
	//color perticular case
	test.pass(MarkupHelper.createLabel("days_Passed", ExtentColor.GREEN));
	
	
	test.fail("days_Fail");
	test.skip("days_Skipped");
	test.info("test_Started");
	
	extent.flush();
}
}