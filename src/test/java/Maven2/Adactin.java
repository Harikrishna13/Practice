package Maven2;



import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Adactin extends LibGlobal {
	
		
		LibGlobal lib=new LibGlobal();
		
		@BeforeClass
		public static void beforeTest() {
			WebDriver driver = lanchBrowser();
			loadUrl(driver,"https://adactinhotelapp.com/");
			
		    
		}
		
		@Test
		
		public void test() throws IOException, InterruptedException {
			
			WebElement txtUserName = lib.findElementById("username");
			lib.setText(txtUserName, lib.getDataFromExcel("Sheet1", 1, 0));
			
			WebElement txtPassword = lib.findElementById("password");
			lib.setText(txtPassword, lib.getDataFromExcel("Sheet1", 1, 1));
			
			WebElement btnLogin = lib.findElementById("login");
			lib.btnClick(btnLogin);
			
			WebElement txt = lib.findElementByClassname("login_title");
			String text = txt.getText();
			System.out.println(text);
			
			Assert.assertEquals(text, "Search Hotel (Fields marked with Red asterix (*) are mandatory)", "verify ");
			
			
			
			
			WebElement d = lib.findElementById("location");
			lib.selectByIndex(d, 2);
		  
		    
			WebElement d1 = lib.findElementById("hotels");
		   lib.selectByIndex(d1, 3);
		    
		   WebElement d2 = lib.findElementById("room_type");
		    lib.selectByIndex(d2, 3);
		    
		    WebElement d3 = lib.findElementById("room_nos");
		    lib.selectByIndex(d3, 7);
		    
		    WebElement d4 = lib.findElementById("adult_room");
		    lib.selectByIndex(d4, 2);
		    
		    WebElement d5 = lib.findElementById("child_room");
		    lib.selectByIndex(d5, 2);
		    
		    WebElement btnSearch = lib.findElementById("Submit");
			lib.btnClick(btnSearch);
			
			WebElement txt1 = lib.findElementByClassname("login_title");
			String text1 = txt1.getText();
			System.out.println(text1);
			
			Assert.assertEquals(text1, "Select Hotel", "verify ");
			
			
			
			WebElement btnradio = lib.findElementById("radiobutton_0");
			lib.btnClick(btnradio);
				
			WebElement btnContinue = lib.findElementById("continue");
			lib.btnClick(btnContinue);
			
			WebElement txt2 = lib.findElementByXpath("//td[text()='Book A Hotel '][1]");
			String text2 = txt2.getText();
			System.out.println(text2);
			
			Assert.assertEquals(text2, "Book A Hotel", "verify ");
			
			
			
				
			WebElement txtName = lib.findElementById("first_name");
			lib.setText(txtName, lib.getDataFromExcel("Sheet1", 1, 2));
			
			WebElement txtLast = lib.findElementById("last_name");
			lib.setText(txtLast,lib.getDataFromExcel("Sheet1", 1, 3));
			
			WebElement txtAddress = lib.findElementById("address");
			lib.setText(txtAddress, lib.getDataFromExcel("Sheet1", 1, 4));
			
			WebElement txtNumber = lib.findElementById("cc_num");
			lib.setText(txtNumber, lib.getDataFromExcel("Sheet1", 1, 5));
			
			WebElement v = lib.findElementById("cc_type");
			lib.selectByIndex(v, 2);
			
			WebElement v1 = lib.findElementById("cc_exp_month");
			lib.selectByIndex(v1, 9);
			
			WebElement v2 = lib.findElementById("cc_exp_month");
			lib.selectByIndex(v2, 9);
			
			WebElement v3 = lib.findElementById("cc_exp_year");
			lib.selectByIndex(v3, 9);
			
			WebElement txtcvv = lib.findElementById("cc_cvv");
			lib.setText(txtcvv, lib.getDataFromExcel("Sheet1", 1, 6));
			
			WebElement btnBook = lib.findElementById("book_now");
			lib.btnClick(btnBook);
			Thread.sleep(15000);

			WebElement txt3 = lib.findElementByXpath("//td[text()='Booking Confirmation ' ]");
					String text3 = txt3.getText();
			System.out.println(text3);
			
			Assert.assertEquals(text3, "Booking Confirmation", "verify ");
			
			
			
			
	
			
			WebElement txtOrderNo = driver.findElement(By.id("order_no"));
			String at = lib.getAttribute(txtOrderNo, "value");	
			System.out.println(at);
			
			
			lib.updateDataInExcel("Sheet1", 1, 7, at);
			
			WebElement tx4= lib.findElementByXpath("//a[text()='Booked Itinerary']");
			btnClick(tx4);
			
			WebElement txtOrderNo1 = driver.findElement(By.id("order_id_text"));
			lib.setText(txtOrderNo1, lib.getDataFromExcel("Sheet1", 1, 7));
			
			WebElement txtOrderNo2 = driver.findElement(By.id("search_hotel_id"));
			btnClick(txtOrderNo2);
			
			WebElement txtOrderNo3= lib.findElementByXpath("//td[@bgcolor='#FFFFFF'][3]");
			
			btnClick(txtOrderNo3);
			acceptAlert();

			WebElement txtOrderNo5 = driver.findElement(By.id("search_result_error"));
					String text6 = txtOrderNo5.getText();
			System.out.println(text6);
			

		}
	@AfterClass
	public static void afterClass() {
		close();
	}
	
}	
		
		
	    
		


