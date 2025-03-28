package Setup;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class OpenURL {
  public static WebDriver driver;
  
  @BeforeClass
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\me-group\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// Set Chrome options
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://automationexercise.com");
  }

  @AfterClass
  public void afterTest() throws InterruptedException {
	  	Thread.sleep(1000);
		//driver.quit();
  }

}
