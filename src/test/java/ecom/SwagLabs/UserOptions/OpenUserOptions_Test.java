package ecom.SwagLabs.UserOptions;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.HomePage;
import ecom.SwagLabs.objRepo.LoginPage;

public class OpenUserOptions_Test extends BaseClass {

    @Test(groups = {"SmT", "Pos"})
    public void openUserOptions_Test() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ExcelUtility eu = new ExcelUtility();

        lp.login(
                eu.readDataFromExcel("LoginCredentials", 1, 0),
                eu.readDataFromExcel("LoginCredentials", 1, 1)
        );

        HomePage hp = new HomePage(driver);

        hp.getHamburger().click();

        Assert.assertEquals(
                hp.getAllItems().isDisplayed(),
                true
        );

        Reporter.log("User options menu opened successfully", true);
    }
}
