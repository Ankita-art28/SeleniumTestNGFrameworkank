package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObjects {

	public WebDriver driver;// this driver is null
	//encapsulation
	private By myAccount=By.xpath("//a[@title='My Account']");
	
	private By register=By.xpath("//a[text()='Register']");
	
	private By login=By.xpath("//a[text()='Login']");
	
	//driver null ali asti mhnun apan 16 ch driver ch scope base class madhun ghetla and to 9 la assign kela
	public homePageObjects(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//will return an webelement
	public WebElement clickOnmyAccount()
	{
		//driver. findELement By.xpath hi purn line ahe
		return driver.findElement(myAccount);
	}
	
	public WebElement clicOnRegister()
	{
		return driver.findElement(register);
	}
	
	public WebElement clicOnLogin()
	{
		return driver.findElement(login);
	}
	
	
}
