package com.selenium.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class SampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void runChrome() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WINDOWS);
		URL url=new URL("http://192.168.10.48:4444/wd/hub");
		WebDriver driver=new RemoteWebDriver(url, cap);
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		Assertions.assertEquals("Google",title);
                Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void login() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WINDOWS);
		URL url=new URL("http://192.168.10.48:4444/wd/hub");
		WebDriver driver=new RemoteWebDriver(url, cap);
		driver.manage().window().maximize();		
		driver.get("http://192.168.10.17:8085/login.php");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement login=driver.findElement(By.name("Login"));
		username.sendKeys("admin");
		password.sendKeys("password");
		Thread.sleep(1000);
		login.click();
		String actualUrl="http://192.168.10.17:8085/index.php";
		String expectedUrl= driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrl,actualUrl);
		driver.close();
	}
}
