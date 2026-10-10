package ecom.SwagLabs.Cart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.DataProviderUtility;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.CheckoutPage;
import ecom.SwagLabs.objRepo.LoginPage;

public class EnterCheckoutDetails_Test extends BaseClass {

    @Test(groups = {"FT", "Pos"},
          dataProvider = "checkoutData",
          dataProviderClass = DataProviderUtility.class)
    public void enterCheckoutDetails_Test(String firstName, String lastName, String postalCode) throws Exception {

        LoginPage lp = new LoginPage(driver);
        ExcelUtility eu = new ExcelUtility();

        lp.login(
                eu.readDataFromExcel("LoginCredentials", 1, 0),
                eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(
                driver.getCurrentUrl().contains("cart"),
                true
        );

        driver.findElement(By.id("checkout")).click();

        CheckoutPage cp = new CheckoutPage(driver);

        cp.enterDetails(firstName, lastName, postalCode);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("checkout-step-two"));

        Assert.assertEquals(
                driver.getCurrentUrl().contains("checkout-step-two"),
                true
        );

        Reporter.log("Required checkout details entered successfully", true);
    }
}