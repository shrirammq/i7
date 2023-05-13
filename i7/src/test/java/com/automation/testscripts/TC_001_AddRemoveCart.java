package com.automation.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;

public class TC_001_AddRemoveCart extends FrameworkScript {

	@Test(dataProvider = "getTestdata")
	public void addRemove(String userName, String password) throws Exception {

		// Login

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login-button")).click();

		// Add To Cart

		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		Thread.sleep(2000);

		// Remove From Cart

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		// Logout

		Thread.sleep(2000);

		driver.findElement(By.id("logout_sidebar_link")).click();

	}
	
	@DataProvider(name = "getTestdata")
	public String[][] getTestdata() throws Exception {
		return ExcelHelper.getTestdata("E:\\Testdata.xlsx", "Sheet1");
	}

}
