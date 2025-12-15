package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {
	
	LoginPage loginpage;
	Homepage homepage;
	
	@Test(description = "To verify user is able to logout")
	public void verifyUserIsInHomePage() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		
		loginpage.enterTheUsername(username).enterPassword(password);
		loginpage.clickSignin();
		
	}

}
