package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollMethod {
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			WebElement scrollTo = driver.findElement(By.xpath("//h2[text()='HTML Exercises']"));
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			obj.executeScript("arguments[0].scrollIntoView();", scrollTo);
			
			obj.executeScript("window.scrollTo(0,scrollToHeight", 0);

	}

}
