package com.automation.testscripts;

import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.screens.HomePage;
import com.automation.screens.LoginPage;
import com.automation.screens.LogoutPage;

public class TC_002_AddRemove extends FrameworkScript {

	@Test
	public void addRemove() throws Exception {

		// Login

		driver.get("https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user","secret_sauce");

		// AddRemove
		HomePage homePage = new HomePage(driver);
		homePage.addRemove();

		// Logout

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}

}
