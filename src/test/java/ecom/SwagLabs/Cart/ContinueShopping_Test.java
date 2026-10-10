
package ecom.SwagLabs.Cart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;
import ecom.SwagLabs.objRepo.ProductPage;
import ecom.SwagLabs.objRepo.CartPage;

public class ContinueShopping_Test extends BaseClass {

	@Test(groups = { "FT", "Pos" })
	public void continueShopping_Test() throws Exception {

	    LoginPage lp = new LoginPage(driver);
	    ExcelUtility eu = new ExcelUtility();

	    lp.login(
	        eu.readDataFromExcel("LoginCredentials", 1, 0),
	        eu.readDataFromExcel("LoginCredentials", 1, 1)
	    );

	    ProductPage pp = new ProductPage(driver);
	    pp.addBackpackToCart();
	    pp.openCart();

	    CartPage cp = new CartPage(driver);
	    cp.getContinueS().click();

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.className("title")
	        )
	    );

	    Assert.assertEquals(
	        driver.findElement(By.className("title")).getText(),
	        "Products"
	    );

	    Reporter.log("Continue Shopping navigated to Products page", true);
	}
}