package com.comcast.crm.contacttest;
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

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.ExcelUtility;

import crm.BaseTest.BaseClass;
import crm.webdriverutility.JavaUtility;
import gulframework.fileutility.FileUtility;
import objrepoutility.HomePage;
/*
 * @author Amruta
 * */

public class CreateContactTest extends BaseClass{
	
	@Test
	
	public void createContact() throws Throwable,IOException {

//create object
		
String lastName=eLib.getDataFromExcel("contact",1,2)+jLib.getrandomNumber();

HomePage hp=new HomePage(driver);
hp.getContactLink().click();
ContactPage cp=new ContactPage(driver);
cp.getCreateNewOrgBtn().click();
CreateNewContactPage cpp=new CreateNewContactPage(driver);



cpp.createContact(lastName);
//verify header phone number
String actHeader=op.


/*
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * driver.get(
 * "http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=2&viewname=0&start="
 * ); driver.findElement(By.name("user_name")).sendKeys("admin");
 * driver.findElement(By.name("user_password")).sendKeys("admin");
 * driver.findElement(By.id("submitButton")).click();
 * driver.findElement(By.linkText("Contacts")).click();
 * driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
 * driver.findElement(By.name("lastname")).sendKeys(lastName);
 * 
 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 * 
 * 
 * // verify Header msg expected result String
 * actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
 */
	  //verify industries and type info
	  if(actLastName.equals(lastName)) {
		  System.out.println(lastName+"lastName is verified==PASS");
	  }
		  else
			  System.out.println(lastName+"lastName is not verified==FAIL");
	  
	  

	}}