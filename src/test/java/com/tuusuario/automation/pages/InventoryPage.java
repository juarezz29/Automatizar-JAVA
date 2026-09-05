package com.tuusuario.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private static final By TITLE = By.cssSelector(".title");
    private static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    private static final By BACKPACK_ADD_BUTTON = By.id("add-to-cart-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return textOf(TITLE);
    }

    public void addBackpackToCart() {
        click(BACKPACK_ADD_BUTTON);
    }

    public String getCartItemCount() {
        return textOf(CART_BADGE);
    }
}
