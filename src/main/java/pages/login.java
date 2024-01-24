package pages;
import Base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class login extends base{	
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement loginsignupButton;	
	
	@FindBy(xpath ="//input[@data-qa='login-email']")
	WebElement loginEmail;

	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement loginPassword;

	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//p[contains(text(),'Your email')]")
	WebElement loginError;

	public login() {	
	super();
	PageFactory.initElements(driver, this);
	}

	public home loginflow(String email, String password) throws InterruptedException {
	loginsignupButton.click();
	loginEmail.sendKeys(email);
	loginPassword.sendKeys(password);
	loginButton.click();
	Thread.sleep(3000);
	return new home();
	} 
	
	/****** script to validate empty email tooltip message 
	 * @throws InterruptedException **********/
	
	public home emptyEmail() throws InterruptedException {
		
		loginsignupButton.click();		
		loginButton.click();
		String emsg = loginEmail.getAttribute("validationMessage");
		System.out.println(emsg);
        String ExpectedText ="Please fill out this field.";
        String ActualText = loginEmail.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText); 
        Thread.sleep(3000);
		return new home();
	}
	
	/******* script to validate email tooltip message 
	 * @throws InterruptedException ***********/
	
	public home tooltipEmailMsg() throws InterruptedException {
		loginsignupButton.click();
		loginEmail.sendKeys("amd@");
		loginButton.click();
		String emsg = loginEmail.getAttribute("validationMessage");
		System.out.println(emsg);
		String ExpectedText ="Please enter a part following '@'. 'amd@' is incomplete.";
        String ActualText = loginEmail.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText); 
        Thread.sleep(3000);
		return new home();
	}
	
	/****** script to validate password tooltip message 
	 * @throws InterruptedException **********/
	
	public home tooltipPasswordMsg() throws InterruptedException {
		loginsignupButton.click();
		loginEmail.sendKeys("abc@gmail.com");
		loginButton.click();
        String msg = loginPassword.getAttribute("validationMessage");
        System.out.println(msg);
        String ExpectedText ="Please fill out this field.";
        String ActualText = loginPassword.getAttribute("validationMessage");
        Assert.assertEquals(ActualText, ExpectedText);
        Thread.sleep(3000);
        return new home();		
	}
	
	/****** script to validate error message 
	 * @throws InterruptedException ***********/
	
	public home loginErrorMessage() throws InterruptedException {
		loginsignupButton.click();
		loginEmail.sendKeys("abc@gmail.com");
		loginPassword.sendKeys("qwerty");
		loginButton.click();
		String ActualError = loginError.getAttribute("innerHTML");
        String ExpectedError = "Your email or password is incorrect!";
        System.out.println(ActualError);
        Assert.assertEquals(ActualError, ExpectedError);
        Thread.sleep(3000);
        return new home();
		}
	
	
	
	
}