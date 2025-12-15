package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	//LoginPage loginpage;
	Homepage homepage;
	
	@Test(groups = {"Regression"},description = "To Verify User is able to enter the ManageNews")
	public void VerifyUserIsAbleToEnterTheManageNews() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String Enternews=ExcelUtilities.getStringData(0, 0, "managenews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		homepage = loginpage.clickSignin();
		
		managenewspage = homepage.clickOnManageNewsMoreInfo();
		managenewspage.clickNew().enterTheNews(Enternews).clickSave();

		boolean alert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTDISPLAYEDFORMANAGENEWS);
	}

}
