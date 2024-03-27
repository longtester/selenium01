package TestAutoCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\me-group\\Downloads\\chromedriver-win64\\chromedriver.exe");
	 
	    WebDriver driver = new ChromeDriver();
	    
        //1 - Maximize browser của mình
        driver.manage().window().maximize();
        

        //2 - Đi đến 1 url
        
        driver.navigate().to("https://ikeep-tst.photomechina.com");
        
      
        // Find DOM elements for email field
        WebElement email = driver.findElement(By.id("login-email"));
        email.sendKeys("photome");
        
     
        // Find DOM elements for password field
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("China@2000");
        
        // Find DOM elements for Sign in button
        WebElement button_loginaccount = driver.findElement(By.xpath("//button[@type='submit']"));
        button_loginaccount.click();
        
        Thread.sleep(9000);
        
        /*String elementText = driver.findElement(By.xpath("//h2[normalize-space()='Photos']")).getText();
         if (elementText.contains("Photos"))
        		 {
        	 		System.out.println("Test case login is passed");
        		 }
         else {
        	 System.out.println("Test case login is failed");
		}*/
        
        WebElement application_txt = driver.findElement(By.xpath("//span[normalize-space()='Applications']"));
        WebElement devices_txtElement = driver.findElement(By.xpath("//span[normalize-space()='Devices']"));
        WebElement sales_txtElement = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        WebElement settings_txt = driver.findElement(By.xpath("//span[@data-i18n='Menu-Settings']"));
        
        if (application_txt.isDisplayed() && settings_txt.isDisplayed()) {
        	System.out.println("Login success with account Admin");
        }
        else {
        	System.out.println("Login fail with account Admin");
		}
      
  
  
        

        // Thoát hẳn Browser

        driver.quit();

	}

}
