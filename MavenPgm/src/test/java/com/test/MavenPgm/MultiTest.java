package com.test.MavenPgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Initalization() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\jahna\\OneDrive\\Desktop\\SeleniumJars\\chromedriver.exe");

		 driver = new ChromeDriver(); //run Time polymorphism

		driver.get("https://www.amazon.com");
		
		
		
		driver.manage().window().maximize(); //Maximize the winodows
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
	}
	
	
	@Test(priority=1)
	public void SelectDropDown() throws InterruptedException
	{
		
		
		WebElement selloc = driver.findElement(By.id("searchDropdownBox"));
		
		Select sel = new Select(selloc);
		
		sel.selectByIndex(5); //
		
		sel.selectByValue("search-alias=computers-intl-ship"); //medium priority
		
		sel.selectByVisibleText("Health & Household"); //high priority
		
		List<WebElement> li = sel.getOptions();
		
		System.out.println(li.size());
		
		
	}
	
	
	@Test(priority=2)
	public void MouseHovering() throws InterruptedException
	{
		
		
		WebElement accountlist = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(accountlist).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		
		

	}
	
	@AfterMethod
	public void CleanUp()
	{
		driver.close();
	}

}
