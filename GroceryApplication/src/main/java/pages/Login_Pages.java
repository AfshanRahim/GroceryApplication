package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Excel_Utility;
import utility.Excel_Utilities;

public class Login_Pages {
	public WebDriver driver;
	public Login_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")WebElement signinButton;
	@FindBy(xpath="//span[text()='7rmart supermarket']")WebElement homepageText;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertMessage;
	
	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	public void clickonSigninbutton() {
		signinButton.click();
	}
	public boolean isHomepageLoaded(){
		return homepageText.isDisplayed();
	}
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}
	public void loginUsingExcelRead() throws IOException{
		String username = Excel_Utilities.readStringData(1, 0, "LoginPage");
		String password = Excel_Utilities.readStringData(1, 1, "LoginPage");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signinButton.click();
	}
}
