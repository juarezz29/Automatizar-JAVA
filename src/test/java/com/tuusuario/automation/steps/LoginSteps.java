package com.tuusuario.automation.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tuusuario.automation.driver.DriverFactory;
import com.tuusuario.automation.pages.InventoryPage;
import com.tuusuario.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class LoginSteps {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("que ingreso a la página de login")
    @Step("Abrir la página de login")
    public void openLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
    }

    @When("inicio sesión con el usuario {string} y contraseña {string}")
    @Step("Iniciar sesión con el usuario {username}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("debería visualizar el catálogo de productos")
    @Step("Validar que el catálogo esté disponible")
    public void shouldSeeInventory() {
        inventoryPage = new InventoryPage(DriverFactory.getDriver());
        assertEquals("Products", inventoryPage.getTitle());
    }

    @Then("debería visualizar un mensaje de error que contenga {string}")
    @Step("Validar mensaje de error")
    public void shouldSeeError(String expectedMessage) {
        assertTrue(loginPage.getErrorMessage().contains(expectedMessage));
    }
}
