package com.qa.techtorial.stepdefenitions;

import com.qa.techtorial.pages.TechtorialLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class TechtorialLoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    TechtorialLoginPage techtorialLoginPage = new TechtorialLoginPage(driver);

    @Given("User validate the title is {string} from Login Page")
    public void user_validate_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    @Given("User validate the log in is visible on the page")
    public void user_validate_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(techtorialLoginPage.validateHEader());
    }

    @When("User provides username and password to the Sign In Box")
    public void user_provides_username_and_password_to_the_sign_in_box() {
        techtorialLoginPage.login(ConfigReader.readProperty("tech_username"),
                ConfigReader.readProperty("tech_password"));
    }

    @Then("User validates the title is {string} from Main Page")
    public void user_validates_the_title_is_from_main_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

}
