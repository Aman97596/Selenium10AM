package com.timeKeeping.actiTime.selenium.com.timeKeeping.actiTime.selenium;

import org.testng.annotations.Test;

public class ToPerformGroupExecution {
	@Test(groups = "smokeTesting")
	public void login() {
		
		System.out.println("Login is successful");
	}
	@Test(groups = "regressionTesting")
	public void select() {
		System.out.println("Product is selected");
	}
@Test(groups = "regressionTesting")
public void addtocart() {
	System.out.println("Product added to cart");
	
}
@Test(groups = "regressionTesting")
public void payment() {
	System.out.println("Payment is successful");
	
}
@Test(groups = "smokeTesting")
public void logout() {
	System.out.println("Logout is successful");
}

}
