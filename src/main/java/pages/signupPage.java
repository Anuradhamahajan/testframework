package pages;
import Base.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class signupPage extends base{
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement loginsignupButton;
	
	@FindBy(xpath ="//input[@data-qa='signup-name']")
	WebElement signupName;

	@FindBy(xpath ="//input[@data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signupButton;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement Radiobtn;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement Name;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	Select Days =new Select(driver.findElement(By.xpath("//select[@id='days']")));
		
	Select Months =new Select(driver.findElement(By.xpath("//select[@id='months']")));
	
	Select Years =new Select(driver.findElement(By.xpath("//select[@id='years']")));
	
	@FindBy(xpath="//select[@id='years']")
	WebElement Year;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement Newsletter;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement Offer;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement Company;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement Address2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement Zipcode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement MobileNumber;
	
	
	public signupPage() {	
		super();
		PageFactory.initElements(driver, this);
		}

	
	public void signupflow() throws InterruptedException {
		loginsignupButton.click();
		signupName.sendKeys("zx");
		signupEmail.sendKeys("zxc@gmail.com");
		signupButton.click();
		Thread.sleep(3000);
		//return new signup();
	}
	
	
	
	public home signupPageflow(String name,String email,String password) {
		
		Radiobtn.click();
		Name.sendKeys(name);
		Email.sendKeys(email);
		Password.sendKeys(password);
		Days.selectByVisibleText("6");
		Days.selectByVisibleText("February");
		Days.selectByVisibleText("2000");		
		Newsletter.click();
		Offer.click();
		return new home();
		
	}
	
	
	
	
	
	
	
	
	
}
