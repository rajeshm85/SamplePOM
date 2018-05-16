package com.raj.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raj.Base.TestBase;
import com.raj.Pages.ContactsPage;
import com.raj.Pages.DealsPage;
import com.raj.Pages.HomePage;
import com.raj.Pages.LoginPage;
import com.raj.Pages.TasksPage;
import com.raj.Utils.TestUtil;

public class ContactsPageTest extends TestBase{

	
TestUtil testUtil;
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	String contactsDataSheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		init();
		
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pwd"));
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickContacts();
	}
	
	
	@Test (priority=1)
	public void verifyContactsLable() {
		Assert.assertTrue(contactsPage.contactsLabel(), "Contact is missing in the Table");
	}
	
	@Test (priority=2)
	public void verifySelectContact() {
		contactsPage.selectContacts("Test 2");
	}
	
	@Test (priority=3)
	public void verifySelectMultipleContacts() {
		contactsPage.selectContacts("Test 2");
		contactsPage.selectContacts("Test 1");
	}
	
	@DataProvider // ---------------------START FRM HERE
	public Object[][] getContactsRegTestData() {
		Object[][] data = TestUtil.getTestData(contactsDataSheetName);
		return data;
	}
	
	@Test (priority=4, dataProvider="getContactsRegTestData")
	public void validateCreateNewContact(String t, String fn, String ln) {
		homePage.clickNewContactLink();
//		contactsPage.createNewContact("Mr.", "Test", "3");
		contactsPage.createNewContact(t, fn, ln);
	}
	
	
	@AfterMethod
	public void close() {
		tearDown();
	}
}
