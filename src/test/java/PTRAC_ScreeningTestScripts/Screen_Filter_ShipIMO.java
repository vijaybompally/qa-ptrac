package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.commonMethods.CommonMethods;
import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.webpages.AddShipsPage;
import com.ptrac.qa.webpages.HomePage;
import com.ptrac.qa.webpages.LoginPage;
import com.ptrac.qa.webpages.ScreenPage;
import com.ptrac.qa.webpages.SearchPage;

public class Screen_Filter_ShipIMO extends PTRAC_TestBase {
	CommonMethods cm;
	Robot robot;
	HomePage homePage;
	AddShipsPage addShipsPage;
	ScreenPage screenPage;

	Screen_Filter_ShipIMO(){
		super();
	}

	@Test()
	public void FilterShips() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		cm=new CommonMethods();
		homePage=new HomePage();
		addShipsPage=new AddShipsPage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "FilterShips");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		String shipIMO=(String) data[0][1];
		screenPage=new ScreenPage();
		screenPage.searchShips(shipIMO);
		screenPage.selectLatestShip();
		wait(5);
		String latShipIMO=screenPage.getLatestShipIMONumber();

		if(latShipIMO.contains(shipIMO))
		{
			capturePassStatus("Searched Ship IMO is displayed");
		}
		else
		{
			captureFailStatus("Searched Ship is IMO is not available");
		}

	}
}
