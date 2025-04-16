package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    private By inventoryContainer = By.id("inventory_container");
    private By sortDropdown = By.className("product_sort_container");
    private By productNames = By.className("inventory_item_name");
    private By addToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartItemName = By.className("inventory_item_name");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    public void applySortLowToHigh() {
        driver.findElement(sortDropdown).sendKeys("Price (low to high)");
    }

    public List<String> getSortedProductNames() {
        return driver.findElements(productNames)
                     .stream()
                     .map(e -> e.getText())
                     .collect(Collectors.toList());
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }
}
