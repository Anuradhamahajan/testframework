package Base;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;


public class base {
	
	public static WebDriver driver;
	public static FileReader reader; // File reader is used to read the file
	public static Properties prop = new Properties();
	
	public base() {                     //constructor
		try {
			if (driver == null) {
			FileReader reader = new FileReader(
					"C:\\Users\\sande\\eclipse-workspace\\AutomationExerciseFramework\\src\\test\\resources\\properties\\config.properties");
			prop.load(reader);
				}
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
				}
		catch(IOException e) {
			e.printStackTrace();
				}
		
	}
	
	public void initialization() {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		}
	}

	public void teardown() {
		driver.close();
		System.out.println("Teardown done");

	}

}