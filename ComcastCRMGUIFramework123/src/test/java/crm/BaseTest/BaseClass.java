package crm.BaseTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.webdriverutility.JavaUtility;
import gulframework.fileutility.FileUtility;
import objrepoutility.HomePage;
import objrepoutility.LoginPage;

public class BaseClass {
	public DatabaseUtility dbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	WebDriver driver=null;
	@BeforeSuite 
	public  void configBs() throws Throwable
	{
		System.out.println("Connect gto DB,Report Config");	
		dbLib.getDBConnection();
		
		
	}
	
@BeforeClass 
public  void configbc() throws Throwable
{
	System.out.println("Launch Browser");	
	String BROWSER=fLib.getDataFromPropertiesFile("browser");
	
	 if(BROWSER.equals("edge")) {
		 driver=new EdgeDriver();
	 }
	 else if(BROWSER.equals("chrome"))
	 {
		 driver=new ChromeDriver();
				 
	 }
	 else
	 {
		 driver=new FirefoxDriver();
				 
	 }
	
}

	
	@BeforeMethod
public void configbm() throws Throwable
{
System.out.println("Login");	
String URL=fLib.getDataFromPropertiesFile("url");
String USERNAME=fLib.getDataFromPropertiesFile("userName");
String PASSWORD=fLib.getDataFromPropertiesFile("password");

LoginPage lp=new LoginPage(driver);
lp.loginToApp(URL, USERNAME, PASSWORD);

}
	
	
@AfterMethod
public void configAM()
{
System.out.println("logout");	
HomePage hp=new HomePage(driver);
hp.logout();

}

@AfterClass 
public  void configAC() throws Throwable
{
	System.out.println("Close Browser");	
driver.quit();
	
}
@AfterSuite 
public  void configAs() throws Throwable
{
	System.out.println("closeDB,Report Backup");	
	dbLib.getDBCloseConnection();
	
}
}
