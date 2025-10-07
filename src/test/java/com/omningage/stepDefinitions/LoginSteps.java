package com.omningage.stepDefinitions;

import com.omningage.factory.DriverFactory;
import com.omningage.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
//        driver.get("https://demo.opencart.com/index.php?route=account/login");
        loginPage = new LoginPage(driver); // ✅ PageFactory initialized here
    }

    @When("user clicks on login button")
    public void user_enters_valid_email_and_password() {
        loginPage.enterEmail("test@demo.com");
        loginPage.enterPassword("test123");
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLogoutDisplayed(), "Login failed or Logout link not visible.");
    }
}
