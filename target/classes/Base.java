package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver fire() throws IOException {
		prop=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\harik\\eclipse-workspace\\Maven2\\proprties");
		prop.load(fis);
	String e=	prop.getProperty("browser");
	if(e.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  driver = new ChromeDriver();
	}
	else if(e.equals("edge"))
	{
		// Set the driver path
		System.setProperty("webdriver.edge.driver", "C://EdgeDriver.exe");

		// Start Edge Session
		 driver = new EdgeDriver();
	}
	return driver;

		
	}
	
}
