package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
WebDriver driver;
	
	public CreateOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement clickorg;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement clickcreateorg;
;
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy (xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveb;

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement titleb;
	
	public WebElement getSaveb() {
		return saveb;
	}

	public WebElement getTitleb() {
		return titleb;
	}

	public WebElement getClickorg() {
		return clickorg;
	}

	public WebElement getClickcreateorg() {
		return clickcreateorg;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndustry() {
		return industry;
	}
	
	
	public void create() {
		clickorg.click();
		clickcreateorg.click();
	}
	
	public void createOrganizationwithIndustry(String orgn, String indusn)
	{
		orgname.sendKeys(orgn);
		handleDropDown(driver, industry, indusn);
	}
	
	public String createOrganizationinfo() {
		saveb.click();
		String tit = titleb.getText();
		return tit;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
