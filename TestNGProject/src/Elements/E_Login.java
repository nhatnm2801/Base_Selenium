package Elements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Test_TestNG.Init;

public class E_Login  extends Init{
	@Test(priority=1)
	public void leave_blank() throws Exception  {
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(2000);

		WebElement btn_Login = driver.findElement(By.xpath("//input[@value='Login']"));
		btn_Login.click();
		WebElement msgWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		//so sánh bằng
		assertEquals(msgWarning.getText().trim().toString(), "Warning: No match for E-Mail Address and/or Password.") ;

		Thread.sleep(2000);
	}
}

