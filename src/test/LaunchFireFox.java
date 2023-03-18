package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();

	}

}