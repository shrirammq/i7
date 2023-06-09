package com.automation.helper;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProjectHelper {
	
	public static WebElement findElement(WebDriver driver, String properties) {
		
		WebElement webElement = null;
		
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
			case "tagName":
				webElement = driver.findElement(By.tagName(locatorValue));
				break;
			}
		}
		return webElement;
		
	}
	
	
	public static void executeAction(WebDriver driver, WebElement webElement, String action,String data) {
		
		Actions actions = null;
		Select select = null;
		switch (action) {
		case "visit":
			driver.get(data);
			break;
		case "setText":
			webElement.sendKeys(data);
			break;
		case "click":
			webElement.click();
			break;
		case "doubleClick":
			actions = new Actions(driver);
			actions.doubleClick(webElement).perform();
			break;
		case "righClick":
			actions = new Actions(driver);
			actions.contextClick(webElement).perform();
			break;	
		case "selectByIndex":
			select = new Select(webElement);
			select.selectByIndex(Integer.parseInt(data));
			break;		
		case "selectByText":
			select = new Select(webElement);
			select.selectByVisibleText(data);
			break;
		case "selectByValue":
			select = new Select(webElement);
			select.selectByValue(data);
			break;
		case "back":
			driver.navigate().back();
			break;
		case "forward":
			driver.navigate().forward();
			break;	
		}
	
	}


}
