package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.webdriverutility.JavaUtility;
import gulframework.fileutility.FileUtility;


public class CreateOrgWithPhoneNumber {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

String BROWSER=fLib.getDataFromPropertiesFile("browser");
String URL=fLib.getDataFromPropertiesFile("url");
String USERNAME=fLib.getDataFromPropertiesFile("username");
String PASSWORD=fLib.getDataFromPropertiesFile("password");



String orgName=eLib.getDataFromExcel("org",7,2)+jLib.getrandomNumber();
		
		String phoneNumber=eLib.getDataFromExcel("org",7,3)+jLib.getrandomNumber();
	
		
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
			  driver.findElement(By.id("phone")).sendKeys(phoneNumber);
			  
			 
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			
			  //verify phonenumber
			  String headerInfo=driver.findElement(By.xpath("//span[class='dvHeaderText']")).getText();
			  if(headerInfo.contains(orgName)) {
				  System.out.println(orgName+"is created==PASS");
			  }
				  else
					  System.out.println(orgName+"is not created==FAIL");
             
		     
			  
			  driver.quit(); 

	}

}
