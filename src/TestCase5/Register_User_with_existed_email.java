package TestCase5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.OpenURL;
import TestCase1.Register_User;

public class Register_User_with_existed_email extends OpenURL {
	@Test(priority = 0)
	public void Register_User_fail_with_existed_email() throws InterruptedException{
		Register_User.new_user_signup_is_visible();
		driver.findElement(By.xpath("//form//input[@data-qa='signup-name']")).sendKeys("long1");
		Thread.sleep(500);
		driver.findElement(By.xpath("//form//input[@data-qa='signup-email']")).sendKeys("long@gmail.com");
		driver.findElement(By.xpath("//form//button[@data-qa='signup-button']")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//p[@style='color: red;']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//p[@style='color: red;']")).getText(),"Email Address already exist!");
	}
}
