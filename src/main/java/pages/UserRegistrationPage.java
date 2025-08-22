package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="gender-male")
	WebElement maleRadioBtn;
	
	@FindBy(id="gender-female")
	WebElement femaleRadioBtn;
	
	@FindBy(id="FirstName")
	WebElement fnameTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnameTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successfullRegisterMessage;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;
	
	@FindBy(css = "a.button-1.register-continue-button")
	WebElement continueToHomePageBtn;
	
	public void userRegistration(char gender,String fname,String lname,String email,String password)
	{
		if(gender =='m' || gender =='M')
		{
			clickButton(maleRadioBtn);
		}
		else
		{
			clickButton(femaleRadioBtn);
		}
		
		sendTxtElmentText(fnameTxtBox, fname);
		
		sendTxtElmentText(lnameTxtBox, lname);
		
		sendTxtElmentText(emailTxtBox, email);
		
		sendTxtElmentText(passwordTxtBox, password);
		
		sendTxtElmentText(confirmpasswordTxtBox, password);
		
		clickButton(registerBtn);
	}
	
	public void logout()
	{
		clickButton(logoutLink);
	}
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
	public void continueToHomePage()
	{
		clickButton(continueToHomePageBtn);
	}

}
