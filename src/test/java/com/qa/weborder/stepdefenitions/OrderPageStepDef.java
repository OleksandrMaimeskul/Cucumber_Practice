package com.qa.weborder.stepdefenitions;

import com.qa.weborder.pages.LoginPage;
import com.qa.weborder.pages.MainPage;
import com.qa.weborder.pages.OrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class OrderPageStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("User use username and password for log in to the website")
    public void user_use_username_and_password_for_log_in_to_the_website() {
        loginPage.loginValidateFunctionality(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
    }

    @Given("User choose the order from the left side of Main Page")
    public void user_choose_the_order_from_the_left_side_of_main_page() {
        mainPage.orderButton();
    }

    @Given("User choose {string}, {string}, and push button calculate")
    public void user_choose_and_push_button_calculate(String product, String quantity) {
        orderPage.productValidation(product, quantity);
    }

    @Then("User provide {string},{string},{string},{string} and {string}")
    public void user_provide_and(String customerName, String street, String city, String state, String zipCode) {
        orderPage.addressInformation(customerName, street, city, state, zipCode);
    }

    @Then("User choose {string}, provide {string} and {string} and click process button")
    public void user_choose_provide_and_and_click_process_button(String cardType, String cardNumber, String expireOfCard) {
        orderPage.paymentInformation(cardType, cardNumber, expireOfCard);
        orderPage.setProcessButton();
    }

    @Then("User validate {string}")
    public void user_validate(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedMessage, orderPage.message());
    }

    @Then("User validate all the information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validate_all_the_information(String customerName, String product, String quantity, String Street, String city, String state, String zipCode, String cardType, String cardNumber, String expireDate) {
        mainPage.setAllOrdersButton();
        orderPage.validateOrderInformation(customerName, product, quantity, Street, city, state, zipCode, cardType, cardNumber, expireDate);

    }


    @When("User choose and push button calculate")
    public void user_choose_and_push_button_calculate(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> productInfo = dataTable.asMap();
        System.out.println(productInfo);
        orderPage.productValidation(productInfo.get("productName"), productInfo.get("quantity"));
    }

    @Then("User provide the adress information")
    public void user_provide_the_adress_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> adressInfo = dataTable.asMap();
        orderPage.addressInformation(adressInfo.get("customerName"), adressInfo.get("Street"),
                adressInfo.get("city"), adressInfo.get("state"), adressInfo.get("zipCode"));
    }

    @Then("User choose")
    public void user_choose(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> userChoose = dataTable.asMap();
        orderPage.paymentInformation(userChoose.get("cardType"), userChoose.get("cardNumber"),
                userChoose.get("expireDate"));
        orderPage.setProcessButton();
    }

    @Then("User validate")
    public void user_validate(io.cucumber.datatable.DataTable dataTable) {
        List<String> message = dataTable.asList();
        Assert.assertEquals(message.getFirst(), orderPage.message());
    }


}
