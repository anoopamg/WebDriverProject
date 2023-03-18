package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Step 1: Launch chrome browser and navigate to Simplilearn website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		//Step 2: Maximize the window
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("Simplilearn | Online Courses - Bootcamp & Certification Platform")) {
			System.out.println("Successfully navigated to Simplilearn page ");
		}
		else {
			System.out.println("Navigation to Simplilearn page failed ");
		}		
		
		//Step 3: Click on Login
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		String loginTitle = driver.getTitle();
		if(loginTitle.contains("Learning on Simplilearn")) {
			System.out.println("Successfully navigated to Login page ");
		}
		else {
			System.out.println("Navigation to Login page failed ");
		}
		

		//Step 4: Get the count of links
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		int Count = allLinks.size();
		System.out.println("Count :" +Count); 
		for(WebElement elem:allLinks) {
			String href = elem.getAttribute("href");
			System.out.println(href);
		}
		
		//Step 5: Enter User name
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("anoopa.mg@gmail.com");
		
		//Step 6: Enter Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abcd1234s");
		
		//Step 7: Click on Remember Me
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		//Step 8: Click Login button
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
		Thread.sleep(3000);
		
		//Step 9: Validate if login was successful
		String errorMsg = "The email or password you have entered is invalid.";
		WebElement error = driver.findElement(By.className("error_msg"));
		if(error.isEnabled() && error.getText().equals(errorMsg)) {
			System.out.println(error.getText());
			System.out.println("Login Failed");
		}
		
		//Step 10: Re-enter the password
		password = driver.findElement(By.id("password"));
		password.sendKeys("Autolearn@12");
		loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
		Thread.sleep(10000);
		
		//Step 11: Validate if login was successful
		String url = driver.getCurrentUrl();
		if(url.contains("https://lms.simplilearn.com/dashboard")) {
			System.out.println("Login Successful and navigated to "+url);
		}
		else {
			System.out.println("Login Failed");
		}
				
		//Step 12: Logout from the session
		WebElement profile = driver.findElement(By.className("profile-img"));
		profile.click();
		System.out.println("Profile button clicked");
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.click();
		System.out.println("Logout link clicked");		
		
		//Step 13: Close the browser
		driver.close();

	}

}
