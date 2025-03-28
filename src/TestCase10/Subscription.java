package TestCase10;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Subscription extends OpenURL {
	@Test(priority = 0)
	public void Subscription_text_visible_at_home_page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")));
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).isDisplayed());
	}
	@Test(priority = 1)
	public void Subscribe_successfull() throws InterruptedException{
		assertTrue(driver.findElement(By.xpath("//input[@id='susbscribe_email']")).isEnabled());
		driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("hi@emai.com");
		driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
		assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText(),"You have been successfully subscribed!");
	}

}
