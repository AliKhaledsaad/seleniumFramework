package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends PageBase
{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="ShipToSameAddress")
	WebElement shiptToSameAddressBtn;

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstNameTxtBox;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTxtBox;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxtBox;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryDropDownList;

	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement stateDropDownList;

	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxtBox;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1TxtBox;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxtBox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxtBox;

	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continueBilingBtn;

	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continueShippingMethodBtn;

	@FindBy(id="shippingoption_0")
	WebElement shipingGroundBtn;

	@FindBy(id="shippingoption_1")
	WebElement shipingNextDayBtn;

	@FindBy(id="shippingoption_2")
	WebElement shiping2ndNextDayBtn;

	@FindBy(id="paymentmethod_0")
	WebElement checkMoneyOrderBtn;

	@FindBy(id="paymentmethod_1")
	WebElement creditCardBtn;

	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement continueSelectPaymentBtn;

	@FindBy(id="CreditCardType")
	WebElement creditCardTypeDropDownList;

	@FindBy(id="CardholderName")
	WebElement cardholderNameTxtBox;

	@FindBy(id="CardNumber")
	WebElement cardNumberTxtBox;

	@FindBy(id="ExpireMonth")
	WebElement expireMonthDropDownList;

	@FindBy(id="ExpireYear")
	WebElement expireYearDropDownList;

	@FindBy(id="CardCode")
	WebElement cardCodeTxtBox;

	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement continuePaymentBtn;

	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmeBtn;

	@FindBy(css="div.title")
	public WebElement checkoutProcesssedNotification;

	@FindBy(linkText ="Click here for order details.")
	WebElement orderDetailsLink;

	public void checkoutCart(String fName,String lName,String email,String country,String state,String city,String address1,String zipCode,String phoneNumber,int shipingOption,int paymentOption,String creditCardType , String cardholderName,String cardNumber,String expireMonthDate,String expireYearDate,String CardCode)
	{
		
		clearTxtElement(firstNameTxtBox);
		sendTxtElmentText(firstNameTxtBox,fName );
		clearTxtElement(lastNameTxtBox);
		sendTxtElmentText(lastNameTxtBox,lName );
		clearTxtElement(emailTxtBox);
		sendTxtElmentText(emailTxtBox,email );
		select = new Select(countryDropDownList);
		select.selectByVisibleText(country);
		select = new Select(stateDropDownList);
		select.selectByVisibleText(state);
		clearTxtElement(cityTxtBox);
		sendTxtElmentText(cityTxtBox,city );
		clearTxtElement(address1TxtBox);
		sendTxtElmentText(address1TxtBox,address1 );
		clearTxtElement(zipCodeTxtBox);
		sendTxtElmentText(zipCodeTxtBox,zipCode );
		clearTxtElement(phoneNumberTxtBox);
		sendTxtElmentText(phoneNumberTxtBox,phoneNumber);
		wait.until(ExpectedConditions.elementToBeClickable(continueBilingBtn));
		
		clickButton(continueBilingBtn);

		switch (shipingOption) {
		case 1: {

			clickButton(shipingGroundBtn);
		}
		case 2: {

			clickButton(shipingNextDayBtn);
		}
		case 3: {

			clickButton(shiping2ndNextDayBtn);
		}
		default:
		{

			clickButton(shipingGroundBtn);
		}
		}

		clickButton(continueShippingMethodBtn);

		switch (paymentOption) {
		case 1: {

			clickButton(checkMoneyOrderBtn);

		}
		case 2: {

			clickButton(creditCardBtn);
		}
		default:
		{

			clickButton(checkMoneyOrderBtn);
		}
		}
		clickButton(continueSelectPaymentBtn);
		if(creditCardBtn.isSelected())
		{
			select = new Select(creditCardTypeDropDownList);
			select.selectByVisibleText(creditCardType);
			sendTxtElmentText(cardholderNameTxtBox, cardholderName);
			sendTxtElmentText(cardNumberTxtBox, cardNumber);
			select = new Select(expireMonthDropDownList);
			select.selectByVisibleText(expireMonthDate);

			select = new Select(expireYearDropDownList);
			select.selectByVisibleText(expireYearDate);
			sendTxtElmentText(cardCodeTxtBox, CardCode);
			clickButton(continuePaymentBtn);
		}
		else if(checkMoneyOrderBtn.isSelected())
		{
			clickButton(continuePaymentBtn);
		}
		clickButton(confirmeBtn);




	}
	public void openOrderDetailsPage()
	{
		clickButton(orderDetailsLink);
	}
}
