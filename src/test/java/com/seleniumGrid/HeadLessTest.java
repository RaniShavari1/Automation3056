package com.seleniumGrid;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HeadLessTest {
	@Test
	public void f() {
		
		  ChromeOptions option = new ChromeOptions();
		  option.addArguments("--headless");
		 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("url: " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium dev", Keys.ENTER);
		System.out.println("seleniumDev_url: " + driver.getTitle());
	}
}
