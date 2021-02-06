package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentTest;

import HelperClass.ResourceHelper;

public class base {
   
	public static WebDriver driver;
	public static ExtentTest returntest;
	public static WebDriver initializeDriver() throws IOException {
	 
		String absolutePath = System.getProperty("user.dir");
		String browserName = getGlobalProp("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", absolutePath + "\\Drivers\\chromedriver_latest.exe");
			driver = new ChromeDriver();
		} 
		
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", absolutePath + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE"))

		{
//			System.setProperty("webdriver.ie.driver", absolutePath + "\\Drivers\\IEDriver.exe");
//			driver = new InternetExplorerDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static String getGlobalProp(String key) throws IOException {
		String absolutePath = System.getProperty("user.dir");
		String relativePath = "\\src\\main\\java\\Utilities\\data.properties";
		FileInputStream fs = new FileInputStream(absolutePath + relativePath);
		Properties prop = new Properties();
		prop.load(fs);
		return prop.getProperty(key);
	}
	
	public void getScreenshotOnFailure(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(ResourceHelper.getResourcePath("//Screenshot//Failure_")+fileName+"screenshot.png"));
	}
	
	public void getScreenshotOnPass(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(ResourceHelper.getResourcePath("//Screenshot//Pass_")+fileName+"screenshot.png"));
	}
	public String getPassScreenshotPath(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationpath=ResourceHelper.getResourcePath("//Screenshot//Pass_")+fileName+"screenshot.png";
		FileUtils.copyFile(src, new File(destinationpath));
		return destinationpath;
		
		
	}
	public String getFailScreenshotPath(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationpath=ResourceHelper.getResourcePath("//Screenshot//Failure_")+fileName+"screenshot.png";
		FileUtils.copyFile(src, new File(destinationpath));
		return destinationpath;
		
		
	}
	public void extentTestObject(ExtentTest test)
	{
		
		returntest= test;
		
		
	}
	
	public ExtentTest returnTestObject()
	{
		return returntest;
	}
}