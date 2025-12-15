package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base {
	
	ManageFooterTextPage managerfootertextPage ;
	Homepage homepage;
	
	@Test(description = " To verify user is able to access FooterTextInformations")
	public void verifyUserIsAbleToAccessFooterTextInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String address = ExcelUtilities.getStringData(1, 0, "managefootertext");
		String email = ExcelUtilities.getStringData(1, 1, "managefootertext");
		String phone = ExcelUtilities.getIntegerData(1, 2, "managefootertext");
	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);
		homepage = loginpage.clickSignin();
		
		managerfootertextPage = homepage.clickOnManageFooterTextMoreInfo();
		managerfootertextPage.clickOnAction().enterAddress(address).enterEmail(email).enterPhone(phone).clickOnUpdateButton();

		boolean alert = managerfootertextPage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTDISPLAYEDFORMANAGEFOOTERTEXT);
	}

}
