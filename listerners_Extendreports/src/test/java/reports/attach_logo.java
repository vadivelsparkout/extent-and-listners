package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class attach_logo {
	
	
	@Test
	void logo() {
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("logo.html");
		spark.config().setDocumentTitle("logo");
	
		report.attachReporter(spark);

		
		
		ExtentTest test=report.createTest("logo_testing");
		test.pass("test_Pass");
		
		
		//add logo for the report
		MediaEntityBuilder.createScreenCaptureFromPath("C:/Users/Admin/Pictures/Saved Pictures/logo.png").build();
        test.addScreenCaptureFromPath("C:/Users/Admin/Pictures/Saved Pictures/logo.png", "FLY");
		
		
		report.flush();
		
		
		try {
			Desktop.getDesktop().browse(new File("logo.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
