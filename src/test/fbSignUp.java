package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fbSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//1. Launch face book
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//2. Maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		String gender1 = "Male";
		String gender2 = "Custom";
		
		//3. Click on Create New Account
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();
		
		//4. Enter details
		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		fName.sendKeys("Mickey");
		
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lName.sendKeys("Mouse");
		
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mobile.sendKeys("+1 321 323231134");
		
		WebElement password = driver.findElement(By.xpath("//input[@data-type='password']"));
		password.sendKeys("ABCD123s3$%");
		
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		//date.sendKeys("27");
		WebElement defaultDate = driver.findElement(By.xpath("//select[@name='birthday_day']/option[@selected='1']"));
		System.out.println("Default date : "+defaultDate.getText());
		Select ddDate = new Select(date);
		ddDate.selectByValue("7");		
		
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		//month.sendKeys("November");
		Select ddMonth = new Select(month);
		ddMonth.selectByVisibleText("Nov");
		
		//Print all months
		List<WebElement> elems = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		for(WebElement item:elems) {
			System.out.println(item.getText());
		}
		
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		year.sendKeys("2000");	
		
		//Print all years
		List<WebElement> yy = driver.findElements(By.xpath("//select[@name='birthday_year']/option"));
		for(WebElement item:yy) {
			System.out.print(item.getText()+",");
		}

		WebElement gender = driver.findElement(By.xpath("//label[text()='"+gender1+"']/following-sibling::input"));
		gender.click();
		Thread.sleep(5000);
		
		String dummyXpath = "//label[text()='placeholder']/following-sibling::input";
		String newXpath = dummyXpath.replace("placeholder",gender2);
		WebElement wb = driver.findElement(By.xpath(newXpath));
		wb.click();

		WebElement signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUpBtn.click();

	}

}
