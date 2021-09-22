package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//identify webelements
	@FindBy(name="user_name")
	private WebElement usernameed;
	
	
	@FindBy(name="user_password")
	private WebElement passworded;
	
	
	@FindBy(id="submitButton")
	private WebElement logined;

	//getters

	public WebElement getUsernameed() {
		return usernameed;
	}


	public WebElement getPassworded() {
		return passworded;
	}


	public WebElement getLogined() {
		return logined;
	}
	
	//access the webelements
	public void login(String username, String password)
	{
		usernameed.sendKeys(username);
		passworded.sendKeys(password);
		logined.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
