package com.qa.techtorial.stepdefenitions;

import com.qa.techtorial.pages.TechtorialLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class TechtorialNegativeLoginFunctionality {
    WebDriver driver = DriverHelper.getDriver();
    TechtorialLoginPage techtorialLoginPage = new TechtorialLoginPage(driver);

    @Given("User validate {string} title")
    public void user_validate_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    @When("User entered incorrect email and password")
    public void user_entered_incorrect_email_and_password() {
        techtorialLoginPage.login("abrakadabra@gmail.com", "secret_sauce");
    }

    @Then("User validate the text {string}")
    public void user_validate_the_text(String expectedText) {
        Assert.assertEquals(expectedText, techtorialLoginPage.negativeFeedback());
    }
    String expectedColor = "rgba(211, 0, 0, 1)";
    @Then("that color of text is red from Sign in Page")
    public void that_color_of_text_is_red_from_sign_in_page() {
        Assert.assertEquals(expectedColor,techtorialLoginPage.negativeFeedbackColor());
    }
}
