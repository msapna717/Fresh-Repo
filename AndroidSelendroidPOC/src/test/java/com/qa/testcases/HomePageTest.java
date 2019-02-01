package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.Util.TestUtil;
import com.qa.pages.HomePage;

public class HomePageTest extends BaseClass {
	HomePage HPG;
	TestUtil TUL;
	
  public HomePageTest()
	{
		super();
	}
	
	
@BeforeMethod
public void setup() throws MalformedURLException
{
	
	initialization();
	HPG=new HomePage();
	TUL=new TestUtil();
}

        

@Test(priority=1)
	    public void Basicfucntioanlities()
	   {
		
		HPG.Entertext("ishan sharma");
		HPG.CheckBoxfunction();
	   }
	
@Test(priority=2)
	    public void Popuphandling()
	   {
		
		HPG.PopupAlert();
	   }

@AfterMethod
	   public void teardown()
	  {
		driver.quit();
	  }
		
}

