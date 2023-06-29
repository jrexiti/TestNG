package testngBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterization {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

	}

	@Parameters({ "email", "password" })
	@Test
	public void signIn(String email, String password) {
		driver.get("http://www.teststore.automationtesting.co.uk/");
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("logged In");

	}

	@Test
	public void test() {
		driver.findElement(By.linkText("CLOTHES")).click();

	}

	@AfterMethod
	public void signOut() {
		driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
		System.out.println("logged In");

	}

	@AfterSuite
	public void end() {

		driver.close();
		driver.quit();
	}

}