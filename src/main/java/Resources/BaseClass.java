package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;
public class BaseClass {
   public static WebDriver driver;
   
   public Properties prop;
   
   //Assigned the value of uniqemailAddress to emailAddress
   public static String emailAddress=UniqemailAddress();
   
	public void browserLaunch() throws IOException
	
	{
		//Read the data of data.properties file
		//FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Framework\\Framework\\src\\main\\java\\Resources\\data.properties");
		
		//Modification user.dir will take automatically path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ 
				"\\src\\main\\java\\Resources\\data.properties");
		
		//Object of properties class to access the data of  .properties file
	 prop=new Properties();
		
		//Read keleli fis file load karnyasathi
		prop.load(fis);
		
		
		//it will return the key value of browser i.e chrome
		String browserName=prop.getProperty("browser");
		
		//We are using condition jar value chrme dili tar chrome launch honar, firefox tr fox
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else {
			System.out.println("please choose the correct browser");
		}
	
		
	}
	
	// Method for creatinng unique mail id
	//we have declared static for UniqemailAddress because registration and login ch mail to vegla gheto i.y we have declared static
	public static String UniqemailAddress()
	{
		return System.currentTimeMillis()+ "@gmail.com";
	}
	
	//To Capture the Screenshots of Failed Test Case
	
	public static String screenshot(WebDriver driver,String filename)
	{
		//For capturing screenshot at what time tc got failedS
		String dateAndTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//20240906120630
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+ "\\ScreenShot\\"+ filename +"_"+ dateAndTime +".png";
		try {
			FileUtils.copyFile(source,new File(destination));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return destination;
	}
	
	@BeforeSuite
	public void ExtentReport() {
		extentReports.setup();
	}
	
	@AfterSuite
	public void endReport() {
		extentReports.endReport();
	}
	
	@BeforeMethod
	public void launchBrowserAndOpenURI() throws IOException
	{
		browserLaunch();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
		
	}
}
