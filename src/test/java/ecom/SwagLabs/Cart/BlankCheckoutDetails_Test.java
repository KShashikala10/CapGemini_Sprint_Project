package ecom.SwagLabs.Cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;

public class BlankCheckoutDetails_Test extends BaseClass {

	@Test(groups = { "FT", "Nev" })
	public void blankCheckoutDetails_Test() throws Exception {

		LoginPage lp = new LoginPage(driver);
		ExcelUtility eu = new ExcelUtility();

		lp.login(eu.readDataFromExcel("LoginCredentials", 1, 0), eu.readDataFromExcel("LoginCredentials", 1, 1));

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		driver.findElement(By.className("shopping_cart_link")).click();

		driver.findElement(By.id("checkout")).click();

		driver.findElement(By.id("continue")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed(), true);

		Reporter.log("Purchase cannot continue with blank checkout details", true);
	}
}