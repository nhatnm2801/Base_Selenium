package Test_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.neilalexander.jnacl.crypto.verify_16;

public class Fc_Register extends Init {
	@Test(priority=1)
	public void leave_blank() throws Exception  {
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(2000);
		
		WebElement page_Register =driver.findElement(By.xpath("//h1[normalize-space()='Register Account']"));
		assertEquals(page_Register.getText(),"Register Account");
		WebElement txt_Firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		txt_Firstname.sendKeys("Ngo");
		WebElement txt_Lasttname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		txt_Lasttname.sendKeys("Nhat");
		WebElement txt_Email = driver.findElement(By.xpath("//input[@id='input-email']"));
		txt_Email.sendKeys("miniunpoo123098@gmail.com");
		WebElement txt_Phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		txt_Phone.sendKeys("12345678");
		WebElement txt_Pass = driver.findElement(By.xpath("//input[@id='input-password']"));
		txt_Pass.sendKeys("123456");
		WebElement txt_PassConfi = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		txt_PassConfi.sendKeys("123456");
		
		WebElement rdb_Subscribe = driver.findElement(By.xpath("//label[normalize-space()='Yes']"));
		assertTrue(rdb_Subscribe.isSelected()==false);
		rdb_Subscribe.click();
		
		WebElement cbx_Agree = driver.findElement(By.xpath("//input[@name='agree']"));
		assertTrue(cbx_Agree.isSelected()==false);
		cbx_Agree.click();
		
		WebElement btn_Continue = driver.findElement(By.xpath("//input[@value='Continue']"));
		btn_Continue.click();
		
		
		WebElement veri_success = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
		assertEquals(veri_success.getText(), "Your Account Has Been Created!");
		Thread.sleep(2000);
	}
}
