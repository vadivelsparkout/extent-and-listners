package framework;

import org.testng.annotations.Test;

public class test_implement_extend extends implement_Framework {

	@Test(priority = 1)
	void newTest() {
		pass_status("firstTest pass");
	}
	@Test(priority = 2)
	void secondTest() {
		fail_status("second test fail");
	}
	@Test(priority = 3)
	void thirdstatus() {
		skip_status("this step is skipped");
	}
}
