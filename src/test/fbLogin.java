package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fbLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//1. Launch face book
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//2. Maximize
		driver.manage().window().maximize();
		
		//3. Validate navigation
		if(driver.getCurrentUrl().equals("https://www.facebook.com/")) {
			System.out.println("Navigated to fb home page");
		}
		else {
			System.out.println("Navigation unsuccessful");
		}
		Thread.sleep(6000);
		
		//4. Enter User name
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("12tryitout@gmail.com");
		
		//5. Enter Password
		WebElement pswd = driver.findElement(By.id("pass"));
		pswd.sendKeys("Samplepswd@12");
		
		//6. Click Login Button
		WebElement login = driver.findElement(By.name("login"));
		login.click();		
		
		//7. Get the error if present
		Thread.sleep(6000);
		WebElement error = driver.findElement(By.className("_9ay7"));
		String msg = "The email address you entered isn't connected to an account. Find your account and log in.";
		if(error.isDisplayed() && error.getText().equals(msg)) {
			System.out.println(error.getText());
		}
		else {
			System.out.println("No error");
		}
		driver.close();

	}

}
