package practice.test;

import org.testng.annotations.Test;

import objrepoutility.LoginPage;





/** 
 test class for contact module
 @auther Amruta
  *
  **/


public class SearchContactTest {
	/*Scenario : login()==>navigateContact==>createcontact()==>verify
	 * */
	@Test
	public void seacrhContactTest()
	{
		//Step1 Login to app
             LoginPage lp=new LoginPage(driver);
             lp.loginToApp("url", "username","password");
	}

}
