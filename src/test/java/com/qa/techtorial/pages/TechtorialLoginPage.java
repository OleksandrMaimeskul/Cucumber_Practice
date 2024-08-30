package com.qa.techtorial.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechtorialLoginPage {
    public TechtorialLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[.='Log In']")
    WebElement logInHeader;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement button;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        button.click();
    }

    public boolean validateHEader() {
        return logInHeader.isDisplayed();
    }
}
