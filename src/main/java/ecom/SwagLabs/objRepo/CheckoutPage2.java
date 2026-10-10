package ecom.SwagLabs.objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage2 {
    public CheckoutPage2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    private WebElement orderMessage;

    public WebElement getOrderMessage() {
        return orderMessage;
    }
}