package com.tuusuario.automation.hooks;

import com.tuusuario.automation.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void openBrowser() {
        DriverFactory.startBrowser();
    }

    /** Pausa visual opcional, activada con -DstepDelayMs=1500. */
    @AfterStep
    public void pauseAfterEachStep() {
        long delay = Long.getLong("stepDelayMs", 0L);
        if (delay <= 0) {
            return;
        }

        try {
            Thread.sleep(delay);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    @After
    public void closeBrowserAndAttachEvidence(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot - " + scenario.getName(), "image/png",
                    new ByteArrayInputStream(screenshot), ".png");
        }
        DriverFactory.quitDriver();
    }
}
