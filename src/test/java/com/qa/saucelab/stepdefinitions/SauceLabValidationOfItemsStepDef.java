package com.qa.saucelab.stepdefinitions;

import com.qa.saucelab.pages.SauceLabValidationOfItems;
import com.qa.saucelab.pages.SauceLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SauceLabValidationOfItemsStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SauceLabValidationOfItems sauceLabValidationOfItems = new SauceLabValidationOfItems(driver);

    @Then("User choose each {string} by click-on it")
    public void user_choose_each_by_click_on_it(String item) {
        sauceLabValidationOfItems.checkEachItem(item);
    }

    @Then("User validate of {string}, containt of {string} and {string}")
    public void user_validate_of_containt_of_and(String title, String description, String price) {
        sauceLabValidationOfItems.checkEachItem(title);
        sauceLabValidationOfItems.itemInfo(description, price);
    }

}
