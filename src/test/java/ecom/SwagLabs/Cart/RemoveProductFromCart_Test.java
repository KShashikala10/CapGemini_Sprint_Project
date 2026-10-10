
package ecom.SwagLabs.Cart;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;
import ecom.SwagLabs.objRepo.ProductPage;
import ecom.SwagLabs.objRepo.CartPage;

public class RemoveProductFromCart_Test extends BaseClass {

    @Test(groups = { "FT", "Pos" })
    public void removeProductFromCart_Test() throws Exception {

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
        cp.removeBackpack();

        Assert.assertEquals(cp.getCartItems().size(), 0);

        Reporter.log("Product removed successfully from the cart", true);
    }
}
