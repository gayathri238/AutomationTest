package pageObjects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Com.Test.Gayathri.Reusable;

public class SummaryPage extends Reusable{
	public static final String summarycheckoutbtn="//p[2]//span[contains(text(),'Proceed to checkout')]";
	public static final String addresscheckoutbtn="//button[@type='submit']/span[contains(text(),'Proceed to checkout')]";
	public static final String agreetermslnk="//div[@id='uniform-cgv']";
	public static final String paymenttypelnk="//a[@title='Pay by bank wire']";
	public static final String confirmorderlnk="//span[contains(text(),'I confirm my order')]";
	public static final String orderreference="//div[@class='box']";

	public  String confirmOrder() {
		
		clickElement(summarycheckoutbtn, 2);
		waitForPageLoad(10);
		clickElement(addresscheckoutbtn, 2);
		waitForPageLoad(10);
		clickElement(agreetermslnk, 2);
		clickElement(addresscheckoutbtn, 2);
		waitForPageLoad(10);
		clickElement(paymenttypelnk, 2);
		waitForPageLoad(10);
		clickElement(confirmorderlnk,2);
	WebElement confirmtxt=getWebElement(orderreference, 10);
		//System.out.println(confirmtxt.getText());
		Document doc = Jsoup.parse(confirmtxt.getText()); 
		String s = doc.select("body").toString();
		String ref=s.split("reference")[1];
		return ref.substring(1, 10);
	}
}
