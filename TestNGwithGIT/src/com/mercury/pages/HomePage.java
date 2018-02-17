package com.mercury.pages;

import org.testng.annotations.Test;

import com.mercury.testcases.DriverScript;
import com.mercury.utilities.*;

public class HomePage extends DriverScript {
	@Test
	public static void launch() throws InterruptedException
	{
		
		ConfigReader config=new ConfigReader();
		driver.get(config.getFireFoxPath());
		//driver.get("http://localhost/servlets/com.mercurytours.servlet.WelcomeServlet");
		String actualTitle=driver.getTitle();
		System.out.println("Page Title: " + actualTitle);
		if(actualTitle.equalsIgnoreCase("Welcome: Mercury Tours"))
		{
			System.out.println(" Test 1=Launch Passed");
			HTMLFileResultsCreation.insertStep("1", "Launch", "Mercury Launch Passed", "Passed");
		}
		else
		{
			System.out.println("Test 1 = Launch Failed- Expected is 'Welcome Mercury Tours', whereas actual is '"+actualTitle+"'");
			HTMLFileResultsCreation.insertStep("1", "Launch", "Mercury Launch Failed", "Failed");
		}
	}
        @Test
	public static void closeAllBrowser()
	{
		driver.close();
		HTMLFileResultsCreation.insertStep("1", "CloseAllBrowser", "Mercury Launch Failed", "Passed");

	}

}
