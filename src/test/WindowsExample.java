package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();

		WebElement newTab = driver.findElement(By.id("tabButton"));

		String ParentWin = driver.getWindowHandle();
		System.out.println("Parent win is " + ParentWin);

		newTab.click();

		Set<String> AllWin = driver.getWindowHandles();
		String childWin = "";

		for (String win : AllWin) {

			System.out.println("The win ID is " + win);

			if (!win.equals(ParentWin)) {

				childWin = win;
			}
		}

		System.out.println("Child win is " + childWin);

		driver.switchTo().window(childWin);

		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());

		driver.close();
		driver.switchTo().window(ParentWin);	
		
		//Click NewWindow button in the parent page
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();
		AllWin = driver.getWindowHandles();

		for (String win : AllWin) {

			System.out.println("The win ID is " + win);

			if (!win.equals(ParentWin)) {

				childWin = win;
			}
		}

		System.out.println("Child win is " + childWin);

		driver.switchTo().window(childWin);

		WebElement childHeader1 = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in new child window is " + childHeader1.getText());

		driver.close();
		driver.switchTo().window(ParentWin);	
		
		driver.quit();

	}

}
