package com.automation;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;

public class DriverScript extends FrameworkScript {

	@DataProvider(name = "getTestData")
	public String[][] getTestData() throws Exception {
		return ExcelHelper.getTestData("E:\\Keyworddriven.xlsx", "Sheet1");
	}

	@Test(dataProvider = "getTestData")
	public void execute(String tcName, String description, String action, String properties, String data) {
		
		WebElement webElement = null;
		
		//Find Element
		if(ObjectUtils.isNotEmpty(properties)) {
			String locatorType = properties.split("=")[0];
			String locatorValue = properties.split("=")[1];
			
			switch (locatorType) {
			case "id":
				webElement = driver.findElement(By.id(locatorValue));
				break;
			case "name":
				webElement = driver.findElement(By.name(locatorValue));
				break;	
			case "xpath":
				webElement = driver.findElement(By.xpath(locatorValue));
				break;
			case "cssSelector":
				webElement = driver.findElement(By.cssSelector(locatorValue));
				break;
		}
		}
		
		//Action
		
		switch (action) {
		case "visit":
			driver.get(data);
			break;
		case "setValue":
			webElement.sendKeys(data);
			break;
		case "click":
			webElement.click();
			break;
		case "doubleClick":
			Actions actions = new Actions(driver);
			actions.doubleClick(webElement).perform();
			break;
		}
	}

}
