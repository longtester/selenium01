package TestCase4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.OpenURL;
import TestCase1.Register_User;
import TestCase2.Login_correct_email_password;

public class Logout_User extends OpenURL {
	@Test(priority = 0)
	public void redirect_to_login_page_when_click_logout_button() throws InterruptedException{
		Login_correct_email_password.login_account_successfull();
		driver.findElement(By.xpath("//ul/li[4]//i[@class='fa fa-lock']")).click();
		Register_User.new_user_signup_is_visible();
	}
}
