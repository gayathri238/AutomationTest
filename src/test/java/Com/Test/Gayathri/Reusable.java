package Com.Test.Gayathri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusable {
	public static WebDriver driver;
	public static Properties prop;

	public static String getProperty(String property) {
		String value="";
		//Configuring Global variables
				prop=new Properties();
				FileInputStream fis;
				try {
					fis = new FileInputStream("."+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+ "global.properties");
					prop.load(fis);
					value=prop.getProperty(property);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
	}
	public static WebDriver invokeDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver =new ChromeDriver(options);
		return driver;
	}
	
	public static void navigateTourl(String url) 
	{
		driver.navigate().to(url);
		waitForPageLoad(10);
		

	}
	public static void quitDriver() 
	{
		driver.close();
		driver.quit();
		

	}
	public WebElement getWebElement(String xpath,int timeout)
	{
		WebElement element=null;
		//driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		try {
		element=driver.findElement(By.xpath(xpath));
		}
		catch (Exception e) {
			System.out.println("Error in identifying webelement:"+e.getMessage());
		}
		return element;
	}
	
	public boolean isElementPresent(String xpath,int timeout)
	{
		boolean flag  =false;
		
		try {
			WebElement element=driver.findElement(By.xpath(xpath));
		for(int x=0;x<timeout;x++)
		{
		if(element.isDisplayed())
		{
			flag =true;
			break;
		}
		}
		}
		catch (Exception e) {
			System.out.println("Error in verifying presence of webelement:"+e.getMessage());
		}
		return flag;
	}
	
	public void clickElement(String element,int timeout)
	{
		if(isElementPresent(element, timeout))
			getWebElement(element,timeout).click();
		
	}
	public void enterText(String element,String value,int timeout)
	{
		if(isElementPresent(element, timeout))
		{
			getWebElement(element,timeout).sendKeys(value);
	
		}
	}
	public static void waitForPageLoad(int timeout)
	{
		int x=1;
		//WebDriverWait wait = new WebDriverWait(driver, timeout);
		while(!	((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")&&x<timeout){
		driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
		}
	}

}
