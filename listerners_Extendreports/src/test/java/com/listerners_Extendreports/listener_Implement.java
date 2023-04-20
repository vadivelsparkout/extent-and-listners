package com.listerners_Extendreports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class listener_Implement {
	@Test(priority = 1)
	void login() {
		System.out.println("Login by email");
		Assert.assertEquals("name", "name");
	}
	@Test(priority = 2)
	void login1() {
		System.out.println("login by name");
		Assert.assertEquals("name","no-name");
	}

}
