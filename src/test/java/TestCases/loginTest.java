package TestCases;
import Base.base;
import pages.login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class loginTest extends base{
	
	login loginObj;
	
	loginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	public void loginflow() throws InterruptedException {
		loginObj = new login();
		loginObj.loginflow("qa12@gmail.com","ABC");		
	}
	
	@Test
	public void emptyEmail()throws InterruptedException {
		loginObj = new login();
		loginObj.emptyEmail();
	}
	
	@Test
	public void tooltipEmailMsg()throws InterruptedException {
		loginObj = new login();
		loginObj.tooltipEmailMsg();		
	}
	
	@Test
	public void tooltipPasswordMsg()throws InterruptedException {
		loginObj = new login();
		loginObj.tooltipPasswordMsg();		
	}
	
	@Test
	public void loginErrorMessage()throws InterruptedException {
		loginObj = new login();
		loginObj.loginErrorMessage();		
	}
	
	
	@AfterMethod
	public void close() {
		teardown();
	}
	
}
