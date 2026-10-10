package ecom.SwagLabs.Cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.DataProviderUtility;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.CheckoutPage;
import ecom.SwagLabs.objRepo.CheckoutPage2;
import ecom.SwagLabs.objRepo.LoginPage;

public class OrderConfirmation_Test extends BaseClass {

    @Test(groups = {"ST", "Pos"},
          dataProvider = "checkoutData",
          dataProviderClass = DataProviderUtility.class)
    public void orderConfirmation_Test(String firstName, String lastName, String postalCode) throws Exception {

        LoginPage lp = new LoginPage(driver);
        ExcelUtility eu = new ExcelUtility();

        lp.login(
                eu.readDataFromExcel("LoginCredentials", 1, 0),
                eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        CheckoutPage cp = new CheckoutPage(driver);

        cp.enterDetails(firstName, lastName, postalCode);

        driver.findElement(By.id("finish")).click();

        CheckoutPage2 cp2 = new CheckoutPage2(driver);

        Assert.assertEquals(
                cp2.getOrderMessage().isDisplayed(),
                true
        );

        Reporter.log(
                "Order placed successfully and confirmation message is displayed",
                true
        );
    }
}