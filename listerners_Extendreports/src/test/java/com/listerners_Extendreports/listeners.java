package com.listerners_Extendreports;

import java.util.List;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listeners extends TestListenerAdapter{

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("test_pass");
		super.onTestSuccess(tr);
		List<ITestResult> passedTests = getPassedTests();
		System.out.println(passedTests);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
	System.out.println("testfail");
		super.onTestFailure(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
		super.onTestSkipped(tr);
		System.out.println("test_skip");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		super.onTestStart(result);
		System.out.println("test starts");
	}
	
	

}
