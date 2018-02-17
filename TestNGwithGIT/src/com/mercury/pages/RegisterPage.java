package com.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mercury.testcases.DriverScript;
import com.mercury.utilities.*;

public class RegisterPage extends DriverScript {
	static WebElement Lnk_register;
	public static void registerUser()
	{

		Lnk_register=driver.findElement(By.linkText("REGISTER"));
		
		Lnk_register.click();
		ExcelUtility.getSheet("RegisterUser");
		ExcelUtility.getRow(1);
		String user=ExcelUtility.getCellData("UserName");
		String pwd=ExcelUtility.getCellData("Password");

		driver.findElement(By.name("firstName")).sendKeys("Ashutosh");
		driver.findElement(By.name("lastName")).sendKeys("Verma");

		WebElement txtPhone=driver.findElement(By.name("phone"));

		txtPhone.sendKeys("9730586707");

		WebElement txtEmail=driver.findElement(By.name("email"));
		txtEmail.sendKeys("ashutosh.verma299@gmail.com");

		WebElement txtAddress=driver.findElement(By.name("address1"));
		txtAddress.sendKeys("Wakad");

		WebElement txtCity=driver.findElement(By.name("city"));
		txtCity.sendKeys("Pune");

		WebElement txtState=driver.findElement(By.name("state"));
		txtState.sendKeys("Maharashtra");

		WebElement txtPin=driver.findElement(By.name("postalCode"));
		txtPin.sendKeys("411057");
		WebElement ele=driver.findElement(By.name("country"));
		Select list=new Select(ele);
		list.selectByVisibleText("INDIA");
		WebElement txtUser=driver.findElement(By.name("userName"));
		txtUser.sendKeys(user);
		WebElement txtPassword=driver.findElement(By.name("password"));
		txtPassword.sendKeys(pwd);
		WebElement txtconfPassword=driver.findElement(By.name("confirmPassword"));
		txtconfPassword.sendKeys(pwd);
		WebElement linkSubmit=driver.findElement(By.name("register"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		linkSubmit.click();
		String actualTitle=driver.getTitle();
		System.out.println("Page Title: " + actualTitle);
		if(actualTitle.equalsIgnoreCase("Register: Mercury Tours"))
		{
			System.out.println("Test 2 = Register Pass");
			HTMLFileResultsCreation.insertStep("2", "Register", "Mercury Register Passed", "Passed");
		}
		else{
			System.out.println("Test2 = Register Failed");
			HTMLFileResultsCreation.insertStep("2", "Register", "Mercury Register Failed", "Failed");
		} 

	}

	
}
