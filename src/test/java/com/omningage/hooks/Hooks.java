package com.omningage.hooks;

import com.omningage.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void launchBrowser() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://sit.omningage-vmo2.cloud/#/");
    }

    @After
    public void closeBrowser() {
        DriverFactory.quitDriver();
    }
}
