package com.raj.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.raj.Base.TestBase;
import com.raj.Pages.ContactsPage;
import com.raj.Pages.DealsPage;
import com.raj.Pages.HomePage;
import com.raj.Pages.LoginPage;
import com.raj.Pages.TasksPage;
import com.raj.Utils.TestUtil;

public class HomePageTest extends TestBase{

	TestUtil testUtil;
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		init();

		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pwd"));
		testUtil.switchToFrame("mainpanel");

	}

	
	@Test (priority = 1)
	public void validateHomePageTitle() {
		String actualTitle = homePage.homePageTitle();
		Assert.assertEquals(actualTitle, "CRMPRO");
	}
	
	@Test (priority = 2)
	public void verifyUserNameDisplay() {
		Assert.assertTrue(homePage.nameLable());
	}
	
	@Test (priority = 3)
	public void verifyClickContactsLink() {
		homePage.clickContacts();
	}
	
	@Test (priority = 4)
	public void verifyClickDealsLink() {
		homePage.clickDeals();
	}
	
	@Test (priority = 5)
	public void verifyClickTasksLink() {
		homePage.clickTasks();
	}
	
	
	@AfterMethod
	public void close() {
		tearDown();
	}
}
