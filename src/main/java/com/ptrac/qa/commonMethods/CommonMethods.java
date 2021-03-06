package com.ptrac.qa.commonMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ptrac.qa.Adminpages.AdminLoginPage;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.webpages.AddShipsPage;
import com.ptrac.qa.webpages.HomePage;
import com.ptrac.qa.webpages.LoginPage;

public class CommonMethods extends PTRAC_TestBase{
	AddShipsPage addShipPage;
	Robot robot;
	HomePage homePage;
	LoginPage loginPage;
	AdminLoginPage adminLoginPage;
	public CommonMethods() {
		super();
	}

	public void AddShip(String s1) throws InterruptedException, IOException, AWTException {
		addShipPage=new AddShipsPage();
		homePage=new HomePage();
		robot=new Robot();
		adminLoginPage=new AdminLoginPage();
		Thread.sleep(1000);
		homePage.clickAddShipLnk();
		Thread.sleep(1000);
		addShipPage.enterShipNameIMO(s1);
		Thread.sleep(3000);
		addShipPage.selectFirstShip();
		addShipPage.clickRegBtn();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void login(String userName, String password) throws IOException, InterruptedException {
		loginPage= new LoginPage();
		enterValue("User Name", loginPage.getTxtUserName(), userName);		
		enterValue("Password", loginPage.getTxtPassword(), password);
		Thread.sleep(5000);
		click("Login button", loginPage.getBtnLogin());
		wait(5);	
		}
	
	public HomePage loginAdmin(String userName, String password) throws IOException, InterruptedException {
		adminLoginPage= new AdminLoginPage();
		enterValue("User Name", adminLoginPage.getUserNameTxt(), userName);		
		enterValue("Password", adminLoginPage.getPasswordTxt(), password);
		Thread.sleep(3000);
		click("Login button", adminLoginPage.getLoginBtn());
		return new HomePage();
	}
}
