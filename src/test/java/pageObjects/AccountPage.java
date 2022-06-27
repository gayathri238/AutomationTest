package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Test.Gayathri.Reusable;


public class AccountPage extends Reusable{
	public WebDriver driver;
	
	public static final String viewaccountlnk="//span[contains(text(),'Illakkiya')]";
	public static final String orderhistorylnk="//span[contains(text(),'Order history and details')]";	
	public static final String ordernolnk="//a[contains(text(),'odernumber')]";
	public static final String personaldetaillnk="//span[contains(text(),'My personal information')]";
	public static final String fnametxtbox="//input[@id='firstname']";
	public static final String oldpwdtxtbox="//input[@id='old_passwd']";
	public static final String newpwdtxtbox="//input[@id='passwd']";
	public static final String cfmpwdtxtbox="//input[@id='confirmation']";
	public static final String savebtn="//button[@name='submitIdentity']";
	public static final String alertcontent="//p[contains(@class,'alert alert-success')]";
	
	public  void verifyOrder(String orderno) {
		System.out.println(orderno);
		clickElement(viewaccountlnk, 2);
		waitForPageLoad(10);
		clickElement(orderhistorylnk, 2);
		waitForPageLoad(10);
		Assert.assertTrue("Order is successfully placed",isElementPresent(ordernolnk.replace("odernumber", orderno), 5));
		
	}
	
	public void updatePersonalInformation(String firstname ,String Password ) {
		clickElement(viewaccountlnk, 2);
		waitForPageLoad(10);
		clickElement(personaldetaillnk, 2);
		waitForPageLoad(10);
		enterText(fnametxtbox, firstname, 2);
		enterText(oldpwdtxtbox, Password, 2);
		enterText(newpwdtxtbox, Password, 2);
		enterText(cfmpwdtxtbox, Password, 2);
		getWebElement(savebtn, 2).click();
	}
	
	public void verifySuccessfulMessage() {
		String alertmessage=getWebElement(alertcontent, 2).getText();
		Assert.assertTrue("Order is successfully placed",alertmessage.contains("Your personal information has been successfully updated."));
	}
}
