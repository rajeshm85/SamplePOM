package com.raj.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raj.Base.TestBase;
import com.raj.Utils.JSUtils;

public class LoginPage extends TestBase{
	
	// OR of LoginPage
	@FindBy (name="username")
	private static WebElement userName;
	
	@FindBy (name="password")
	private static WebElement password;
	
	@FindBy (xpath="//input[@type='submit']")
	private static WebElement loginBtn;
	
	@FindBy (xpath="//button[contains(text(),'Sign Up')]")
	private static WebElement signupBtn;
	
	@FindBy (xpath="//img[@alt=\"free crm logo\"]")
	private static WebElement homepageLogo;
	
	
	// Initialize the OR
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean homePageLogo() {
		return homepageLogo.isDisplayed();
	}
	
	public HomePage login(String user, String pwd) {
		userName.sendKeys(user);
		password.sendKeys(pwd);
		JSUtils.jsclick(loginBtn); 		//	loginBtn.click();
		
		return new HomePage();
	}
}
