package Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Flipkart {


	
	@Test
	  public void main() throws InterruptedException  {
		
// Opening Chrome Browser
		
	    
			System.setProperty("webdriver.chrome.driver","C:\\Users\\a.d.goswami\\Downloads\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
// Flipkart Site Run
			
			driver.get("https://www.flipkart.com/");
			
// Maximize window
			
			driver.manage().window().maximize();
			
// If Login PopUp Window appears then close it
			
			Thread.sleep(5000);
			try{
				
				boolean popUpText = driver.findElement(By.xpath("//span[normalize-space()='Get access to your Orders, Wishlist and Recommendations']")).isDisplayed();
				
				if (popUpText==true) {
					driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
					System.out.println("Popup was displayed in the Login Page, Close Button was clicked");
					
			}else {
				System.out.println("Popup was not displayed in the Login Page");
				}
				
			}catch(NoSuchElementException e) {
		        System.out.println("Popup was not displayed in the Login Page");
			}
			
// Search for a Product in the Search Bar
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("iphone");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			

// Clicking on the first product from the search result
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();

			
// Switching to the New Tab
			
			Thread.sleep(5000);
			
			Set<String> windowsId=driver.getWindowHandles();
			
			Iterator<String> iter1=windowsId.iterator();
			
			String childWindowpopup=iter1.next();
			
			String childWindowpopup1=iter1.next();
			
			driver.switchTo().window(childWindowpopup1);
			
// Printing the Price of the Selected Item			
			
			String Price= driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
			System.out.println("The Price of the Phone is " +Price);
			
//Clicking on Add To Cart
			
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
			
// Going to the Cart Page
			
			// In Flipkart when the user clicks on ADD TO CART, it redirects to the CART automatically
			
// Increasing the Quantity by 1
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]")).click();
	
// Printing the price after addition of the quantity
			
			Thread.sleep(5000);
			String newPrice= driver.findElement(By.xpath("(//span[@class='_2-ut7f _1WpvJ7'])")).getText();
			System.out.println("The updated Price of the Cart is " +newPrice);
			
			
}
}
