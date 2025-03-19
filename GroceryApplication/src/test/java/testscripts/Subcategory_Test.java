package testscripts;

import java.io.IOException;
import org.testng.annotations.Test;
import automationcore.Base_Test;
import pages.HomePage;
import pages.Login_Pages;
import pages.SubcategoryPage;

public class Subcategory_Test extends Base_Test{
	  @Test
	  public void verifyAddNewSubcategoryWithValidDetails() throws IOException 
	  {
		  Login_Pages login=new Login_Pages(driver);
		  login.loginUsingExcelRead();//now at home page
		  HomePage home=new HomePage(driver);
		  home.clickonSubCategoryButton();//now at subcategory page
		  
		  
		  SubcategoryPage subcategory=new SubcategoryPage(driver);
		  subcategory.clickOnNewButton();
		  subcategory.selectCategoryFromDropdown();
		  subcategory.enterSubCategory();
		  subcategory.clickOnSaveButton();
		  
	  }
}
