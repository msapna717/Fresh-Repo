package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.Util.TestUtil;
import com.qa.pages.HomePage;
import com.qa.pages.RegistrationPage;

public class RegistrationPageTest extends BaseClass {
	HomePage HPG;
	RegistrationPage RPG;
	String SheetName="TestData";
	
  public RegistrationPageTest()
	{
		super();
	}
	
	
@BeforeMethod
      public void setup() throws MalformedURLException
     {
	
	  initialization();
	  HPG=new HomePage();
	  RPG=HPG.RegistrationClick();
     }


@DataProvider
public Object[][] gePOCtTestData()

{
	
	Object[][]data1=TestUtil.getTestData(SheetName);
    return data1;	
}

@Test(dataProvider="gePOCtTestData")
     public void ResgistrationTest(String A, String B, String C, String D)
    {
	RPG.Registration(A, B, C, D);
    }
	
@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
		
}


