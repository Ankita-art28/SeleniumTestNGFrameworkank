package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registrationPageObjects {

	public WebDriver driver;
	
	private By FirstName =By.xpath("//input[@id='input-firstname']");
	
	private By LastName =By.xpath("//input[@id='input-lastname']");
	
	private By Email =By.xpath("//input[@id='input-email']");
	
	private By Telephone =By.xpath("//input[@id='input-telephone']");
	
	private By Password =By.xpath("//input[@id='input-password']");
	
	private By PasswordConfirm =By.xpath("//input[@id='input-confirm']");

private By PrivacyPolicy =By.xpath("//input[@name='agree']");
	
	private By Continue =By.xpath("//input[@value='Continue']");
	
	private By registrationConfirmationText =By.xpath("//h1[text()='Your Account Has Been Created!']");
	
	//Invalid data locator
	
	private By firstnameErrorText =By.xpath("(//div[@class='text-danger'])[1]");
	
	private By lastnameErrorText =By.xpath("(//div[@class='text-danger'])[2]");
	
	private By emailErrorText =By.xpath("(//div[@class='text-danger'])[3]");
	
	private By telephoneErrorText =By.xpath("(//div[@class='text-danger'])[4]");
	
	private By passwordErrorText =By.xpath("(//div[@class='text-danger'])[5]");
	
	
	
	public registrationPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement enterFirstName()
	{
		return driver.findElement(FirstName);
	}
	
	public WebElement enterLastName()
	{
		return driver.findElement(LastName);
	}
	
	public WebElement enterEmail()
	{
		return driver.findElement(Email);
	}
	
	public WebElement enterTelephone()
	{
		return driver.findElement(Telephone);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(Password);
	}
	
	public WebElement PasswordConfirm()
	{
		return driver.findElement(PasswordConfirm);
	}
	
	
	public WebElement PrivacyPolicy()
	{
		return driver.findElement(PrivacyPolicy);
	}
	
	public WebElement Continue()
	{
		return driver.findElement(Continue);
	}
	
	public WebElement getRegistrationConfirmText()
	{
		return driver.findElement(registrationConfirmationText);
	}
	
	public WebElement getfirstnameErrorText() {
		return driver.findElement(firstnameErrorText);
	}
	
	public WebElement getlastnameErrorText()
	{
		return driver.findElement(lastnameErrorText);
	}
	
	public WebElement getemailErrorText()
	{
		return driver.findElement(emailErrorText);
	}
	
	
	public WebElement gettelephoneErrorText()
	{
		return driver.findElement(telephoneErrorText);
	}
	
	public WebElement getpasswordErrorText()
	{
		return driver.findElement(passwordErrorText);
	}
	
	
	
}
