package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.BaseClass;

public class HomePage extends BaseClass {

	
	@FindBy(id="android:id/title")
	@CacheLookup
	WebElement Title;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='my_text_fieldCD']")
	WebElement TextBox;
	
	@FindBy(id="io.selendroid.testapp:id/startUserRegistration")
	WebElement Button;
	
	@FindBy(id="io.selendroid.testapp:id/input_adds_check_box")
	WebElement CheckBox;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='waitingButtonTestCD']")
	WebElement ProgressBar;
	
	@FindBy(id="io.selendroid.testapp:id/showPopupWindowButton")
	WebElement PopUp;
	
	//Initializing the page Objects
	
	public HomePage()
	{
		
		PageFactory.initElements(driver,this);
	}


	//Actions
	
   public String validateLoginPageTiltle()
	
	{
		return driver.getTitle();
	}
   
	public void Entertext(String name)
	{
		TextBox.sendKeys(name);
		
	}
	
	public void CheckBoxfunction()
	{
		CheckBox.click();
		
	}
	
	public void PopupAlert()
	{
		PopUp.click();
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.alertIsPresent());
	      //Alert A =driver.switchTo().alert();
		//String Alertmessage=A.getText();
        //System.out.println(Alertmessage);
		//A.accept();
		
	}
	
	public RegistrationPage RegistrationClick()
	{
         Button.click();
         return new RegistrationPage();
	}
}
