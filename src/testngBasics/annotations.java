package testngBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class annotations {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https:www.google.com");
		Thread.sleep(2000);

	}

	@AfterSuite
	public void end() {

		driver.close();
		driver.quit();
	}

}