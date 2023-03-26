package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		// 1. Launch face book
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// 2. Maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		TakesScreenshot tsObj = (TakesScreenshot)driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		String folder="src/Screenshots";
		File screenshot = new File(folder+"/fbScreen.png");
		
		FileUtils.copyFile(fileObj, screenshot);
	}

}
