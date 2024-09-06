package TestCases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyProductCartPrice {

	public static void main(String[] args)
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		WebElement obj=driver.findElement(By.xpath("//p[@class='price']"));
		
		String iphoneCostFull=obj.getText();
		
		//It will give complete text
		System.out.println(obj.getText());
		
		System.out.println("=====================================================================");
		//For spliting text
		String[] spl=iphoneCostFull.split(" ");
		
		//It will return string array comma ne sperate karel
		System.out.println(Arrays.toString(spl));//[$123.20Ex, Tax:, $101.00]
		
		String StringIphoneCost=spl[0].replaceAll("[^0-9\\.]", "");
				System.out.println(StringIphoneCost);//123.20
				
		Double iphoneCost=Double.parseDouble(StringIphoneCost)	;	
		System.out.println(iphoneCost);
	}
	
	
	
	
	
}
