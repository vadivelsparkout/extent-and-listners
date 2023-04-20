package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class log_json {
	@Test
    void json() throws IOException {
	ExtentReports extent = new ExtentReports();//creating object for extent report
	ExtentSparkReporter spark = new ExtentSparkReporter("json.html");//this is the path your html file will be generated
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("My_Extent_Report");
	
	extent.attachReporter(spark);
	
	String json="{\r\n"
			+ "    \"page\": 2,\r\n"
			+ "    \"per_page\": 6,\r\n"
			+ "    \"total\": 12,\r\n"
			+ "    \"total_pages\": 2,\r\n"
			+ "    \"data\": [\r\n"
			+ "        {\r\n"
			+ "            \"id\": 7,\r\n"
			+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
			+ "            \"first_name\": \"Michael\",\r\n"
			+ "            \"last_name\": \"Lawson\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 8,\r\n"
			+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
			+ "            \"first_name\": \"Lindsay\",\r\n"
			+ "            \"last_name\": \"Ferguson\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 9,\r\n"
			+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
			+ "            \"first_name\": \"Tobias\",\r\n"
			+ "            \"last_name\": \"Funke\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 10,\r\n"
			+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
			+ "            \"first_name\": \"Byron\",\r\n"
			+ "            \"last_name\": \"Fields\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 11,\r\n"
			+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
			+ "            \"first_name\": \"George\",\r\n"
			+ "            \"last_name\": \"Edwards\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 12,\r\n"
			+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
			+ "            \"first_name\": \"Rachel\",\r\n"
			+ "            \"last_name\": \"Howell\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
			+ "        }\r\n"
			+ "    ],\r\n"
			+ "    \"support\": {\r\n"
			+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
			+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
			+ "    }\r\n"
			+ "}";
	
	ExtentTest test=extent.createTest("log_json");
	test.info(MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));//log json in extend report
	
	
	
	extent.flush();//unless you call this method your report will not be generated
	Desktop.getDesktop().browse(new File("json.html").toURI());//-auto report open
	
	
	

}}
