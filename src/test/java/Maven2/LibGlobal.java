package Maven2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
static WebDriver driver;
	
public  static WebDriver lanchBrowser() {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	
}
public  WebElement findElementById(String id) {
	
	WebElement element = driver.findElement(By.id(id));
	return element;

	}
public  WebElement findElementByClassname(String class1) {
	
	WebElement element = driver.findElement(By.className(class1));
	return element;

	}

public  WebElement findElementByXpath(String class1) {
	
	WebElement element = driver.findElement(By.xpath(class1));
	return element;

	}


	public static void loadUrl(WebDriver driver,String url) {
		driver.get(url);
		
	}
	public void setText(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void btnClick(WebElement e) {
		e.click();	
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();	
	}
	//Task
	public void get(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getEnteredUrl() {
		String Url= driver.getCurrentUrl();
		return Url;
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public  static void close() {
		driver.close();
	}
	public void switchTo() {
		driver.switchTo();

    }
	public String getWindowHandle() {
		String w = driver.getWindowHandle();
		return w;
    }
	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
   }
	
   public void navigate() {
	   Navigation n = driver.navigate();
	   n.refresh();
	   }
   public String getAttribute(WebElement element, String name) {
	   String attribute = element.getAttribute(name);
	   return attribute;
   }
   public boolean isDisplayed(WebElement element) {
	   boolean b = element.isDisplayed();
	   return b;
   }
   public boolean isEnabled(WebElement element) {
	   boolean enabled = element.isEnabled();
	   return enabled;
	   
   }
	public boolean isSelected(WebElement element) {
		boolean b = element.isSelected();
		return b;
	}
	public void refresh(Navigation navigate) {
		navigate.refresh();
	}
	public void forward(Navigation navigate) {
		navigate.forward();
	}
	public void back(Navigation navigate) {
		navigate.back();
	}
	public void to(Navigation navigate, String url) {
		navigate.to(url);
	}
	public void moveToElement(Actions action, WebElement target) {
		action.moveToElement(target).perform();
	}
	public void doubleClick(WebElement e) {
		Actions action=new Actions(driver);
		action.doubleClick(e).perform();
	}
	public void contextClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
	}
	public void perform() { 
		Actions action=new Actions(driver);
		action.perform();
	}
	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
		
	}
	public void sedkeys(Alert alert, String data) {
		alert.sendKeys(data);
	}
	public void selectByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectByvalue(WebElement element, String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	public void selectByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	public List<WebElement> getOptions(WebElement e){
		Select select=new Select(e);
		List<WebElement> list = select.getOptions();
		return list;
	}
	public boolean isMultiple(WebElement element) {
		Select select=new Select(element);
		boolean b = select.isMultiple();
		return b;
	}
	public void deselectByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}	
	public void deselectByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	public void deselectByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	public void deSelectAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	public WebElement getFirstSelectedOption(WebElement element) {
		Select select=new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option;
	}
	public List<WebElement> getAllSelecetedOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}
	public String getDataFromExcel(String sheet, int rowIndex, int cellIndex) throws IOException {
		String value=null;
		File file=new File("C:\\Users\\harik\\Documents\\mhk.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		int type = c.getCellType();
		if (type==1) {
			value = c.getStringCellValue();
			}
		if (type==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(date);		
			}
			else {
				double d = c.getNumericCellValue();
				long l=(long) d;
				value  = String.valueOf(l);	
			}
			}
		return value;		 
			}
	 public void updateDataInExcel(String sheet, int rownum, int cellnum, String data) throws IOException {
		File file=new File("C:\\Users\\harik\\Documents\\mhk.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rownum);
		Cell c = r.createCell(cellnum);
		c.setCellValue(data);
		FileOutputStream outputStream=new FileOutputStream(file);
		w.write(outputStream);
		
	} 
	 }

	 	


	    
		
		
	
		
		
		
		

	
		
		


		
		

	
		
	
		

	
		

	