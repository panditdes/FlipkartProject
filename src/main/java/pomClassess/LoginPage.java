package pomClassess;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClassess.UtilityClass;

public class LoginPage extends UtilityClass{
	
	
	WebDriver driver;             //declaring as global so we can use in whole class and not initiate 
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID;                   
	//giving xpath by using @FindBy so we will use only emailID and perform action on it.it will reduce rework/retype
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement Password;
	//first time the element will attach to Dom known as early inntialise
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submitButton;
	//it will read easily and not lookin in complex manner
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void EnterEmailID() throws IOException
	{
		//emailID.sendKeys("deshpandepandit143@gmail.com");
		
		emailID.sendKeys(getConfigData("email"));
	}
	
	public void EnterPassword() throws IOException
	{
		//Password.sendKeys("Ponds@123");
		
		Password.sendKeys(getConfigData("password"));
	}
	
	public void ClickOnSubmitButton()
	{
		submitButton.click();
	}

}
