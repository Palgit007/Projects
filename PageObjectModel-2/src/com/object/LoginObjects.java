package com.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	
	WebDriver driver;
	
	public LoginObjects(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='logon']") WebElement emailid;
	@FindBy(xpath="//*[@id='temp_password']") WebElement pwd;
	@FindBy(xpath="//*[@id='login_form']/button") WebElement login;
	@FindBy(xpath="//*[@id='modal-message-body']") WebElement msg;
	@FindBy(xpath="//*[@id='modal-message']/div[2]/div[3]/button") WebElement ok;
	
	
public WebElement Email()
{
	
	return emailid;
}
	
public WebElement PWD()
{
	
	return pwd;
}
public WebElement LOGIN()
{
	
	return login;
}
	
public WebElement MSG()
{
	
	return msg;
}
public WebElement OK()
{
	
	return ok;
}
	

}
