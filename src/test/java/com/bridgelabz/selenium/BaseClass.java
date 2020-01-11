package com.bridgelabz.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {


  public WebDriver driver=null;
    ChromeOptions options = new ChromeOptions();


    @BeforeMethod
    public void setup() {
        options.addArguments("--disable-notifications");
         System.setProperty("webdriver.chrome.driver", "//home/admin142/eclipse-workspace/TestNGProject/WebDriver/chromedriver");
         driver = new ChromeDriver(options);
         driver.get("https://www.facebook.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
