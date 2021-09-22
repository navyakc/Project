package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	
	//constructor
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratored;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signouted;
		
	public WebElement getAdministratored() {
			return administratored;
		}

		public WebElement getSignouted() {
			return signouted;
		}


	@FindBy (linkText="More")
	private WebElement moreed;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseordered;
	
	@FindBy (xpath="//img[@title='Create Purchase Order...']")
	private WebElement createpurchaseed;

	//generate getters
	public WebElement getMoreed() {
		return moreed;
	}

	public WebElement getPurchaseordered() {
		return purchaseordered;
	}

	public WebElement getCreatepurchaseed() {
		return createpurchaseed;
	}
	
	//access
	
	public void signout(WebDriver driver)
	{
		mouseOver(driver,administratored);
		signouted.click();
	}
	public void more(WebDriver driver)
	{
	

		mouseOver(driver,moreed);
		purchaseordered.click();
	}
	public void clickcreate()
	{
		createpurchaseed.click();
	}
	
	
}
