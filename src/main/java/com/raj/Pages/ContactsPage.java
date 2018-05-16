package com.raj.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.raj.Base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy (xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup // Retrieves the element from the cache than from the element
	private static WebElement contactsTable;
	
	// If multiple elements, FindBy is not suitable. @FindAll has to be used
	// FindAll (  @FindBy (how = How.XPATH, using = "//*[contains(@class,'x-grid-tree-node-leaf')]")  )

	
	@FindBy (xpath="//select[@name='title']")
	private static WebElement title;
	
	@FindBy (name="first_name")
	private static WebElement firstName;
	
	@FindBy (id="surname")
	private static WebElement lastName;
	
	@FindBy (xpath="//input[@type='submit' and @value='Save']")
	private static WebElement saveBtn;

	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLabel() {
		return contactsTable.isDisplayed();
	}
	
	public void selectContacts(String cName) {
		driver.findElement(By.xpath("//a[text()='"+cName+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String t, String fn, String ln) {
		Select sel = new Select(title);
		sel.selectByValue(t);
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		saveBtn.click();
	}
	
}
