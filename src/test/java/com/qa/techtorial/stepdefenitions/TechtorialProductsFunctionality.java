package com.qa.techtorial.stepdefenitions;

import com.qa.techtorial.pages.TechtorialLoginPage;
import com.qa.techtorial.pages.TechtorialProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

public class TechtorialProductsFunctionality {
    WebDriver driver = DriverHelper.getDriver();
    TechtorialProductsPage products = new TechtorialProductsPage(driver);

    @Given("User clicks Products buton on the left side and AddProduct Button from Product Page")
    public void user_clicks_products_buton_on_the_left_side_and_add_product_button_from_product_page() {
        products.setProductsButton();
        products.setAddProductButton();
    }

    @When("User provides {string} and {string} to the product details box")
    public void user_provides_and_to_the_product_details_box(String name, String price) {
        products.addProducts(name, price);
    }

    @When("User selects {string}, {string} and {string} from drop downs")
    public void user_selects_and_from_drop_downs(String productCategory, String productSubCategory, String tax) {
        products.chooseCategory(productCategory, productSubCategory, tax);
    }

    @When("User clicks purchase check box and add {string} into the description")
    public void user_clicks_purchase_check_box_and_add_into_the_description(String description) {
        products.setClientCanPurchase();
        products.description(description);
        products.saveButton(driver);
    }

    @Then("User validates products details {string}, {string}, {string} from table")
    public void user_validates_products_details_from_table(String productName, String price, String status) {
        products.validateProductInfo(productName, price, status);
    }

    @When("User clicks Products button")
    public void user_clicks_products_button() {
        products.setProductsButton();
    }

    @Given("User choose from product category {string}")
    public void user_choose_from_product_category(String productCategoryTitle) {
        products.productCategoryOnTheTop(productCategoryTitle);
    }

    @Given("User choose from sub product category {string}")
    public void user_choose_from_sub_product_category(String subCategoryTitle) {
        products.subProductCategoryOnTheTop(subCategoryTitle);
    }

    @Given("User choose 1st 3dots button and view button")
    public void user_choose_1st_3dots_button_and_view_button() {
        products.clickThreeDotsAnDViews();
    }
    
    @Then("User validates the ProductCategory with title {string}")
    public void user_validates_the_product_category_with_title(String expectedProductSCategory) {
        products.validateCategoriesFilter(expectedProductSCategory);
    }

}
