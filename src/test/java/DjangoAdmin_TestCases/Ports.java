/**
 * 
 */
package DjangoAdmin_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ptrac.qa.Adminpages.AccountLayersPage;
import com.ptrac.qa.Adminpages.AdminHomePage;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.commonMethods.CommonMethods;

public class Ports extends PTRAC_TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;
	AccountLayersPage accountLayers;

	@Test
	public void AddAccountLayers() throws IOException, InterruptedException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		try {
			if(verifyElementDisplayed("Ports link",adminHomePage.getLnkPorts())) {
				click("Ports link",adminHomePage.getLnkPorts());
			}
		} catch (IOException e) {
			captureFailStatus("Ports not available");
		}

	}
}
