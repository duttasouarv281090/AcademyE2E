package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'My Courses')]")WebElement myCourseLink;
	@FindBy(xpath="//a[contains(text(),'Home')]")WebElement homeLink;
	@FindBy(xpath="//div[@class='logo']//a//img")WebElement homePgeLogo;
	@FindBy(xpath="//h2[text()='Featured Courses']")WebElement pageTitle;
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]") WebElement closebtn;
	
	public WebElement getTitle()
	{
		return pageTitle;
	}
	public WebElement clickCloseButton()
	{
		return closebtn;
	}
}
