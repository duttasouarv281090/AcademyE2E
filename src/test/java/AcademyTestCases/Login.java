package AcademyTestCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HelperClass.LoggerHelper;
import HelperClass.WaitHelper;
import PageObjects.LoginPage;
import Resource.ExcelUtilities;
import Resource.base;
import Resource.dataProvider;

public class Login extends base{
	
	public static Logger log=LoggerHelper.getLogger(Login.class);
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException
	{

		driver=initializeDriver();
		
	}
	
	@BeforeMethod
	public void executeBeforeEveryTest() throws IOException
	{
		driver.get(getGlobalProp("url"));
		log.info("Website succesfully launched ");
	}

//(dataProvider="multipleLogin-data",dataProviderClass=dataProvider.class)
@Test
public void accountLogin() throws IOException, InterruptedException
{
	
	LoginPage lp=new LoginPage(driver);
	WaitHelper helper=new WaitHelper(driver);
	helper.waitForVisibilityElement(driver, lp.clickCloseButton(), 20);
	lp.clickCloseButton().click();
	lp.clickloginLink().click();
	if(ExcelUtilities.getData("Login", "Email") != null)
	{
		lp.fillEmailID().sendKeys(ExcelUtilities.getData("Login", "Email"));
	}
	
}
@AfterMethod
public void executeAfterEveryTest()
{
	driver.close();
	log.info("Focused Browser Closed Succesfully..  ");
}
@AfterTest
public void tearDown()
{
	driver=null;
}

}
