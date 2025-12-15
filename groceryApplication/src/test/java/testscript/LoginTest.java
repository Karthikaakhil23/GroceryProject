package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	
	LoginPage loginpage;
	Homepage homepage;
	
	@Test(groups = {"Regression"},retryAnalyzer= retry.Retry.class,description="To verify whether user is able to login using valid credentials")
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		homepage = loginpage.clickSignin();
		
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINUSINGCORRECTUSERNAMEANDCORRECTPASSWORD);
	}
	
	@Test(description = "Used to verify the user with incorrect username and correct password")
	public void verifyUserIsAbleToLoginUsingIncorrectUsernameAndcorrectPassword() throws IOException
	{
		String username = ExcelUtilities.getStringData(2, 0, "loginpage");
		String password = ExcelUtilities.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		loginpage.clickSignin();
		
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.LOGINIUSINGINCORRECTUSERNAMEANDPASSWORD);
	}
	
	@Test(description = "Used to verify the user with correct username and incorrect password")
	public void verifyUserIsAbleToLoginUsingCorrectUsernameAndIncorrectPassword() throws IOException
	{
		String username = ExcelUtilities.getStringData(3, 0, "loginpage");
		String password = ExcelUtilities.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		loginpage.clickSignin();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.LOGINUSINGCORRECTUSERNAMEANDINCORRECTPASSWORD);		
	}
	
	@Test(description = "Used to verify the user with invalid credentials",dataProvider ="LoginProvider")
	public void verifyUserIsAbleToLoginUsingIncorrectUsernameAndIncorrectPassword(String username,String password) throws IOException
	{
		//String username = ExcelUtilities.getStringData(4, 0, "loginpage");
		//String password = ExcelUtilities.getStringData(4, 1, "loginpage") ;
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		loginpage.clickSignin();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.LOGINUSINGINCORRECTUSERNAMEANDPASSWORD);
	}
	

	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtilities.getStringData(4, 0,"loginpage"),ExcelUtilities.getStringData(4,1,"loginpage")}};
		
	
	
	}
	
}
