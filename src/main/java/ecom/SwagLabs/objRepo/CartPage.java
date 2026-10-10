
package ecom.SwagLabs.objRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "continue-shopping")
    private WebElement continueS;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItems;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpack;

    public WebElement getContinueS() {
        return continueS;
    }

    public WebElement getCheckout() {
        return checkout;
    }

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public void removeBackpack() {
        removeBackpack.click();
    }
}
