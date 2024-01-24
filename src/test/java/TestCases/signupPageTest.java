package TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.base;
import pages.login;
import pages.signupPage;

public class signupPageTest extends base{
	
	signupPage signUpobj;
	
	signupPageTest(){
			super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	
	public void signupflow() throws InterruptedException {
		signUpobj = new signupPage();
		signUpobj.signupflow();
	}
	public void signupPageflow() {
		signUpobj = new signupPage();
		signUpobj.signupPageflow("ad","ad123@gmail.com","12345");
		
	}
	
	@AfterMethod
	public void close() {
		teardown();
	}
	
}
