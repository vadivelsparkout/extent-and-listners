package reports;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.util.IOUtil;
import com.google.common.io.Files;

import io.netty.handler.codec.base64.Base64Encoder;


//take screenshot as png,jpg file-attach to the report
//take screenshot as png,jpg file-convert in a form of base64-attach to the report
//take screenshot as base64-attach to the report(recommended way)
public class attach_Screenshot {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	void before() {
		 report=new ExtentReports();
		 spark=new ExtentSparkReporter("screenshot.html");
		 spark.config().setDocumentTitle("screenshot");
	     report.attachReporter(spark);
	     test=report.createTest("screenShot_testing");
	}
	@Test(description = "first method")
	void screenShot() throws IOException {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
        driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		//attaching screenshot to the report
	    test.addScreenCaptureFromPath(getscreenshot());
	    //drawback-if you send this report to the client ss will not show because when you inspect that pic src will direct to your local storage path
	    
	    //attaching png-base64 ss
	    test.addScreenCaptureFromBase64String(getssasbase64());
	    
	    //attaching base64 directly
	    test.addScreenCaptureFromBase64String(getbase64_directly());
	
	}
	
	//method to return value when this called
	String getscreenshot() throws IOException {

		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
		String path="D:\\\\version2023\\\\flow_cicd1\\\\ss_Shot\\\\new5.png";
		
		File trg2 = new File("D:\\version2023\\flow_cicd1\\ss_Shot\\new5.png");

		Files.copy(src2, trg2);
		
		return path;
	}
	
	//method to converting png to base64
	String getssasbase64() throws IOException {
		
       File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
		String path="D:\\\\version2023\\\\flow_cicd1\\\\ss_Shot\\\\new6.png";
		
		File trg2 = new File("D:\\version2023\\flow_cicd1\\ss_Shot\\new6.png");

		Files.copy(src2, trg2);
		
		//converting string into byte
		byte[] newpath = path.getBytes();
	   //converting into base64 and return
		return Base64.getEncoder().encodeToString(newpath);
		
	}
	
	//taking pic as base64 directly
	String getbase64_directly() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				
	}
	
	
	@AfterTest
	void after() {
		report.flush();
		try {
			Desktop.getDesktop().browse(new File("screenshot.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}