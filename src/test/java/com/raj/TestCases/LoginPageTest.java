package com.raj.TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.raj.Base.TestBase;
import com.raj.Pages.HomePage;
import com.raj.Pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		init();
		
		loginPage = new LoginPage();
	}
	
	
	@Test (priority = 1)
	public void validateLoginPageTitle() {
		String actualTitle = loginPage.homePageTitle();
		
		Assert.assertEquals(actualTitle, "Free CRM software in the cloud powers sales and customer service");
		log.info("Home Page Launched");
	}
	
	
	@Test (priority = 2)
	public void verifyCrmLogoImgTest() {
		boolean logo = loginPage.homePageLogo();
		
		Assert.assertTrue(logo);
	}
	
	
	@Test (priority = 3)
	public void verifyLoginTest() {
		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pwd"));
	}
	
	
	@AfterMethod
	public void close() {
		tearDown();
	}
	
	
}
