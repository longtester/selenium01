package Input_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_button {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\me-group\\Downloads\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		Thread.sleep(3000);

		WebElement male_radio_button = driver
				.findElement(By.xpath("//label[normalize-space()='Male']//input[@name='optradio']"));
		boolean a = male_radio_button.isDisplayed() && male_radio_button.isEnabled();
		if (a == true) {
			male_radio_button.click();
			boolean b = male_radio_button.isSelected();
			if (b == true) {
				System.out.println("Male radio button has been clicked");
			} else {
				System.out.println("Male radio button has not been clicked");
			}
		} else {
			System.out.println("Male radio button is not displayed to click");
		}

	}

}
