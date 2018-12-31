package com.qa.pages;

import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.BaseClass;

public class RegistrationPage extends BaseClass {
	
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='email of the customer']")
	WebElement emailid;
	
	@FindBy(id="inputUsername")
	WebElement UserName;
	
	@FindBy(id="inputPassword")
	WebElement Password;
	
	@FindBy(xpath="//android.widget.EditText[@text='Mr. Burns']")
	WebElement ClearName;
	
	@FindBy(id="inputName")
	WebElement EnterName;
	//@FindBy(id="io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	//WebElement ProgrammingLangugae;
	@FindBy(id="btnRegisterUser")
	WebElement RegisterUser;
	

	
	//Initializing the page Objects
	
		public RegistrationPage()
		{
			
			PageFactory.initElements(driver,this);
		}


		//Actions
		
	   public void Registration (String Name, String Email, String password, String NewName)
		
		{
		  UserName.sendKeys(Name);
		  emailid.sendKeys(Email);
		  Password.sendKeys(password);
		  ClearName.clear();
		  EnterName.sendKeys(NewName);
		 // RegisterUser.click();
		  //Select S =new Select(driver.findElement("input_preferedProgrammingLanguage"));
		 //S.selectByVisibleText("Java");
		  RegisterUser.click();
		  
		}
	
	
	

	

}
