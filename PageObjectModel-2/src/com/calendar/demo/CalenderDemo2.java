package com.calendar.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalenderDemo2 {

	public WebDriver driver;

	@BeforeTest(description = "Browser setup")

	public void OpenBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Browser launched");
		driver.get("http://www.ksrtc.in/oprs-web/");

		// driver.get("https://www.goindigo.in/");

		System.out.println("Page Title is..." + driver.getTitle());

	}

	// @Test(description = "Selecting date")

	public void selectDate() {

		System.out.println("Executing Test");

		WebElement dateFld = driver.findElement(By.xpath("//*[@id='txtJourneyDate']"));

		String dateFldTxt = dateFld.getAttribute("value");
		System.out.println("Place holder is...." + dateFldTxt);
		driver.findElement(By.xpath("//*[@id='txtJourneyDate']")).click();

		System.out.println(
				"Current Month is..." + driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText());

		while (!driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText().contains("May 2018")) {
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();

		}
		System.out.println("May is selected");

		List<WebElement> AllDate = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));

		int count = AllDate.size();
		System.out.println("Number of Active date are..." + count);

		for (int i = 0; i < count; i++) {

			String currentDate = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();

			if (currentDate.equals("21")) {

				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();

				System.out.println("May 21 is selected");
				break;
			}
		}

		String searchBtnTxt = driver.findElement(By.id("searchBtn")).getAttribute("value");
		System.out.println("Search button Text..." + searchBtnTxt);

	}

	// @Test

	public void indigoDate() {

		driver.findElement(By.id("dp1524447222266")).click();

		while (driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div")).getText()
				.contains("June 2018")) {

			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();

		}

		System.out.println("June is selected");

	}

	@Test
	
	public void autoCompleteDemo(){
		
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		for(int i=0;i<=4;i++){
			
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			
			System.out.println("Key down done for "+i+"time");
			
			String Option=driver.findElements(By.xpath("//input[@id='fromPlaceName']")).get(i).getAttribute("value");
			
			if(Option.equals("BENGALURU INTERNATION AIPORT")){
				
				break;
			}
			
		}

		
	}

	@AfterTest(description = "Closing Driver")

	public void closeBrowser() {

		System.out.println("Executing After Test method");

		driver.close();

		System.out.println("Browser is closed successfully");
	}

}
