package TestCase11;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Subscription1 extends OpenURL {
	@Test(priority = 0)
	public void Subscription_text_visible_at_cart_page() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
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
