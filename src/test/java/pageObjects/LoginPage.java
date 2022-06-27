package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Test.Gayathri.Reusable;

public class LoginPage extends Reusable {
	public WebDriver driver;
	public static final String signlnk="//a[contains(text(),'Sign in')]";
	public static final String emailtxtbox="//input[@id='email']";
	public static final String paswdtxtbox="//input[@id='passwd']";
	public static final String signbtn="//button[@id='SubmitLogin']";
	
	public void launchApp()
	{
		navigateTourl(getProperty("url")) ;
	}
	
	
	public void loginApp(String username, String password)
	{
			clickElement(signlnk, 2);
			waitForPageLoad(10);
			enterText(emailtxtbox, username, 2);
			enterText(paswdtxtbox, password, 2);
			clickElement(signbtn, 2);
	}

		
}
