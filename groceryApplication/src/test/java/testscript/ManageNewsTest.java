package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test(groups = {"Regression"})
	public void VerifyUserIsAbleToEnterTheManageNews() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String Enternews=ExcelUtilities.getStringData(0, 0, "managenews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.clickNew();
		managenewspage.enterTheNews(Enternews);
		managenewspage.clickSave();
		boolean alert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
