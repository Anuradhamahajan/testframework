package pages;
import Base.base;
//import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.Alert;


public class contactus extends base {

	@FindBy(xpath ="//a[@href='/contact_us']")
	WebElement contactPagebutton;
	
	
	@FindBy(xpath ="//input[@data-qa='name']")
	WebElement contactName;
	
	@FindBy(xpath="//input[@data-qa='email']")
	WebElement contactEmail;
	
	@FindBy(xpath="//input[@data-qa='subject']")
	WebElement contactSubject;
	
	@FindBy(xpath="//textarea[@data-qa='message']")
	WebElement cotactMessage;
	
	@FindBy(xpath="//input [@name='upload_file']")
	WebElement contactfile;
	
	@FindBy(xpath="//input[@data-qa='submit-button']")
	WebElement submitbutton;


	public contactus() {	
		super();
		PageFactory.initElements(driver, this);
		
	}

	public home contactflow(String name, String email, String subject, String message, String file) throws InterruptedException {
		contactPagebutton.click();
		contactName.sendKeys(name);
		contactEmail.sendKeys(email);
		contactSubject.sendKeys(subject);
		cotactMessage.sendKeys(message);
		contactfile.sendKeys(file);
		submitbutton.click();
		driver.switchTo().alert().accept();		
		Thread.sleep(3000);
		return new home();
	
	 }

	/****** script to validate empty email tooltip message **********/
	
	public home emptyEmail() throws InterruptedException {
		
		contactPagebutton.click();		
		submitbutton.click();
		String emsg = contactEmail.getAttribute("validationMessage");
		System.out.println(emsg);
        String ExpectedText ="Please fill out this field.";
        String ActualText = contactEmail.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText); 
        Thread.sleep(3000);
		return new home();
	}




}