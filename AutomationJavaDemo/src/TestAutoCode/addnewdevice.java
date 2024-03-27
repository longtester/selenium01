package TestAutoCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addnewdevice {

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
        
        Thread.sleep(2000);
        
        /*String elementText = driver.findElement(By.xpath("//h2[normalize-space()='Photos']")).getText();
         if (elementText.contains("Photos"))
        		 {
        	 		System.out.println("Test case login is passed");
        		 }
         else {
        	 System.out.println("Test case login is failed");
		}*/
        
        WebElement application_txt = driver.findElement(By.xpath("//span[normalize-space()='Applications']"));
        application_txt.click();
        WebElement devices_txtElement = driver.findElement(By.xpath("//span[normalize-space()='Devices']"));
        devices_txtElement.click();
        
        Thread.sleep(3000);
        
       WebElement addnewdevice_btn = driver.findElement(By.id("btn-add-new"));
       boolean status = addnewdevice_btn.isDisplayed();
       if (status == true) {
    	   System.out.println("Add new Device button has displayed on Device screen");
       }
       else {
    	   System.out.println("Add new Device button has not displayed on Device screen");
       }

        
     
      
  
  
        

        // Thoát hẳn Browser

        driver.quit();

	}

}