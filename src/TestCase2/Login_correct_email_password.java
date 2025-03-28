package TestCase2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.OpenURL;
import TestCase1.Register_User;

public class Login_correct_email_password extends OpenURL {
	@Test(priority = 0)
	public static void login_account_successfull() throws InterruptedException{
		Register_User.new_user_signup_is_visible();
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("long@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled());
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	@Test (priority = 1)
	public void  logged_in_as_username_is_visible() throws InterruptedException{
		Register_User.logged_in_as_username_is_visible();
	}

}
