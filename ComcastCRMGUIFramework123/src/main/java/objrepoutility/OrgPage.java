package objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	WebDriver driver;

	public OrgPage(WebDriver driver)
	{
		this.driver=driver;      
	PageFactory.initElements(driver,this);	
	}
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return CreateNewOrgBtn;
	}
	

}
