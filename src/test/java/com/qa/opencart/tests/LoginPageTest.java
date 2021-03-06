package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.AnnotationTransformer;
import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Desgin Open cart App - Login Page")
@Story("US 101:Open cart Login Design with multiple features")
@Listeners(AnnotationTransformer.class)
public class LoginPageTest extends BaseTest {

	// execution will start from this test class

	// never use the driver apis in the test class.
	// Assertions are written in the test class

	@Description("Login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("login page TITLE is: " + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE, "login page title is not matched");
	}

	@Description("Login Page URL Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		System.out.println("login page URL is: " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

	@Description("forgot password link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("register link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=4, enabled = false)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	
	@Description("login Test with correct credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=5)
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim() , prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}

}
