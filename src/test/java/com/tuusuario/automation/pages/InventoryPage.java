package com.tuusuario.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private static final By TITLE = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return textOf(TITLE);
    }
}
