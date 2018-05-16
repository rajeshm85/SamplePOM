package com.raj.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raj.Base.TestBase;

public class DealsPage extends TestBase {

	@FindBy (xpath="//td[contains(text(),'Deals')]")
	private static WebElement contactsTable;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
}
