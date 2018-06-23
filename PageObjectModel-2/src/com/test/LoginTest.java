package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.object.LoginObjects;

public class LoginTest {
	
	@Test
	
	public void UserLogin()
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser launched successfully");
		String URL="https://answerstest.nielsen.com";
		driver.get(URL);
		
		LoginObjects obj=new LoginObjects(driver);
		
		obj.Email().sendKeys("palani@test");
		obj.PWD().sendKeys("sdgfdg");
		obj.LOGIN().click();
		String message=obj.MSG().getText();
		System.out.println("Returned error message is expecteds-->"+message);
		obj.OK().click();
		
		
	}

}
