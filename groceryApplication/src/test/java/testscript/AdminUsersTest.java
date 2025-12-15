package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.Homepage;
import pages.LoginPage;

import utilities.ExcelUtilities;
import utilities.FakerUtilities;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserstest;
	Homepage homepage;
	@Test(description = "Used to verify whether the user is able to enter admin user informations")
	public void verifyUserIsAbleToEnterAdminUserInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		//String adminUsername=ExcelUtilities.getStringData(1, 0, "adminuser");
		//String adminPassword=ExcelUtilities.getStringData(1, 1, "adminuser");
		FakerUtilities fakerutilities = new FakerUtilities();
		String adminUsername = fakerutilities.creatARandomFirstName();
		String adminPassword = fakerutilities.creatARandomFirstName();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		homepage = loginpage.clickSignin();

		adminuserstest = homepage.clickOnAdminUserMoreinfo();
		adminuserstest.clickNew().enterTheUserName(adminUsername).enterThePassword(adminPassword).userType().clickSave();
		boolean alert = adminuserstest.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTDISPLAYFORADMINUSER);
		
	}
		
}
