package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    private By checkoutButton = By.className("checkout_button");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.className("cart_button");
    private By finishButton = By.className("cart_button");
    private By confirmationText = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void fillCheckoutForm(String first, String last, String zip) {
        driver.findElement(firstNameField).sendKeys(first);
        driver.findElement(lastNameField).sendKeys(last);
        driver.findElement(postalCodeField).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationText).getText();
    }
}
