package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.webdriverutility.JavaUtility;
import gulframework.fileutility.FileUtility;

public class CreateOragWithIndustries {
	public static void main(String[] args) throws Throwable,IOException {
	 
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

String BROWSER=fLib.getDataFromPropertiesFile("browser");
String URL=fLib.getDataFromPropertiesFile("url");
String USERNAME=fLib.getDataFromPropertiesFile("username");
String PASSWORD=fLib.getDataFromPropertiesFile("password");
//generate the random Number
Random random=new Random();
int randomInt=random.nextInt(1000);

String orgName=eLib.getDataFromExcel("org",4,2)+jLib.getrandomNumber();
String industry=eLib.getDataFromExcel("org",4,3)+jLib.getrandomNumber();	
String type=eLib.getDataFromExcel("org",4,4)+jLib.getrandomNumber();		
		


 WebDriver driver=null;
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
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  driver.get("http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=2&viewname=0&start="); 
	  driver.findElement(By.name("user_name")).sendKeys("admin");
	  driver.findElement(By.name("user_password")).sendKeys("admin");
	  driver.findElement(By.id("submitButton")).click();
	  driver.findElement(By.linkText("Organizations")).click();
	  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	  driver.findElement(By.name("accountname")).sendKeys(orgName);
	  WebElement wbsel=driver.findElement(By.name("industry"));
	  Select sel1=new Select(wbsel);
	  sel1.selectByVisibleText(industry);
	  WebElement wbsel2=driver.findElement(By.name("accounttype"));
			  Select sel2=new Select(wbsel2);
	  sel2.selectByVisibleText(type);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	  // verify Header msg expected result
	  String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	  String actIndustriese=driver.findElement(By.id("dtlview_Industry")).getText();
	  //verify industries and type info
	  if(actIndustriese.equals(industry)) {
		  System.out.println(industry+"information is verified==PASS");
	  }
		  else
			  System.out.println(industry+"information is not verified==FAIL");
	  
	  String actType=driver.findElement(By.id("dtlview_Type")).getText();
	  //verify industries and type info
	  if(actIndustriese.equals(industry)) {
		  System.out.println(type+"information is verified==PASS");
	  }
		  else
			  System.out.println(type+"information is not verified==FAIL");
	  
	  
	
	  
	  driver.quit(); 



}

}



