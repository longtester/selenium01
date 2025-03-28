package TestCase1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Register_User extends OpenURL {
	public static String signup_name = "long";
	String signup_mail = "long@gmail.com";

	@Test(priority = 0)
	public static void new_user_signup_is_visible() throws InterruptedException {
		WebElement signup_btn = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
		signup_btn.click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText(),
				"New User Signup!");
		assertTrue(driver.findElement(By.xpath("//button[@data-qa='signup-button']")).isEnabled());
	}
	@Test(priority = 1)
	public void enter_account_information_is_visible() throws InterruptedException{
		driver.findElement(By.xpath("//form//input[@data-qa='signup-name']")).sendKeys(signup_name);
		Thread.sleep(500);
		driver.findElement(By.xpath("//form//input[@data-qa='signup-email']")).sendKeys(signup_mail);
		Thread.sleep(500);
		driver.findElement(By.xpath("//form//button[@data-qa='signup-button']")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//input[@id='name']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), signup_name);
		assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), signup_mail);
	}
	@Test(priority = 2)
	public void create_account_successfull() throws InterruptedException {
		driver.findElement(By.xpath("//span//input[@id='id_gender2']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678");
		Thread.sleep(500);
		Select day_dropdown = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		Select month_dropdown = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		Select year_dropdown = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		day_dropdown.selectByValue("1");
		Thread.sleep(500);
		month_dropdown.selectByVisibleText("June");
		Thread.sleep(500);
		year_dropdown.selectByIndex(6);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("tran");
		WebElement last_name = driver.findElement(By.xpath("//input[@id='last_name']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",last_name);
		last_name.sendKeys("minh");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("182D");
		Select country_dropdown = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		country_dropdown.selectByIndex(6);
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Viet Nam");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Ha Noi");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("0084");
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("0084556644");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Continue']")).isEnabled());
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 3)
	public static void logged_in_as_username_is_visible() throws InterruptedException{
		assertEquals(driver.findElement(By.xpath("//li[10]//a[1]")).getText(),"Logged in as "+ signup_name);
		assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());
	}
	/*@Test(priority = 4)
	public void delete_account_successfull() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed());
	}*/
}
