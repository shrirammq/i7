package com.automation.testscripts;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;

public class DriverScript extends FrameworkScript {
	
	
	@DataProvider(name = "getTestData")
	public String[][] getTestData()  throws Exception{
		return ExcelHelper.getTestData("E:\\Keyworddriven.xlsx", "Sheet1");
		
	}
	
	@Test(dataProvider = "getTestData")
	public void execute(String tcName,String description,String action,String properties,String data) {

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
			case "className":
				webElement = driver.findElement(By.className(locatorValue));
				break;
			case "tagName":
				webElement = driver.findElement(By.tagName(locatorValue));
				break;
			case "xpath":
				webElement = driver.findElement(By.xpath(locatorValue));
				break;
			case "cssSelector":
				webElement = driver.findElement(By.cssSelector(locatorValue));
				break;
			case "linkText":
				webElement = driver.findElement(By.linkText(locatorValue));
				break;
			case "partialLinkText":
				webElement = driver.findElement(By.partialLinkText(locatorValue));
				break;
			}
		}
		
		//Action
		Actions actions = null;
		Select select= null;
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
			actions = new Actions(driver);
			actions.doubleClick(webElement).perform();
			break;
		case "contextClick":
			actions = new Actions(driver);
			actions.contextClick(webElement).perform();
			break;
		case "selectByText":
			select = new Select(webElement);
			select.selectByVisibleText(data);
			break;
		}
		
	}

}
