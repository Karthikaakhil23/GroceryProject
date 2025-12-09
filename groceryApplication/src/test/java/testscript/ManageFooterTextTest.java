package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base {
	@Test
	public void verifyUserIsAbleToAccessFooterTextInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String address = ExcelUtilities.getStringData(1, 0, "managefootertext");
		String email = ExcelUtilities.getStringData(1, 1, "managefootertext");
		String phone = ExcelUtilities.getIntegerData(1, 2, "managefootertext");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		ManageFooterTextPage managerfootertextPage = new ManageFooterTextPage(driver);
		managerfootertextPage.clickOnmoreInfo();
		managerfootertextPage.clickOnAction();
		managerfootertextPage.enterAddress(address);
		managerfootertextPage.enterEmail(email);
		managerfootertextPage.enterPhone(phone);
		managerfootertextPage.clickOnUpdateButton();
		boolean alert = managerfootertextPage.isAlertDisplayed();
	}

}
