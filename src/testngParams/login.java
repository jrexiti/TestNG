package testngParams;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class login {
	

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

	}

	@Test
	public void signIn() {
		driver.get("http://www.teststore.automationtesting.co.uk/");
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("logged In");

	}

}
