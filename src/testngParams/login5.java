package testngParams;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class login5 extends BasePage {

	@Test
	public void signIn() throws InterruptedException, IOException {
		
		driver = getDriver();
		driver.get(getUrl());
		
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		takeScreenShots(driver);

	}

}
