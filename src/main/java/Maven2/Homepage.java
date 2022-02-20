package Maven2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage  {
	
	public WebDriver driver;
	
	
	@FindBy(xpath="//*[@name='srchword']")
	WebElement mainsearch;
	
	@FindBy(xpath="//*[@name='srchquery_tbox']")
	WebElement sec;

	//By Homepage = By.xpath("//*[@name='srchword']");
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
		
	}
	
	public WebElement mainsearch() {
		return mainsearch;
}
}
