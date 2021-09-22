package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CopyShippingAddress extends WebDriverUtility {

	
	WebDriver driver;
	
	public CopyShippingAddress(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="subject")
	private WebElement subjected;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement header;
	
	@FindBy(name="bill_street")
	private WebElement billadd;
	
	public WebElement getBilladd() {
		return billadd;
	}



	public WebElement getHeader() {
		return header;
	}

	@FindBy(name="ship_street")
	private WebElement shippadd;
	
	@FindBy(id="searchIcon1")
	private WebElement itemname;
	
	public WebElement getSelectit() {
		return selectit;
	}
	
	@FindBy(id="qty1")
	private WebElement quantityed;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copybd;

	@FindBy(id="popup_product_14")
	private WebElement selectit;
	
	public WebElement getItemname() {
		return itemname;
	}

	@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement copysd;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement addvendor;
	
	@FindBy(xpath="//a[text()='adcd']")
	private WebElement selectvendor;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement save;
	

	//getters
	public WebElement getSubjected() {
		return subjected;
	}

	

	public WebElement getShippadd() {
		return shippadd;
	}

	public WebElement getCopybd() {
		return copysd;
	}

	public WebElement getAddvendor() {
		return addvendor;
	}

	public WebElement getSelectvendor() {
		return selectvendor;
	}

	public WebElement getSave() {
		return save;
	}
	//access
	
	
	public void create(String subname,String shippadress,int qN)
	{
		subjected.sendKeys(subname);
		copysd.click();
		shippadd.sendKeys(shippadress);
		quantityed.sendKeys(""+qN);
		
			
	}
	public void create1()
	{
		String parent = driver.getWindowHandle();
		addvendor.click();
		switchToWindow(driver,"Vendors");
		selectvendor.click();
		
		driver.switchTo().window(parent);
		//switchToWindow(driver,"PurchaseOrder");
		
	}
	
	public void create2()
	{
		String parent = driver.getWindowHandle();
		itemname.click();
		switchToWindow(driver,"Products");
		selectit.click();
		driver.switchTo().window(parent);
		save.click();
	}
	
	public void create3(String subname,String billaddress,String itname, int qN)
	{
		subjected.sendKeys(subname);
		billadd.sendKeys(billaddress);
		copybd.click();
		//shippadd.sendKeys(shippaddress);
		//itemname.sendKeys(itname);
		//switchToWindow(driver,"Products");
		//selectit.click();
		quantityed.sendKeys(""+qN);
		//addvendor.click();
		//switchToWindow(driver,"Vendors");
		//selectvendor.click();
		//copybd.click();
		//save.click();
		
		
		
	}
	
	public String getinfo(WebDriver driver) {
		String value = header.getText();
		return  value;
	}

	public WebElement getQuantityed() {
		return quantityed;
	}
}
