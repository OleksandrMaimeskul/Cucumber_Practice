package com.qa.techtorial.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class TechtorialProductsPage {
    public TechtorialProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='sidebar-menu ']//span[.='Products']")
    WebElement productsButton;
    @FindBy(xpath = "//a[@class='btn btn-primary rounded f-14 p-2 mr-3 openRightModal float-left']")
    WebElement addProductButton;

    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#price")
    WebElement price;

    @FindBy(xpath = "//select[@id='product_category_id']")
    WebElement productCategory;
    @FindBy(xpath = "//select[@id='sub_category_id']")
    WebElement productSubCategory;
    @FindBy(xpath = "//select[@id='tax_id']")
    WebElement tax;
    @FindBy(css = "#purchase_allow")
    WebElement clientCanPurchase;
    @FindBy(css = "#description-text")
    WebElement descriptionBox;

    @FindBy(xpath = "//button[@id='save-product']")
    WebElement saveButton;
    @FindBy(xpath = "//tr[1]//td")
    List<WebElement> productInfo;
    @FindBy(xpath = "//select[@id='category_id']")
    WebElement productCategoryOnTop;
    @FindBy(xpath = "//select[@id='sub_category']")
    WebElement productSubCategoryOnTheTop;
    @FindBy(xpath = "//a[@class='task_view_more d-flex align-items-center justify-content-center dropdown-toggle']")
    List<WebElement> allThreeDotsButton;
    @FindBy(xpath = "//a[.='View']")
    List<WebElement> viewButton;
    @FindBy(xpath = "//p[.='Product Category']//following-sibling::p")
    WebElement productCategoryDescr;
//    @FindBy(xpath = "//p[.='Product Sub Category']//following-sibling::p")
//    WebElement productSubCategoryDesc;

    public void setProductsButton() {
        productsButton.click();
    }

    public void setAddProductButton() {
        addProductButton.click();
    }

    public void addProducts(String name, String price) {
        this.name.sendKeys(name);
        this.price.clear();
        this.price.sendKeys(price);

    }

    public void chooseCategory(String productCategory,
                               String productSubCategory, String tax) {
        BrowserUtils.selectBy(this.productCategory, productCategory, "text");
        BrowserUtils.selectBy(this.productSubCategory, productSubCategory, "text");
        BrowserUtils.selectBy(this.tax, tax, "value");
    }

    public void setClientCanPurchase() {
        clientCanPurchase.click();
    }

    public void description(String description) {
        this.descriptionBox.sendKeys(description);
    }

    public void saveButton(WebDriver driver) {
        BrowserUtils.scrollWithJS(driver, saveButton);
        saveButton.click();
    }

    public void validateProductInfo(String productName, String price, String status) {
        List<String> expectedProductInfo = Arrays.asList(productName, price, status);
        for (int i = 3; i < productInfo.size() - 1; i++) {
            Assert.assertEquals(expectedProductInfo.get(i - 3), BrowserUtils.getText(productInfo.get(i)));

        }
    }

    public void productCategoryOnTheTop(String productCategoryTitle) {
        BrowserUtils.selectBy(this.productCategoryOnTop, productCategoryTitle, "text");

    }

    public void subProductCategoryOnTheTop(String subCategoryTitle) {
        BrowserUtils.selectBy(this.productSubCategoryOnTheTop, subCategoryTitle, "text");

    }

    public void clickThreeDotsAnDViews(){
        allThreeDotsButton.getFirst().click();
        viewButton.getFirst().click();
    }
    public void validateCategoriesFilter(String expectedProductSCategory){
        Assert.assertEquals(expectedProductSCategory,BrowserUtils.getText(productCategoryDescr));
    }
}
