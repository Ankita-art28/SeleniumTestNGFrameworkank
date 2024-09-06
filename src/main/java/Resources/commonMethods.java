package Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class commonMethods {

	

	public static void handleAssertion(String actualText, String expectedText) {
		// TODO Auto-generated method stub
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualText, expectedText);
		sa.assertAll();
	}
	
	//In this we doesnt write fix value i.e. click on my account .yat test script madhun value yete tyamule he parameter nehmi change honare write karne
	public static void handleExplicitWait(int time, WebElement element,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
