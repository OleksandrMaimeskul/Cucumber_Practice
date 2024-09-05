package com.qa.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;
    @FindBy(linkText = "View all orders")
    WebElement allOrdersButton;

    public void orderButton(){
        orderButton.click();
    }
    public void setAllOrdersButton(){
        allOrdersButton.click();
    }
}
