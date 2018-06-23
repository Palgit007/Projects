package com.calendar.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarDemo {
	
	WebDriver driver;
	
	String URL="https://jqueryui.com/datepicker/";
	
	@Test
	
	public void gotoDatePickerPage(){
		
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser launched");
		driver.get(URL);
		System.out.println("Page title is "+driver.getTitle());

		driver.switchTo().defaultContent();
		
		int framesize=driver.findElements(By.tagName("iframe")).size();
		System.out.println("size of iframe is=== "+framesize);
		
		driver.switchTo().frame(0);
		WebElement dateTextFld=driver.findElement(By.cssSelector("#datepicker"));
		dateTextFld.click();

		
		
		String month=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
		
	System.out.println("Displayed month is -->"+month);
	
	while(!driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText().contains("July 2018"))
	{
		
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]")).click();
		
	}
	
	
	System.out.println("July 2018 is selected");
	
	List<WebElement>   Alldate=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
	
	int dateCount=Alldate.size();
	
	for(int i=0;i<dateCount;i++){
		
		
		String date=driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
		
		if(date.equalsIgnoreCase("21"))
		{
			driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
			//System.out.println("21st of July 2018 is selected ");
			break;
			
		}
			
			
	}
	
		driver.close();
	}
	
	
	
	
	

}
