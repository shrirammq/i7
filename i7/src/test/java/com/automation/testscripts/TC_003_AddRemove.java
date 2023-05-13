package com.automation.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;
import com.automation.screens.HomePage;
import com.automation.screens.LoginPage;
import com.automation.screens.LogoutPage;

public class TC_003_AddRemove extends FrameworkScript {

	@Test(dataProvider = "getTestdata")
	public void addRemove(String userName,String password) throws Exception {

		// Login

		driver.get("https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName,password);

		// AddRemove
		HomePage homePage = new HomePage(driver);
		homePage.addRemove();

		// Logout

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}
	
	@DataProvider(name = "getTestdata")
	public String[][] getTestdata() throws Exception {
		return ExcelHelper.getTestdata("E:\\Testdata.xlsx", "Sheet1");
	}


}
