package AcademyTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import HelperClass.WaitHelper;
import PageObjects.HomePage;
import Resource.base;
import junit.framework.Assert;

public class Home extends base {

	// public static Logger log=LoggerHelper.getLogger(Home.class);
	public static Logger log = LogManager.getLogger(Home.class);
	public static WebDriver driver;

	ExtentTest test = returnTestObject();

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Browser Initialized succesfully");

	}

	@BeforeMethod
	public void executeBeforeEveryTest() throws IOException {
		driver.get(getGlobalProp("url"));
		log.info("Website succesfully launched ");
	}

	// <Reporting Line wise with Log details and screenshots with the Help of
	// Extent Report
	@Test

	public void basePageNavigation() throws IOException {

		// Validate that Landing Page displays "Featured Courses"
		HomePage hobj = new HomePage(driver);
		WaitHelper helper = new WaitHelper(driver);
		helper.waitForVisibilityElement(driver, hobj.clickCloseButton(), 20);
		hobj.clickCloseButton().click();

		log.info("User succesfully landed to Home Page ");
		String extractedTitle = hobj.getTitle().getText();
		System.out.println(extractedTitle);
		Assert.assertEquals("FEATURED COURSES", extractedTitle);
		log.info("Extracted Courses Name matched with the Expected  ");
	}

	@AfterMethod
	public void executeAfterEveryTest() {
		driver.close();
		log.info("Focused Browser Closed Succesfully..  ");
	}

	@AfterTest
	public void tearDown() {

		driver = null;
	}
}
