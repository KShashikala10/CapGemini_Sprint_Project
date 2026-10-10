package ecom.SwagLabs.Product;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;

public class UnauthorizedProductAccess_Test extends BaseClass {

    @Test(groups = {"FT", "Nev"})
    public void unauthorizedProductAccess_Test() throws Exception {

        driver.get("https://www.saucedemo.com/inventory.html");

        Assert.assertEquals(
                driver.findElement(By.id("login-button")).isDisplayed(),
                true
        );

        Reporter.log("Unauthorized user cannot access the product catalog", true);
    }
}