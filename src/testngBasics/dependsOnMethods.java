package testngBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class dependsOnMethods {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");

		Thread.sleep(2000);

		driver.manage().deleteAllCookies();

	}

	@Test
	public void enterEmail() throws InterruptedException {
		
		Assert.fail();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
		Thread.sleep(3000);
	}

	@Test
	public void enterPassword() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = { "enterPassword" })
	public void clickSignIn() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='submit-login']")).click();
	}

}