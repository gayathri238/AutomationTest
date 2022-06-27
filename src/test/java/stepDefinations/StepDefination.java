package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.OrderPage;
import pageObjects.SummaryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;


import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Com.Test.Gayathri.Reusable;


@RunWith(Cucumber.class)
public class StepDefination extends Reusable {

	LoginPage loginPage=new LoginPage();

	@Given("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_and_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage loginPage=new LoginPage();
		loginPage.launchApp();
		loginPage.loginApp(arg1, arg2);
	    
	}

	@When("^Order Tshirt$")
	public void order_Tshirt() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		OrderPage orderPage=new OrderPage();
		orderPage.orderTshirt();
		
	}
	
	@Then("^History is populated with order details$")
	public void history_is_populated_with_order_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SummaryPage summaryPage=new SummaryPage();
		String order=summaryPage.confirmOrder();
		AccountPage acc=new AccountPage();
		acc.verifyOrder(order);
	}
	
	@When("^Update First Name with \"([^\"]*)\" in Account Page with password \"([^\"]*)\"$")
	public void update_First_Name_with_in_Account_Page_with_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		AccountPage acc=new AccountPage();
		acc.updatePersonalInformation(arg1,arg2);
	}

	@Then("^Personal Information should be saved$")
	public void personal_Information_should_be_saved() throws Throwable {
		AccountPage acc=new AccountPage();
		acc.verifySuccessfulMessage() ;
	}
}