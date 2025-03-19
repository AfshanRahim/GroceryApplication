package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Page_Utility;
import org.openqa.selenium.support.ui.Select;


    public class SubcategoryPage {
	public WebDriver driver;
	Page_Utility pageutility =new Page_Utility();
	public SubcategoryPage(WebDriver driver)  
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath="//select[@id='cat_id']")WebElement categoryDropDown;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategoryTextBox;
	@FindBy(xpath="//input[@id='main_img']")WebElement imageChooseFile;
	@FindBy(xpath="//button[text()='Save']")WebElement saveButton;
	
	
	public void clickOnNewButton(){
		
		newButton.click();
	}
	
	public void selectCategoryFromDropdown(){
		
		pageutility.selectDropdownWithValue(categoryDropDown, "veggies");
//	Select select=new Select(categoryDropDown);
//	select.selectByVisibleText("veggies");
//	WebElement selectedElement=select.getFirstSelectedOption();
//	selectedElement.click();
     }
	
     public void enterSubCategory(){ 
    	 
	subcategoryTextBox.sendKeys("Leafy vegetables"+ pageutility.generateCurrentDateAndTime());
     }
     
	public void clickOnSaveButton() {
		//saveButton.click();
	}
}
