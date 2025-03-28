package TestCase6;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Setup.OpenURL;
import TestCase1.Register_User;

public class Contact_form extends OpenURL {
	@Test(priority = 0)
	public void redirect_to_contact_us_page() throws InterruptedException{
		driver.findElement(By.xpath("//ul/li[8]//i[@class='fa fa-envelope']")).click();
		Thread.sleep(500);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@class='contact-form']//h2[@class='title text-center']")).isDisplayed());
	}
	@Test(priority = 1)
	public void submit_form_successfull() throws InterruptedException{
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("longlong");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("long@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("hihi");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("hihi");
		Thread.sleep(500);
		WebElement file_upload_element = driver.findElement(By.name("upload_file"));
		file_upload_element.sendKeys("C:\\Users\\me-group\\Downloads\\ChromaKeyPhoto1.png");
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[@name='submit']")).isEnabled());
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement text_success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='status alert alert-success']")));
		assertTrue(text_success.isDisplayed());
	}
}
