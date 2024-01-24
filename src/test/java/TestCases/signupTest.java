package TestCases;
import Base.base;
import pages.login;
import pages.signup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class signupTest extends base{
	
	signup signupObj;
	
	signupTest(){	
		super();
		}
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	public void signupflow() throws InterruptedException {
		signupObj = new signup();
		signupObj.signupflow("Abcgfg", "abcrty12@gmail.com");
	}
	
	@Test
	public void emptyName() throws InterruptedException {
		signupObj = new signup();
		signupObj.emptyName();
	}
	
	@Test	
	public void tooltipNameMsg() throws InterruptedException {
		signupObj = new signup();
		signupObj.tooltipNameMsg();		
	}
	
	@Test
	public void tooltipEmailMsg() throws InterruptedException {
		signupObj = new signup();
		signupObj.tooltipEmailMsg();		
	}
	
	@Test
	public void signupErrorMessage() throws InterruptedException {
		signupObj = new signup();
		signupObj.signupErrorMessage();		
	}
	
	
	
	@AfterMethod
	public void close() {
		teardown();
	}
	
}
