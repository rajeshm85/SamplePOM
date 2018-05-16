package com.raj.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raj.Base.TestBase;
import com.raj.Utils.JSUtils;

public class HomePage extends TestBase {

	@FindBy (xpath="//td[contains(text(),'User: Rajesh M')]")
	private static WebElement userNameLabel;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	private static WebElement contactsBtn;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	private static WebElement dealsBtn;
	
	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	private static WebElement tasksBtn;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	private static WebElement newContactBtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean nameLable() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickContacts() {
		JSUtils.jsclick(contactsBtn);//contactsBtn.click();	
		return new ContactsPage();
	}
	
	public DealsPage clickDeals() {
		JSUtils.jsclick(dealsBtn);//dealsBtn.click();		
		return new DealsPage();
	}
	
	public TasksPage clickTasks() {
		JSUtils.jsclick(tasksBtn);//tasksBtn.click();		
		return new TasksPage();
	}
	
	public void clickNewContactLink() {
		Actions act = new Actions(driver);
		act.moveToElement(contactsBtn).build().perform();
		
//		WebDriverWait w = new WebDriverWait(driver, 8);
//		w.until(ExpectedConditions.visibilityOf(newContactBtn));
//		newContactBtn.click();
		JSUtils.jsclick(newContactBtn);
	}
	
}