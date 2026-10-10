
package ecom.SwagLabs.Cart;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;
import ecom.SwagLabs.objRepo.ProductPage;

public class AddProductToCart_Test extends BaseClass {

    @Test(groups = { "FT", "Pos" })
    public void addProductToCart_Test() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ExcelUtility eu = new ExcelUtility();

        lp.login(
            eu.readDataFromExcel("LoginCredentials", 1, 0),
            eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        ProductPage pp = new ProductPage(driver);

        pp.addBackpackToCart();

        Assert.assertEquals(pp.getCartCount().getText(), "1");

        Reporter.log("Product added successfully to the cart", true);
    }
}
