package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Com.Test.Gayathri.Reusable;

public class OrderPage extends Reusable{
	public static final String tshirtlnk="//li[3]/a[contains(text(),'T-shirts') and @Title='T-shirts']";
	public static final String tshirtnamelnk="//a[contains(text(),'Faded Short Sleeve T-shirts')]";	
	public static final String addtocartlnk="//span[contains(text(),'Add to cart')]";	
	public static final String checkoutlnk="//span[contains(text(),'Proceed to checkout')]";

	public  void orderTshirt() {
		System.out.println("tshirt");
		clickElement(tshirtlnk, 2);
		waitForPageLoad(10);
		Actions actions = new Actions(driver);
		WebElement target = getWebElement(tshirtnamelnk, 10);
		actions.moveToElement(target).perform();
		clickElement(addtocartlnk, 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(checkoutlnk, 10);
		waitForPageLoad(10);
	}
}
