package testngParams;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class login2 {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException, IOException {

		Properties prop = new Properties();

		FileInputStream data = new FileInputStream(
				"/Users/jrexiti/Documents/Github/testNG-maven/src/testngParams/config2.properties");

		prop.load(data);

		Thread.sleep(2000);

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/geckodriver");
			driver = new FirefoxDriver();

		} else {
			System.setProperty("webdriver.msedge.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/msedgedriver");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	@Test
	public void signIn() {
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("logged In");

	}

}
