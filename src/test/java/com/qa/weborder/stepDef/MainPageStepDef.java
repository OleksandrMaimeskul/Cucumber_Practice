package com.qa.weborder.stepDef;

import com.qa.weborder.pages.LoginPage;
import com.qa.weborder.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class MainPageStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    @Given("User choose the order from the left side of Main Page")
    public void user_choose_the_order_from_the_left_side_of_main_page() {
        mainPage.orderButton();
    }
}
