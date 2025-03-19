package testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base_Test;
import constants.Constant;
import pages.Login_Page;
import pages.Login_Pages;

public class Login_Test extends Base_Test{
@Test
	public void verifyLoginWithVallidCredentials() throws IOException {
		Login_Pages login = new Login_Pages(driver);
		login.loginUsingExcelRead();
//	String username = "admin";
//	  String password = "admin";
//	  login.enterUsernameOnUsernameField(username);
//	  login.enterPasswordOnPasswordField(password);
//	  login.clickonSigninbutton();
		 boolean isHomepageLoaded = login.isHomepageLoaded();
		 Assert.assertTrue(isHomepageLoaded,Constant.lp_verifywithValidData);
	}
@Test
public void verifyUserLoginwithValidusernameInvalidPassword() {
	  Login_Pages login = new Login_Pages(driver);
	  String username = "admin";
	  String password = "1q2qw3e4dr";
	  login.enterUsernameOnUsernameField(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickonSigninbutton();
	  boolean isAlertPresent = login.isAlertMessageDisplayed();
	  Assert.assertTrue(true,Constant.lp_verifyUserLoginwithValidusernameInvalidPassword);
}

@Test
public void verifyUserLoginwithInvalidUsernameValidPassword() {
	  Login_Pages login = new Login_Pages(driver);
	  String username = "carolin";
	  String password = "1q2w3e4r";
	  login.enterUsernameOnUsernameField(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickonSigninbutton();
	  Boolean isAlertPresent = login.isAlertMessageDisplayed();
	  Assert.assertTrue(true,Constant.lp_verifyUserLoginwithInvalidUsernameValidPassword);
}

@Test(dataProvider = "dataProvider1")
public void verifyUserLoginwithInvalidCredentials(String username, String password) {
	  Login_Pages login = new Login_Pages(driver);
	  login.enterUsernameOnUsernameField(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickonSigninbutton();
	  Boolean isAlertPresent = login.isAlertMessageDisplayed();
	  Assert.assertTrue(true,Constant.lp_verifyUserLoginwithInvalidCredentials);
}

@DataProvider(name = "dataProvider1")
public Object[][]dpMethod(){
		return new Object[][]  {{"Afshan", "i12geu89"},{"Parrot","af19828h"},{"Sarah","98ojkjhd"}};
     }

}
