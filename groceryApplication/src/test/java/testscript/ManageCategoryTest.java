package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	
	//LoginPage loginpage;
	ManageCategoryPage managecategorypage;
	Homepage homepage;
	
	@Test(description ="To verify user is able to enter category informations")
	public void verifyUserIsAbleToAccessCategoryInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterPassword(password);;
		homepage = loginpage.clickSignin();
		
		managecategorypage = homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickOnNewButton().enterCategory().chooseFileButtonClick().clickOnDiscount().clickOnSaveButton();
		
		boolean alert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTDISPLAYEDFORMANAGECATEGORY);
		
	}

}
