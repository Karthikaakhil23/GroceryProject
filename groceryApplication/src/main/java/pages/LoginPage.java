package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@name='username']")WebElement Username;
	@FindBy(xpath = "//input[@name='password']")WebElement Password;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath = "//button[@data-dismiss='alert']")WebElement alert;
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;//assign local variable to instance variable
		PageFactory.initElements(driver, this);
	}
	public LoginPage enterTheUsername(String username2)
	{
		Username.sendKeys(username2);
		return this;
	}
	public LoginPage enterPassword(String password2)
	{
		Password.sendKeys(password2);
		return this;
	}
	public Homepage clickSignin()
	{
		signin.click();
		return new Homepage(driver);
	}
	public boolean isHomePageDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
		
	}

}
