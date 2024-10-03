package com.automation.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class FrameworkScript {

	protected WebDriver driver = null;

	// Open Browser
	@Parameters({ "Browser" })
	@BeforeTest
	public void openBrowser(@Optional("chrome") String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));

		driver.manage().window().maximize();

	}

	// CLose Browser
	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(2000);

		driver.quit();
	}

}
