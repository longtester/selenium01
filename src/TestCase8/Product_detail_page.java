package TestCase8;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Product_detail_page extends OpenURL {
	@Test(priority = 0)
	public void redirect_to_product_detail_page_success() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='All Products']")).isDisplayed());
		List<WebElement> product_list = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0;i<product_list.size();i++) {
			js.executeScript("arguments[0].scrollIntoView(true);",product_list.get(i));
			Thread.sleep(500);
			assertTrue(product_list.get(i).isDisplayed());
		}
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][1]")));
		Thread.sleep(500);
		String actual_price = driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][1]//h2")).getText();
		driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][1]//a[@style='color: brown;']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).isDisplayed());
		String expected_price = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).getText();
		assertEquals(expected_price,actual_price);
	}
}
