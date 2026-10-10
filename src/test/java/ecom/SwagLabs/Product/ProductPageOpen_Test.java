
package ecom.SwagLabs.Product;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;

public class ProductPageOpen_Test extends BaseClass {

    @Test(groups = {"SmT", "Pos"})
    public void productPageOpen_Test() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ExcelUtility eu = new ExcelUtility();

        lp.login(
            eu.readDataFromExcel("LoginCredentials", 1, 0),
            eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        Assert.assertEquals(
            driver.findElement(By.className("title")).getText(),
            "Products"
        );

        Reporter.log("Product page opened successfully", true);
    }
}
