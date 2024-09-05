package com.qa.saucelab.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

//public class SauceLabHook {
// public  WebDriver driver;
//    @Before
//    public void setup(){
//        driver= DriverHelper.getDriver();
//        driver.get(ConfigReader.readProperty("sauceLabURL"));
//    }
//    @After
//    public void tearDown(Scenario scenario){
//        BrowserUtils.getScreenShootCuCumber(driver,scenario);
//        driver.quit();
//    }

//}
