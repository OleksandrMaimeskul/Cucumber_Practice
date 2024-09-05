package com.qa.weborder.stepDef;

import com.qa.weborder.pages.MainPage;
import com.qa.weborder.pages.OrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

public class OrderPageStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

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
        orderPage.validateOrderInformation(customerName,product,quantity,Street,city,state,zipCode,cardType,cardNumber,expireDate);

    }

}
