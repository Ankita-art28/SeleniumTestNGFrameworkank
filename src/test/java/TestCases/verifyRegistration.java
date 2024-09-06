package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.BaseClass;
import Resources.commonMethods;
import Resources.storeData;
import pageObjectModel.homePageObjects;
import pageObjectModel.registrationPageObjects;

public class verifyRegistration extends BaseClass {

	@Test(priority=1)
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException
	{
		//browserLaunch();
		//driver.get("https://naveenautomationlabs.com/opencart/");
		
		homePageObjects hp=new homePageObjects(driver);
		commonMethods.handleExplicitWait(10, hp.clickOnmyAccount(), driver);
		
		hp.clickOnmyAccount().click();
		hp.clicOnRegister().click();
		
		registrationPageObjects rpo=new registrationPageObjects(driver);
		
		
		//modification on storeData class 
		rpo.enterFirstName().sendKeys(storeData.firstName);
		rpo.enterLastName().sendKeys(storeData.lastName);
		//unique email para
		rpo.enterEmail().sendKeys(emailAddress);
		rpo.enterTelephone().sendKeys(storeData.telephone);
		rpo.enterPassword().sendKeys(storeData.password);
		rpo.PasswordConfirm().sendKeys(storeData.confirmPassword);
		rpo.PrivacyPolicy().click();
		rpo.Continue().click();
		
		// To recognise error
		//Cannot invoke "org.openqa.selenium.WebDriver.findElement(org.openqa.selenium.By)" because "this.driver" is null
		//at pageObjectModel.homePageObjects.clickOnmyAccount(homePageObjects.java:19)
		
		
		String actual=rpo.getRegistrationConfirmText().getText();
		//String expected="Your Account Has Been Created!";
		String expected=storeData.regExpectedText;
		commonMethods.handleAssertion(actual,expected);
		
		
		//Validation for checking Registration is Succesful or not
		//SoftAssert sa=new SoftAssert();
		//sa.assertEquals(actual, expected);
		//sa.assertAll();
		
	}
	//Invalid DATA Test case
	@Test(priority=2)
	public void verifyRegisterationWithInBlankdData() throws IOException, InterruptedException
	
	{
		//browserLaunch();
		//driver.get("https://naveenautomationlabs.com/opencart/");
		
		homePageObjects hp=new homePageObjects(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(hp.clickOnmyAccount()));
		
		//modifications on assert
		commonMethods.handleExplicitWait(10, hp.clickOnmyAccount(), driver);
		
		hp.clickOnmyAccount().click();
		hp.clicOnRegister().click();
		
		registrationPageObjects rpo=new registrationPageObjects(driver);
		rpo.Continue().click();
		
		SoftAssert sa=new SoftAssert();
		String firstNameActual=rpo.getfirstnameErrorText().getText();
		String firstNameExpected=storeData.firstNameErrorExpectedresult;
		commonMethods.handleAssertion(firstNameActual, firstNameExpected);
		//sa.assertEquals(firstNameActual, firstNameExpected);
		
		
		String lastNameActual=rpo.getlastnameErrorText().getText();
		String lastNameExpected=storeData.lastNameErrorExpectedresult;
		
		commonMethods.handleAssertion(lastNameActual, lastNameExpected);
		//sa.assertEquals(lastNameActual, lastNameExpected);
		
		String emailActual=rpo.getemailErrorText().getText();
		String emailExpected=storeData.emailErrorExpectedresult;
		commonMethods.handleAssertion(emailActual, emailExpected);
		//sa.assertEquals(emailActual, emailExpected);
		
		String telephoneActual=rpo.gettelephoneErrorText().getText();
		String telephoneExpected=storeData.telephoneErrorExpectedresult;
		commonMethods.handleAssertion(telephoneActual, telephoneExpected);
		//sa.assertEquals(telephoneActual, telephoneExpected);
		
		String PasswordActual=rpo.getpasswordErrorText().getText();
		String PasswordExpected=storeData.passwordErrorExpectedresult;
		
		sa.assertEquals(PasswordActual, PasswordExpected);
		
		sa.assertAll();
		
	}
	
	
	
	
	
}
