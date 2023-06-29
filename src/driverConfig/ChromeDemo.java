package driverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
        System.setProperty("webdriver.chrome.driver", "/Users/jrexiti/Desktop/Resources/drivers_v1/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();;
        driver.get("https:www.google.com");
        Thread.sleep(3000);
        driver.quit();
		
	}

}
