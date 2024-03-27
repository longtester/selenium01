package Input_form;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class Check_box {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\me-group\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		Thread.sleep(3000);
		
		WebElement uncheckboxElement = driver.findElement(By.id("isAgeSelected"));
		/*boolean a = uncheckboxElement.isSelected();*/
		
		//Lấy hết list của các checkbox có trong một panel-body
		List<WebElement> listcheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Tong so luong checkbox: "+ listcheckbox.size());
		
		// Tạo vòng lặp và in ra từng checkbox có trong list
		/*for (int i =0; i<listcheckbox.size(); i++) {
			boolean isCheckbox = listcheckbox.get(i).isSelected();
			if (isCheckbox == false) {
				System.out.println("Checkbox "+(i+1)+ " is not checked");
			}
		}*/
		
		// Tạo vòng lặp và check từng checkbox
		/*for(int i=0; i<listcheckbox.size();i++) {
			boolean isCheckbox = listcheckbox.get(i).isSelected();
			if (isCheckbox == false) {
				listcheckbox.get(i).click();
				Thread.sleep(2000);
			}
		}*/
		
		// Test case cho Check All button
		WebElement checkall_btn = driver.findElement(By.id("check1"));
		boolean a = checkall_btn.isDisplayed() && checkall_btn.isEnabled();
		if (a == true) {
			System.out.println("Check All is a button");
		}
		else {
			System.out.println("Check All is not a button");
		}
		checkall_btn.click();
		for(int i = 0; i<listcheckbox.size(); i++) {
			boolean a1 = listcheckbox.get(i).isSelected();
			if (a1 == true) {
				System.out.println("All check box has been checked");
				break;
			}
		}
		
		String expect_result = "Uncheck All";
		String actual_result = checkall_btn.getText();
		if(actual_result.equals(expect_result)) {
			System.out.println("After click Check All button, text in button is "+expect_result );
		}
		else {
			System.out.println("After click Check All button, text in button is not "+expect_result );
		}
	

	
	
		
		
	
		
		
	
		/*if (a == false) {
			driver.findElement(By.id("isAgeSelected")).click();
		}*/
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
