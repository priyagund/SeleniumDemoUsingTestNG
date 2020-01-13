package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class XpathUsingAtribute_Actitime extends BaseClass {


    @Test
    public void findingWidthAndHeightOFClock_AndLoginToActitime() throws InterruptedException {
        driver.get("https://demo.actitime.com/login.do");

//xpath using multiple attributes
        String xp = "//input[@id='username']";
        Thread.sleep(2000);
//Enter admin into username text box
        driver.findElement(By.xpath(xp)).sendKeys("admin");
        Thread.sleep(2000);
//find password element using xpath by attribute and enter manager in to password textbox.
        driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("manager");
        Thread.sleep(2000);
//find an image on the web page whose attributes (src)contains a value called timer
        WebElement clock = driver.findElement(By.id("logoContainer"));
//store the width value of the clock image into a variable called widthValue
        int widthValue = clock.getSize().getWidth();
//Print the width of the clock image
        System.out.println("the width is :" + widthValue);

//Print the height of the clock image
        System.out.println("the height of the clock element is : " + clock.getSize().getHeight());
//xpath using contains() function and text() function
        driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void  Independent_Dependent_Xpath_Seleniumsite_javaDownload() throws InterruptedException {
        driver.get("http://www.seleniumhq.org/download/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[.='Java']/..//a[.='Download']")).click();
    }
}
