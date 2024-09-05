package com.qa.saucelab.stepdefinitions;

import com.qa.saucelab.pages.SauceLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SauceLabLoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);

    @Given("User navigate to the {string}")
    public void user_navigate_to_the(String url) {
        driver.get(url);
    }

    @When("User provides {string} and {string} to Sauce Login Page")
    public void user_provides_and_to_sauce_login_page(String username, String password) {
        sauceLoginPage.login(username, password);
    }

    @Then("User validates the {string} from Sauce Main Page")
    public void user_validates_the_from_sauce_main_page(String title) {
        Assert.assertEquals(title,driver.getTitle());
    }

}
