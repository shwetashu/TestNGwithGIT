package com.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.testcases.DriverScript;
import com.mercury.utilities.*;

public class LoginPage extends DriverScript {
	
	static WebElement Lnk_SignOn=driver.findElement(By.linkText("SIGN-ON"));
	//static WebElement txt_userName=driver.findElement(By.name("userName"));
	//static WebElement txt_password=driver.findElement(By.name("password"));
	// static WebElement btn_submit=driver.findElement(By.name("login"));
	@Test
	public static void login() throws InterruptedException
	{
		Lnk_SignOn.click();
		ExcelUtility.getSheet("Login");
		ExcelUtility.getRow(1);
		String user=ExcelUtility.getCellData("UserName");
		String pwd=ExcelUtility.getCellData("Password");
		String pageTitle=driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		if(pageTitle.equalsIgnoreCase("Sign-on: Mercury Tours")){
			System.out.println("We are on right Login page:Sign-on: Mercury Tours");
		}
		else
		{System.out.println("We are on wrong world! Test Failed");}

		WebElement txtUserName=driver.findElement(By.name("userName"));
		txtUserName.sendKeys(user);
		WebElement txtPassword1=driver.findElement(By.name("password"));
		txtPassword1.sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		String pageTitle2=driver.getTitle();
		System.out.println("Page Title: " + pageTitle2);
		if(pageTitle2.equalsIgnoreCase("Find a Flight: Mercury Tours:"))
		{System.out.println("Test 3 = Login Pass");
		HTMLFileResultsCreation.insertStep("3", "Login", "Login Passed", "Passed");
		}
		else
		{
			System.out.println("Test 3 = Login Failed");
			HTMLFileResultsCreation.insertStep("3", "Login", "Login Failed", "Failed");
		}
	}
	//this DataProvider is not working as expected.
	@DataProvider(name="LoginData")
	public Object[][] TestLabData()
	{
		ExcelUtility.ExcelInitialzation();
		ExcelUtility.getSheet("Login");
		int TestDatacount=ExcelUtility.getRowCount();
		Object[][] data=new Object[TestDatacount][2];
		for(int TestDataItt=0;TestDataItt<TestDatacount;TestDataItt++)
		{
			data[TestDataItt][0]=ExcelUtility.getCellData(TestDataItt+1, "UserName");
			data[TestDataItt][1]=ExcelUtility.getCellData(TestDataItt+1, "Password");
		}

		return data;
	}


}
