package com.qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.swing.text.DateFormatter;
import javax.swing.text.html.CSS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productChoose;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(xpath = "//input[@onclick='productsChanged(); return false;']")
    WebElement calculateButton;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visa;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireOfCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;
    @FindBy(tagName = "strong")
    WebElement message;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    List<WebElement> allInformation;

    public void productValidation(String product, String quantity) {
        BrowserUtils.selectBy(this.productChoose, product, "value");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
        calculateButton.click();
    }

    public void addressInformation(String customerName, String street, String city,
                                   String state, String zipCode) {
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void paymentInformation(String cardType, String cardNumber, String expireOfCard) {
        cardType = cardType.toLowerCase();
        switch (cardType) {
            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                visa.click();
        }
        this.cardNumber.sendKeys(cardNumber);
        this.expireOfCard.sendKeys(expireOfCard);
    }

    public void setProcessButton() {
        processButton.click();
    }

    public String message() {
        return BrowserUtils.getText(message);
    }
    public void validateOrderInformation(String customerName, String product,
                                         String quantity, String Street, String city,
                                         String state, String zipCode, String cardType,
                                         String cardNumber, String expireDate){
        //Please do not lose this code
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        String currentDate = dtf.format(now);

        List<String> expectedInfo = Arrays.asList(customerName,product,quantity,currentDate,Street,city,state,zipCode
        ,cardType,cardNumber,expireDate);
        for (int i = 1; i < allInformation.size()-1; i++) {
            Assert.assertEquals(expectedInfo.get(i-1),BrowserUtils.getText(allInformation.get(i)));

        }
    }
}
