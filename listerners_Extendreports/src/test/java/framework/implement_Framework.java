package framework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.basepackage.reporting_implement;

public class implement_Framework extends reporting_implement {
	@BeforeSuite
	void beforesuit() {
		init_Report();
		createTestCase("new test");
	}
	@AfterSuite
	void aftersuit() {
		flush();
	}

}
