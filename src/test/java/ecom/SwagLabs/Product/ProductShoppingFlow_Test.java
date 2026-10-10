
package ecom.SwagLabs.Product;

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

public class ProductShoppingFlow_Test extends BaseClass {

    @Test(groups = {"ST", "Pos"})
    public void productShoppingFlow_Test() throws Exception {

        ExcelUtility eu = new ExcelUtility();
        LoginPage lp = new LoginPage(driver);

        lp.login(
                eu.readDataFromExcel("LoginCredentials", 1, 0),
                eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Verify product page
        By productTitle = By.className("title");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productTitle));

        Assert.assertEquals(
                driver.findElement(productTitle).getText(),
                "Products");

        Reporter.log("PASS: Product page is displayed", true);

        // Add backpack to cart
        By addToCart =
                By.id("add-to-cart-sauce-labs-backpack");

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCart)).click();

        // Verify cart badge
        By cartCount = By.className("shopping_cart_badge");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartCount));

        Assert.assertEquals(
                driver.findElement(cartCount).getText(),
                "1");

        Reporter.log("PASS: Product added to cart", true);

        // Open cart
        By cartLink = By.className("shopping_cart_link");

        wait.until(
                ExpectedConditions.elementToBeClickable(cartLink)).click();

        // Verify product in cart
        By productName =
                By.className("inventory_item_name");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName));

        Assert.assertEquals(
                driver.findElement(productName).getText(),
                "Sauce Labs Backpack");

        Reporter.log("PASS: Correct product is displayed in cart", true);
    }
}
