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
import pageObjectModel.loginPageObject;
import pageObjectModel.registrationPageObjects;

public class verifyLogin extends BaseClass {

	@Test(priority=1)
	public void verifyLoginWithValidData() throws IOException, InterruptedException
	{
		//Modification on base class
		//browserLaunch();
		//driver.get("https://naveenautomationlabs.com/opencart/");
		
		homePageObjects hp=new homePageObjects(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(hp.clickOnmyAccount()));
		
		//modifications on assert
				commonMethods.handleExplicitWait(10, hp.clickOnmyAccount(), driver);
				
		hp.clickOnmyAccount().click();
	    hp.clicOnLogin().click();
	    
		loginPageObject lp=new loginPageObject(driver);
		
		//Assigning value of Uniquemail
		lp.enterEmail().sendKeys(emailAddress);
		lp.enterPassword().sendKeys(storeData.password);
		lp.clickOnSubmit().click();
		
		
		
		//SoftAssert sa=new SoftAssert();
	String actual=driver.getCurrentUrl();
	String expected=storeData.LoginExpectedURL;
	
	//Soft Assertion replacement
	
commonMethods.handleAssertion(actual,expected);

//Logout Steps

hp.clickOnmyAccount().click();

lp.clickOnLogout().click();

String actualWarningText=lp.getlogoutConfirmationText().getText();
String expectedWarningText=storeData.LogoutExpectedConfirmationtext;

commonMethods.handleAssertion(actualWarningText,expectedWarningText);

		//Validation for checking Login is Succesful or not
	//SoftAssert sA=new SoftAssert();
		//sA.assertEquals(actual, expected);
		//sA.assertAll();
	}	
//Note Always run Login with Valid data test case in Testng.xml othetrwise it will get fail
	
	
	//Login with Invalid Data Test Case
	
	@Test(priority=2)
	public void verifyLoginWithInValidData() throws InterruptedException, IOException
	{
		//browserLaunch();
		//driver.get("https://naveenautomationlabs.com/opencart/");
		
		homePageObjects hp=new homePageObjects(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(hp.clickOnmyAccount()));
		
		//modifications on waits
		commonMethods.handleExplicitWait(10, hp.clickOnmyAccount(), driver);
		
		hp.clickOnmyAccount().click();
	    hp.clicOnLogin().click();
	    
		loginPageObject lp=new loginPageObject(driver);
		//Assigning value of Uniquemail
		
		lp.enterEmail().sendKeys(emailAddress);//emailAddress
		lp.enterPassword().sendKeys(storeData.incorrectPassword);//kalndsjkfn
		lp.clickOnSubmit().click();
		
		
		//SoftAssert sa=new SoftAssert();
		
		//modifications on waits
				commonMethods.handleExplicitWait(15, lp.warningText(), driver);
		
		String actual=lp.warningText().getText();
		String expected=storeData.LoginFailedExpectedText;
		commonMethods.handleAssertion(actual,expected);
		//sa.assertEquals(actual, expected);
		//sa.assertAll();
		
	}
	}


