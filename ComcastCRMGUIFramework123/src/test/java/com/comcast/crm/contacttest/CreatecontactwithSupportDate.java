package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import gulframework.fileutility.FileUtility;

public class CreatecontactwithSupportDate {





	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("userName");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		
		
		String lastName=eLib.getDataFromExcel("contact",4,1)+randomInt;

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
		  driver.findElement(By.linkText("Contacts")).click();
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 
		  Date dateobj=new Date();
		 SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		 String startDate=sim.format(dateobj);
		
			
	      Calendar cal=sim.getCalendar();
	      cal.add(Calendar.DAY_OF_MONTH,30);
	      String endDate = sim.format(cal.getTime());


	   
	      driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.name("support_start_date")).clear();
		  driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		  
		  driver.findElement(By.name("support_end_date")).clear();
		  driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		  
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		  // verify Header msg expected result
		   String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		  //verify industries and type info
		  if(actStartDate.equals(startDate)) {
			  System.out.println(startDate+"StartDate is verified==PASS");
		  }
			  else
				  System.out.println(startDate+"StartDate is not verified==FAIL");
		  String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		 
		  
		  if(actEndDate.equals(endDate)) {
			  System.out.println(endDate+"EndDate is verified==PASS");
		  }
			  else
				  System.out.println(endDate+"EndDate is not verified==FAIL");
		  
				
}
	 

}
