package com.qa.saucelab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SauceLabValidationOfItems {
        public SauceLabValidationOfItems(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        @FindBy(css = ".inventory_item_name ")
        List<WebElement> allItems;
        @FindBy(xpath = "//div[@data-test='inventory-item-desc']")
        WebElement description;
        @FindBy(xpath = "//div[@data-test='inventory-item-price']")
        WebElement price;

        public void checkEachItem(String item) {
            for (WebElement product: allItems){
                if (BrowserUtils.getText(product).contains(item)){
                    product.click();
                    break;
                }
            }
        }
        public void itemInfo(String description, String price){
            Assert.assertTrue(BrowserUtils.getText(this.description).contains(description));
            Assert.assertTrue(BrowserUtils.getText(this.price).contains(price));
        }
    }
