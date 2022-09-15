package com.timeKeeping.actiTime.selenium.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.timeKeeping.actiTime.selenium.pomRepository.CreateNewCustomerPage;
import com.timeKeeping.actiTime.selenium.pomRepository.HomePage;
import com.timeKeeping.actiTime.selenium.pomRepository.LoginPage;
import com.timeKeeping.actiTime.selenium.pomRepository.TaskPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public WebDriver driver;
	public JavaUtility jutlis = new JavaUtility();
	public ExcelUtility eutlis = new ExcelUtility();
	
	
	@BeforeSuite
	public void bsConfig() {
		
		System.out.println("=====Database Connectivity Established========");
	}
	@BeforeClass
	public void bcConfig() throws IOException {
		String url = jutlis.fetchDataFromPropertyFile("url");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("====The browser has been launched");
		System.out.println("=====Navigated to the URL");
		
		
	}
	@BeforeMethod
	public void bmConfig() throws IOException {
		LoginPage LogIn=new LoginPage(driver);
		String username=jutlis.fetchDataFromPropertyFile("username");
		String password=jutlis.fetchDataFromPropertyFile("password");
		
		LogIn.loginAction(username, password);
		System.out.println("===Logged in to the application=====");
	}
	@AfterMethod
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.logoutAction();
		System.out.println("======Log out from the application=====");
		
	}
	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("====The browser is closed====");
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("====The database is closed===");
	}

}
