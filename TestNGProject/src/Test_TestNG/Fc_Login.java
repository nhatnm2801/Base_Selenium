package Test_TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Container;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Fc_Login extends Init{

	@Test(priority=1)
	public void leave_blank() throws Exception  {
		driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);

		WebElement btn_Login = driver.findElement(By.xpath("//input[@value='Login']"));
		btn_Login.click();
		WebElement msgWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		//so sánh bằng
		assertEquals(msgWarning.getText().trim().toString(), "Warning: No match for E-Mail Address and/or Password.") ;

		Thread.sleep(2000);
	}

	@Test(priority=2)
	public void Incorrect_Email() throws Exception {
		driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);
		WebElement tb_Email = driver.findElement(By.xpath("//input[@id='input-email']"));
		tb_Email.sendKeys("miniunpoo");
		WebElement tb_Password = driver.findElement(By.xpath("//input[@id='input-password']"));
		tb_Password.sendKeys("123456");
		WebElement btn_Login = driver.findElement(By.xpath("//input[@value='Login']"));
		btn_Login.click();
		WebElement msgWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		assertEquals(msgWarning.getText().trim().toString(), "Warning: No match for E-Mail Address and/or Password.");

		Thread.sleep(2000);
	}

	@Test(priority=3)
	public void Incorrect_Pass() throws Exception {
		driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);
		WebElement tb_Email = driver.findElement(By.xpath("//input[@id='input-email']"));
		tb_Email.sendKeys("miniunpoo098@gmail.com");
		WebElement tb_Password = driver.findElement(By.xpath("//input[@id='input-password']"));
		tb_Password.sendKeys("1234567");
		WebElement btn_Login = driver.findElement(By.xpath("//input[@value='Login']"));
		btn_Login.click();
		WebElement msgWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		assertEquals(msgWarning.getText().trim().toString(), "Warning: No match for E-Mail Address and/or Password.");
		
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void Login_Success() throws Exception {
		driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);
		WebElement tb_Email = driver.findElement(By.xpath("//input[@id='input-email']"));
		tb_Email.sendKeys("miniunpoo098@gmail.com");
		WebElement tb_Password = driver.findElement(By.xpath("//input[@id='input-password']"));
		tb_Password.sendKeys("123456");
		WebElement btn_Login = driver.findElement(By.xpath("//input[@value='Login']"));
		btn_Login.click();
		WebElement verify_MyAccount = driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
		//tương tự isDisplayed()
		assertTrue(verify_MyAccount.isDisplayed());

	}
}
