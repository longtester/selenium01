package TestCase7;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.OpenURL;
import TestCase1.Register_User;

public class Test_case_page extends OpenURL {
	@Test
	public void redirect_to_testcase_page() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Test Cases']")).click();
		assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).isDisplayed());
	}

}
