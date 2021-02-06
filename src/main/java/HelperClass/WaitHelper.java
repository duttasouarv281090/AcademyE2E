package HelperClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private static WebDriver driver=null;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void setImplicitWait(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public WebDriverWait setFluentWait(int timeOutinSeconds, int pollingInEveryMilliSecs)

	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutinSeconds);
		wait.pollingEvery(pollingInEveryMilliSecs, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public void setPageLoadTimeOut(long timeout) {
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}

	public void waitForElementClickable(WebDriver driver, long time, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForVisibilityElement(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForFrametoSwitch(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}

	public void waitForStaleness(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.stalenessOf(element));

	}
	
	public static WebElement isElementPresent(String locator,int time)
	{
		
		WebElement element=null;
		for(int i=0;i<time;i++)
		{
			try
			{
				element=driver.findElement(By.xpath(locator));
				break;
				
			}
			catch(Exception e)
			{
				try
				{
				Thread.sleep(1000);
				} catch (InterruptedException e1)
				{
				System.out.println("Waiting for element to appear on DOM");
				}
				}
				}
		return element;
		}
	
	public boolean checkElementPresent(WebElement element,int time)
	{
		List<WebElement> ele=null;
		
		for(int i=0;i<time;i++)
		{
			ele=(List<WebElement>) driver.findElements((By) element);
			int count=ele.size();
			if(count>0)
			{
				return true;
				
			}
				
			break;	
		}
		return false;
		
	}
}

