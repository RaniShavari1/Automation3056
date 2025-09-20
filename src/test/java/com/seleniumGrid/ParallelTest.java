package com.seleniumGrid;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ParallelTest {
	public WebDriver driver;

@Parameters({ "bname" })
@Test
public void crossBrowserTesting(String bname) throws InterruptedException {
    System.out.println("RemoteDriver connectivity is started");

    try {
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        if (bname.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(gridUrl, new ChromeOptions());
            System.out.println("Session created on Chrome");
        } else if (bname.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(gridUrl, new FirefoxOptions());
            System.out.println("Session created on Firefox");
        } else if (bname.equalsIgnoreCase("edge")) {
            driver = new RemoteWebDriver(gridUrl, new EdgeOptions());
            System.out.println("Session created on Edge");
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + bname);
        }

        System.out.println("RemoteDriver connectivity is completed");

        driver.get("https://www.amazon.in/");
        Thread.sleep(6000);
        System.out.println("Page title: " + driver.getTitle());

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to: " + e.getMessage());
    } finally {
        if (driver != null) {
           // driver.quit();
        }
    }
}
}


