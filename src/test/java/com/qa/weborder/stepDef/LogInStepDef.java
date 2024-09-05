package com.qa.weborder.stepDef;

import com.qa.weborder.pages.LoginPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LogInStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User use username and password for log in to the website")
    public void user_use_username_and_password_for_log_in_to_the_website() {
        loginPage.loginValidateFunctionality(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
    }

}
