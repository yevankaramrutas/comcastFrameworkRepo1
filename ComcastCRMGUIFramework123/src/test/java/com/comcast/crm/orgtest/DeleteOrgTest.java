package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.webdriverutility.JavaUtility;
import gulframework.fileutility.FileUtility;
import objrepoutility.LoginPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws Throwable,IOException {
		// TODO Auto-generated method stub
		
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("userName");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		
		String orgName=eLib.getDataFromExcel("org",4,3)+jLib.getrandomNumber();
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
	      driver.get(URL); 
	      LoginPage lp=new LoginPage(driver);
			/*
			 * lp.getUsernameEdt().sendKeys("admin"); lp.getPasswordEdt().sendKeys("admin");
			 * lp.getLoginBtn().click();
			 */
	      lp.loginToApp(USERNAME, PASSWORD);
	     //Step2.Navigate to Oraganization model
	      HomePage hp=new HomePage(driver);
	      hp.getOrgLink().click();
	     //Create Organization page 
	      OrganizationPage cnp=new OrganizationPage(driver);
	      
	      
	     driver.findElement(By.linkText("Organizations")).click();
			  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			  driver.findElement(By.name("accountname")).sendKeys(orgName);
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			  Thread.sleep(2000);
			  Actions act=new Actions(driver);
			  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			  driver.findElement(By.linkText("Sign Out")).click();
			
			  // verify Header msg expected result
			  String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  if(headerInfo.contains(orgName)) {
				  System.out.println(orgName+"is created==PASS");
			  }
				  else
					  System.out.println(orgName+"is not created==FAIL");
				  
			  String actorgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
			  if(actorgName.equals(orgName)) {
				  System.out.println(orgName+"is created==PASS");
			  }
				  else
					  System.out.println(orgName+"is not created==FAIL");
			  
			  
			  //verify orgname info
			  driver.quit(); 
		
		
		
	}
}


