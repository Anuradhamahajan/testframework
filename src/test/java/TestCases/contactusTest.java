package TestCases;
import Base.base;
import pages.contactus;
import pages.login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class contactusTest extends base{

	contactus contactobj;
	
	contactusTest(){
	super();	
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	public void contactflow() throws InterruptedException{
		contactobj = new contactus();
		contactobj.contactflow("rj", "rj@gmail.com", "hello", "hello world","C:\\Users\\sande\\OneDrive\\Documents\\Answersheet2.docx");
	}
	
	@Test
	public void emptyEmail()throws InterruptedException {
		contactobj = new contactus();
		contactobj.emptyEmail();
	}
	
	
	
	@AfterMethod
	public void close() {
		teardown();
	}
	
	
	
	
	
	
}
