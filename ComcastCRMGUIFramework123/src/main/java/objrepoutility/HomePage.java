package objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;      
	PageFactory.initElements(driver,this);	
	}
	
@FindBy(linkText="Organizations")
private WebElement orgLink;

@FindBy(linkText="Contacts")
private WebElement contactLink;

@FindBy(linkText="Campaigns")
private WebElement campaignLink;

@FindBy(linkText="More")
private WebElement moreLink;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;

@FindBy(linkText = "Sign Out")
private WebElement SignoutLink;


@FindBy(linkText = "Products")
private WebElement productsLink;

public WebElement getProductsLink() {
	return productsLink;
	
	@FindBy(linkText = "pro")
	private WebElement proLink;
	
}



public void setProductsLink(WebElement productsLink) {
	this.productsLink = productsLink;
}



public WebElement getOrgLink(){
	return orgLink;
}



public void getContactLink() {
	this.contactLink= contactLink;
	
}


public void getMoreLink() {
		this.moreLink=moreLink;
}
	
	
public void navigateToCampaignPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(campaignLink).perform();
		contactLink.click();
	}


public void logout() {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();;
	SignoutLink.click();
}




}


