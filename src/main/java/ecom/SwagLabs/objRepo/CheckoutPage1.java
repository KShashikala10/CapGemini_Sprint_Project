package ecom.SwagLabs.objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage1 {
    public CheckoutPage1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "inventory_item_price")
    private WebElement productPrice;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    @FindBy(id = "finish")
    private WebElement finish;

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getFinish() {
        return finish;
    }
}