package TestCase3;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.OpenURL;
import TestCase1.Register_User;

public class Login_incorrect_email_password extends OpenURL {
	@Test(priority = 0)
	public void login_account_with_incorrect_email_password() throws InterruptedException {
		Register_User.new_user_signup_is_visible();
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("long1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("112345678");
		assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled());
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//p[@style='color: red;']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//p[@style='color: red;']")).getText(),"Your email or password is incorrect!");
	}

}
