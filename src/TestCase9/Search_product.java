package TestCase9;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Setup.OpenURL;

public class Search_product extends OpenURL{
	@Test(priority = 0)
	public void redirect_to_product_detail_page_success(){
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='All Products']")).isDisplayed());
	}
	@Test(priority = 1)
	public void search_product_by_name_successfull() throws InterruptedException{
		assertTrue(driver.findElement(By.xpath("//input[@id='search_product']")).isEnabled());
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("blue");
		Thread.sleep(500);
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Thread.sleep(500);
		List<WebElement> name_product_after_search = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']//div[@class='productinfo text-center']//p"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i =0 ;i<name_product_after_search.size();i++) {
			js.executeScript("arguments[0].scrollIntoView(true);",name_product_after_search.get(i));
			Thread.sleep(500);
			String name_product = name_product_after_search.get(i).getText().toLowerCase();
			assertTrue(name_product.contains("blue"));
			
		}
}
}
