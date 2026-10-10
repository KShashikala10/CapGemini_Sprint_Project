
package ecom.SwagLabs.objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class ProductPage {

	private WebDriver driver;

	public ProductPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
    

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartCount;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;

    public WebElement getProductsTitle() {
        return driver.findElement(By.className("title"));
    }

    public void addBackpackToCart() {
        addToCartButton.click();
    }

    public void openCart() {
        cartIcon.click();
    }

    public WebElement getCartCount() {
        return cartCount;
    }

    public void removeBackpackFromCart() {
        removeButton.click();
    }
}
