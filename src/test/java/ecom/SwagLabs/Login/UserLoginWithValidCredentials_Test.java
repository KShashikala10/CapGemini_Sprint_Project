package ecom.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.DataProviderUtility;
import ecom.SwagLabs.objRepo.LoginPage;

public class UserLoginWithValidCredentials_Test extends BaseClass {

    @Test(groups = {"SmT","Pos"}, dataProvider = "loginData",
            dataProviderClass = DataProviderUtility.class)
    public void userLoginWithValidCredentials_Test(String username, String password) throws Exception {

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);

        Assert.assertEquals(
                driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed(),
                true
        );

        Reporter.log("User logged in successfully with valid credentials", true);
    }
}