package Maven2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}
	By username = By.xpath("//*[@type='text']");
	By password = By.xpath("//*[@type='password']");
	By signin = By.xpath("//*[@type='submit']");
	By Homepage = By.xpath("//*[@href='https://www.rediff.com']");
	
	
	
	public WebElement username(){
		
		return driver.findElement(username);
	}
public WebElement password(){
		
		return driver.findElement(password);
	}
public WebElement signin(){
	
	return driver.findElement(signin);
}
public WebElement HomepageNavigationLink(){
	
	return driver.findElement(Homepage);
}

}


//*[@attribute='value']	    
//*[@type='text']
//*[@type='password']	
//*[@type='submit']	