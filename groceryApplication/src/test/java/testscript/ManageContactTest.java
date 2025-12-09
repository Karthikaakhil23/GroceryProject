package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test
	public void verifyUserIsAbleToAccessManageContactPage() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String phone = ExcelUtilities.getIntegerData(1, 0, "managecontact");
		String email = ExcelUtilities.getStringData(1, 1, "managecontact");
		String address = ExcelUtilities.getStringData(1, 2, "managecontact");
		String delivery_time = ExcelUtilities.getIntegerData(1, 3, "managecontact");
		String delivery_charge_limit = ExcelUtilities.getIntegerData(1, 4, "managecontact");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickOnMoreInfo();
		managecontactpage.clickOnActionIcon();
		managecontactpage.updatePhone(phone);
		managecontactpage.updateEmail(email);
		managecontactpage.updateaddress(address);
		managecontactpage.updateDeliveryTime(delivery_time);
		managecontactpage.updateDeliveryChargeLimit(delivery_charge_limit);
		managecontactpage.clickOnUpdateButton();
		boolean alert = managecontactpage.alertDisplayed();
		Assert.assertTrue(alert);
		
	}

}
