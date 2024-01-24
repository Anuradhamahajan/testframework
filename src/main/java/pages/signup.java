package pages;
import Base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class signup extends base{

	@FindBy(xpath="//a[@href='/login']")
	WebElement loginsignupButton;
	
	@FindBy(xpath ="//input[@data-qa='signup-name']")
	WebElement signupName;

	@FindBy(xpath ="//input[@data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signupButton;
	
	@FindBy(xpath="//p[contains(text(),'Email Address')]")
	WebElement SignupError;
	
	public signup() {     // constructor		
		super();
		PageFactory.initElements(driver, this);
	}
	
	public signup signupflow(String user, String email) throws InterruptedException {
		loginsignupButton.click();
		signupName.sendKeys(user);
		signupEmail.sendKeys(email);
		signupButton.click();
		Thread.sleep(3000);
		return new signup();
	}
	
	/****** script to validate empty name tooltip message 
	 * @throws InterruptedException **********/
	
	public signup emptyName() throws InterruptedException {
		
		loginsignupButton.click();		
		signupButton.click();
		String emsg = signupName.getAttribute("validationMessage");
		System.out.println(emsg);
        String ExpectedText ="Please fill out this field.";
        String ActualText = signupName.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText);
        Thread.sleep(3000);
		return new signup();
	}
	
/****** script to validate name tooltip message 
 * @throws InterruptedException **********/
	
	public signup tooltipNameMsg() throws InterruptedException {
		loginsignupButton.click();
		signupEmail.sendKeys("abc@gmail.com");
		signupButton.click();
        String msg = signupName.getAttribute("validationMessage");
        System.out.println(msg);
        String ExpectedText ="Please fill out this field.";
        String ActualText = signupName.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText);
        Thread.sleep(3000);
        return new signup();		
	}
	
/******* script to validate email tooltip message 
 * @throws InterruptedException ***********/
	
	public signup tooltipEmailMsg() throws InterruptedException {
		loginsignupButton.click();
		signupName.sendKeys("asda");
		signupEmail.sendKeys("amd@");
		signupButton.click();
		String emsg = signupEmail.getAttribute("validationMessage");
		System.out.println(emsg);
		String ExpectedText ="Please enter a part following '@'. 'amd@' is incomplete.";
        String ActualText = signupEmail.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText); 
        Thread.sleep(3000);
		return new signup();
	}
	
/****** script to validate existed email error message 
 * @throws InterruptedException ***********/
	
	public signup signupErrorMessage() throws InterruptedException {
		loginsignupButton.click();
		signupName.sendKeys("asda");
		signupEmail.sendKeys("asda@gmail.com");
		signupButton.click();
		String ActualError = SignupError.getAttribute("innerHTML");
        String ExpectedError = "Email Address already exist!";
        System.out.println(ActualError);
        Assert.assertEquals(ActualError, ExpectedError);
        Thread.sleep(3000);
        return new signup();
		}
}
