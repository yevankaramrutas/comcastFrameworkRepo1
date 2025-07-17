package objrepoutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import crm.webdriverutility.WebDriverUtility;

/*@author Amruta

contains Login page elements & business lib like login()
*/
public class LoginPage extends WebDriverUtility {
	//1.create seperate class
	//2.object creation
	WebDriver driver;    //global variable
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;      //name of global and local variable are same so this keyword is used for avoid confusion
	PageFactory.initElements(driver,this);//this keyword means current page object
	//this constructor will take care of load element initial element and execute  @findBy annotation
	
	
	
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")

	private WebElement passwordEdt;

	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement loginBtn;

	private String url;

	//object initialization
	//object encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * Login to application based on username, password, url 
	 * @param url
	 * @param username
	 * @param password
	 */
	
	// 5.Utilize the object providing action
	public void loginToApp(String url,String username,String password) {
	   waitForPageLoad(driver);
	   
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
