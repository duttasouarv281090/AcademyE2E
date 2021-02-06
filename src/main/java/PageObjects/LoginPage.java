package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[contains(text(),'NO THANKS')]") WebElement closebtn;
	@FindBy(id="homepage")WebElement hmePage;
	@FindBy(xpath="//span[contains(text(),'Login')]")WebElement login;
	@FindBy(xpath="//h1[@class='text-center']")WebElement loginpge;
	@FindBy(id="user_email")WebElement emailid;
	@FindBy(id="user_password")WebElement password;
	@FindBy(name="commit")WebElement loginBtn;
	
	
	public WebElement clickCloseButton()
	{
		return closebtn;
	}
	public WebElement homePage()
	{
		return hmePage;
	}
	
	public WebElement clickloginLink()
	{
		return login;
	}
	
	public WebElement loginPage()
	{
		return loginpge;
	}
	
	public WebElement fillEmailID()
	{
		return emailid;
	}
	public WebElement fillPassword()
	{
		return password;
	}
	public WebElement clickloginButton()
	{
		return loginBtn;
	}
}