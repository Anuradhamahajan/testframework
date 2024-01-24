package pages;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Base.base;

public class home {
	@FindBy(xpath ="//a[@href='/product_details/1']")
	WebElement viewProduct1;
	
	
}
