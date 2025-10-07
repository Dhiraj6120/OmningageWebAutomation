package com.omningage.base;

import com.omningage.factory.DriverFactory;
import com.omningage.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setUp() {
        prop = ConfigReader.initProperties();
        String browser = prop.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
