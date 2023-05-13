package com.automation.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;
import com.automation.helper.ProjectHelper;

public class DriverScript extends FrameworkScript {

	@Test(dataProvider = "getTestdata")
	public void execute(String tcName, String description, String action, String properties, String data) {

		// Find WebElement
		WebElement webElement = ProjectHelper.findElement(driver, properties);

		// Action
		ProjectHelper.executeAction(driver, webElement, action, data);
	}

	@DataProvider(name = "getTestdata")
	public String[][] getTestdata() throws Exception {
		return ExcelHelper.getTestdata("E:\\Keyworddrivenframework.xlsx", "Sheet1");
	}

}
