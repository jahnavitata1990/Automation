package com.test.MavenPgm;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {

	@Test
	public void DoubleClicks() throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\jahna\\OneDrive\\Desktop\\SeleniumJars\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); //run Time polymorphism

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		
		driver.manage().window().maximize(); //Maximize the winodows
		
		System.out.println(driver.getTitle());
		
	WebElement dblclickbutton =	driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	
	
	Actions act = new Actions(driver);
	
	act.doubleClick(dblclickbutton).perform();
	
	//Thread.sleep(3000);
	
	Alert alrt =driver.switchTo().alert(); //now control will go to the popup
	
	System.out.println(alrt.getText());
	
	alrt.accept(); //it will click on ok button
	
	//alrt.dismiss(); //for clicking cancel button
	
	driver.close();

	}

}
