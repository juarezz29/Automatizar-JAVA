package com.tuusuario.automation.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tuusuario.automation.driver.DriverFactory;
import com.tuusuario.automation.pages.InventoryPage;
import com.tuusuario.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class CartSteps {
    private InventoryPage inventoryPage;

    @Given("que inicié sesión como usuario estándar")
    @Step("Iniciar sesión como usuario estándar")
    public void loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(DriverFactory.getDriver());
    }

    @When("agrego la mochila al carrito")
    @Step("Agregar Sauce Labs Backpack al carrito")
    public void addBackpackToCart() {
        inventoryPage.addBackpackToCart();
    }

    @Then("el contador del carrito debería mostrar {string}")
    @Step("Validar contador del carrito: {expectedCount}")
    public void shouldSeeCartCount(String expectedCount) {
        assertEquals(expectedCount, inventoryPage.getCartItemCount());
    }
}
