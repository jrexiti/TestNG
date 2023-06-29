package testngParams;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class BasePage {

	public static WebDriver driver;
	
	private String url;

	public WebDriver getDriver() throws InterruptedException, IOException {
		Properties prop = new Properties();

		FileInputStream data = new FileInputStream(
				"/Users/jrexiti/Documents/Github/testNG-maven/src/testngParams/config3.properties");

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

		return driver;

	}
	
	public String getUrl() throws IOException {
		Properties prop = new Properties();

		FileInputStream data = new FileInputStream(
				"/Users/jrexiti/Documents/Github/testNG-maven/src/testngParams/config3.properties");

		prop.load(data);
		url = prop.getProperty("url");
		
		return url;
	}
	
    public static void takeScreenShots(WebDriver webdriver) throws IOException {
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

        File destFile = new File("/Users/jrexiti/Desktop/Resources/Images/" + timeStamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);
    }

    public static String timeStamp() {

        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

}
