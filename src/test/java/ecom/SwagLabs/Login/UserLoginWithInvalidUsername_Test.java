package ecom.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.DataProviderUtility;
import ecom.SwagLabs.objRepo.LoginPage;

public class UserLoginWithInvalidUsername_Test extends BaseClass {

    @Test(groups = {"FT", "Nev"}, dataProvider = "invalidLoginData",
            dataProviderClass = DataProviderUtility.class)
    public void userLoginWithInvalidUsername_Test(String username, String password) throws Exception {

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);

        Assert.assertEquals(
                driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed(),
                true
        );

        Reporter.log("User didn't logged in with invalid credentials", true);
    }
}