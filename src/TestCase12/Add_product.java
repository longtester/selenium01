package TestCase12;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Add_product extends OpenURL {
	@Test(priority = 0)
	public void redirect_product_page() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='All Products']")).isDisplayed());
	}
	@Test(priority = 1)
	public void add_product_successfull() throws InterruptedException{
		Actions action = new Actions(driver);
		WebElement first_product = driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][1]"));
		action.moveToElement(first_product).build().perform();
		driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][1]//a[@class='btn btn-default add-to-cart']")).click();
		assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Your product has been added to cart.']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//p[normalize-space()='Your product has been added to cart.']")).getText(),"Your product has been added to cart.");
		driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
		WebElement second_product = driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][2]"));
		action.moveToElement(second_product).build().perform();
		driver.findElement(By.xpath("//div[@class='features_items']//div[@class='col-sm-4'][2]//a[@class='btn btn-default add-to-cart']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
		List<WebElement> product_list = driver.findElements(By.xpath("//tbody/tr"));
		assertEquals(product_list.size(),2);// Check shopping cart should include 2 products
	}
}
