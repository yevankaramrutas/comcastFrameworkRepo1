package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.webdriverutility.JavaUtility;
import crm.webdriverutility.WebDriverUtility;
import gulframework.fileutility.FileUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("userName");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		
		
		
		String orgName=eLib.getDataFromExcel("contact", 7, 2)+jLib.getrandomNumber();
	
		String contactLastName=eLib.getDataFromExcel("contact", 7,3)+jLib.getrandomNumber();
		
		
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
		 
		 //1 Login to app
	wLib.waitForPageLoad(driver);
		  driver.get(URL); 
			  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			  driver.findElement(By.id("submitButton")).click();
			 
			 // 2 Navigate to Module
			  driver.findElement(By.linkText("Organizations")).click();
			 
			  // 3 click on Create Organization Button
			  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			  
			  // 4 Enter all the details & create New Organization 
			  driver.findElement(By.name("accountname")).sendKeys(orgName);
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			   
			   //5 navigate to organization module
				  driver.findElement(By.linkText("Contacts")).click();
				  
				  //step 6 click on create organization Button
				  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				  
				  //Step 7 enter all the details and create new organization
				  driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img"));
				 
				  //switch to child window
				  wLib.switchToTabOnURL(driver, "module=Accounts");
				 
				 driver.findElement(By.name("search_text")).sendKeys(orgName);
				  driver.findElement(By.name("search")).click();
				  
				  driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				  
				  //switch to parent window
				  wLib.switchToTabOnURL(driver, "Contacts&action"); 
				 
				  
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				  
				
				   String headerInfo=driver.findElement(By.xpath("//span[class='dvHeaderText']")).getText();
			  
			   if(headerInfo.contains(contactLastName)) {
					  System.out.println(contactLastName+" header is created==PASS");
				  }
					  else
						  System.out.println(contactLastName+" header is not created==FAIL");
			   
			   // verify header orgName info Expected Result
			   
			   String actorgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				  
				  if(actorgName.trim().equals(orgName))
				  {
					  System.out.println(orgName+"inforamation is created ");
				  }
					  else
						  System.out.println(orgName+"inforamation is not verified==FAIL");
				  
					  
			  
		driver.quit();

	}}
