package com.mercury.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.utilities.ExcelUtility;
import com.mercury.utilities.*;
//making change in master
public class DriverScript {

	public static WebDriver driver;
	@Test(dataProvider="TestLabData")
	public void testOne(String TestCaseName, String ExecutionFlag){
		try{

			if (ExecutionFlag.equalsIgnoreCase("Y")) {

				HTMLFileResultsCreation.createHeader(TestCaseName);

				String BrowserName="Firefox";
				if(BrowserName.equalsIgnoreCase("Firefox"))
					driver =new FirefoxDriver();
				else
				{
					System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
					driver=new ChromeDriver();
				}
				ExcelUtility.getSheet(TestCaseName);
				int stepCount=ExcelUtility.getRowCount();
				for (int i = 1; i <=stepCount; i++) {
					ExcelUtility.getSheet(TestCaseName);
					ExcelUtility.getRow(i);
					String MethodName=(ExcelUtility.getCellData("StepName"));
					String className=(ExcelUtility.getCellData("PageName"));

					Class c=Class.forName("com.mercury.pages."+className);
					Object obj=c.newInstance();

					Method m=c.getMethod(MethodName, null);
					m.invoke(obj,null);

				}
			}

		}
		catch(Exception e)
		{
			System.out.println("Try is failed:" + e.getMessage());
		}
	}

	@DataProvider(name="TestLabData")
	public Object[][] TestLabData()
	{
		ExcelUtility.ExcelInitialzation();
		ExcelUtility.getSheet("TestLab");
		int TestDatacount=ExcelUtility.getRowCount();
		Object[][] data=new Object[TestDatacount][2];
		for(int TestDataItt=0;TestDataItt<TestDatacount;TestDataItt++)
		{
			data[TestDataItt][0]=ExcelUtility.getCellData(TestDataItt+1, "TestCaseName");
			data[TestDataItt][1]=ExcelUtility.getCellData(TestDataItt+1, "ExecutionFlag");
		}

		return data;
	}
}

