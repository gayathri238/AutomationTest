package stepDefinations;

import Com.Test.Gayathri.Reusable;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Reusable{

	
	@Before("@FunctionalTest")
	public void beforevaldiation()
	{
		System.out.println("Before Functional  hook");
		invokeDriver();
	}
	@After("@FunctionalTest")
	public void aftervaldiation()
	{
		System.out.println("After Functional  hook");
		quitDriver();
	}
	
	
	}

