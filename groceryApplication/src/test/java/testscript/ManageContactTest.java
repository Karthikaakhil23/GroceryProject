package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	
	ManageContactPage managecontactpage;
	//LoginPage loginpage;
	Homepage homepage;
	
	@Test(description = " To verify user is able to access managecontactpage")
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
		loginpage.enterTheUsername(username).enterPassword(password);
		homepage = loginpage.clickSignin();
		
		managecontactpage = homepage.clickOnManageContactMoreIsnfo();
		managecontactpage.clickOnActionIcon().updatePhone(phone).updateEmail(email).updateaddress(address).updateDeliveryTime(delivery_time).updateDeliveryChargeLimit(delivery_charge_limit).clickOnUpdateButton();
		
		boolean alert = managecontactpage.alertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTDISPLAYEDFORMANAGECONTACT);
		
	}

}
