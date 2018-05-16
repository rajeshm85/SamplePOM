package com.raj.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raj.Base.TestBase;

public class TasksPage extends TestBase{

	@FindBy (xpath="//td[contains(text(),'Tasks')]")
	private static WebElement contactsTable;
	
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
}
