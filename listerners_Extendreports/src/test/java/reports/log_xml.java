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

public class log_xml {
	
	

	@Test
    void json() throws IOException {
	ExtentReports extent = new ExtentReports();//creating object for extent report
	ExtentSparkReporter spark = new ExtentSparkReporter("xxml.html");//this is the path your html file will be generated
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("My_Extent_Report");
	
	extent.attachReporter(spark);
	
	String xml="<note>\r\n"
			+ "  <date>2015-09-01</date>\r\n"
			+ "  <hour>08:30</hour>\r\n"
			+ "  <to>Tove</to>\r\n"
			+ "  <from>Jani</from>\r\n"
			+ "  <body>Don't forget me this weekend!</body>\r\n"
			+ "</note>";
	
	ExtentTest test=extent.createTest("log_xml");
	test.info(MarkupHelper.createCodeBlock(xml,CodeLanguage.XML));//log json in extend report
	
	
	
	extent.flush();//unless you call this method your report will not be generated
	Desktop.getDesktop().browse(new File("xxml.html").toURI());//-auto report open
}}
