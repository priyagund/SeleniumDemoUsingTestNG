package com.bridgelabz.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TestNGDemoTest extends BaseClass {

    @Test
    public void navigationOfBrowser() throws InterruptedException {
        //navigate to the gmail page
        driver.navigate().to("http://www.gmail.com");
        Thread.sleep(3000);
        //navigate back to original page
        driver.navigate().back();
        Thread.sleep(3000);
        //forword to next page
        driver.navigate().forward();
        Thread.sleep(3000);
        //referesh back to original page
        driver.navigate().refresh();
    }

    @Test
    public void keyboardRelatedOperation() throws AWTException, InterruptedException {
        //1. Launch the browser
        WebDriver driver = new ChromeDriver();
        //2. enter the url -
        driver.navigate().to("http://www.google.com");
        Thread.sleep(5000);
        //Creating an object of Robot Class
        Robot robort=new Robot();
        //move the mouse by x and y coordinate
        robort.mouseMove(300,500);
        //press ALT key from keyboard
        robort.keyPress(KeyEvent.VK_ALT);
        //press F key from keyboard
        robort.keyPress(KeyEvent.VK_F);
        //Release F key from keyboard
        robort.keyRelease(KeyEvent.VK_F);
        //Release ALT key from keyboard
        robort.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(3000);
        //press W key from keyboard
        robort.keyPress(KeyEvent.VK_W);
        //Release W key from keyboard
        robort.keyRelease(KeyEvent.VK_W);
        Thread.sleep(3000);

    }

    @Test
    public void login() throws InterruptedException, AWTException {
        // Used “id” locator to find USERNAME text box
        WebElement userEmail = driver.findElement(By.id("email"));
        //Clear the existing value present in the text box
        userEmail.clear();
        // Enter value into the USERNAME text box
        userEmail.sendKeys("priyankagund18@gmail.com");
        // Used “name” locator to find Password text box
        WebElement userPassWord = driver.findElement(By.id("pass"));
        WebElement passTB = driver.findElement(By.name("n1"));
        //Clear the existing value present in the text box
        userPassWord.clear();
        //Halt the program execution for 2 seconds
        Thread.sleep(2000);
        // Enter value into the Password text box
        userPassWord.sendKeys("861997");
        // Find the address of ActiTIME Link and click
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);
        Robot robot=new Robot();
        robot.mouseMove(400,5);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

   @Test
    public void logout() throws InterruptedException, AWTException {
       // Used “id” locator to find USERNAME text box
       WebElement userEmail = driver.findElement(By.id("email"));
       userEmail.clear();
       // Enter value into the USERNAME text box
       userEmail.sendKeys("priyankagund18@gmail.com");
       WebElement userPassWord = driver.findElement(By.name("pass"));
       userPassWord.clear();
       Thread.sleep(2000);
       // Enter value into the Password text box
       userPassWord.sendKeys("861997");
       //// Find the address of ActiTIME Link and click
       driver.findElement(By.xpath("//input[@id='u_0_b']")).click();
       Thread.sleep(2000);
       //Enter the xpath of navigation button
       driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
       Thread.sleep(2000);
       //Enter the xpath of logout button
       driver.findElement(By.xpath("//li[@classubllem']")).click();
       Thread.sleep(2000);
    }

    @Test
    public void capterScreenShortActiTimePage() throws IOException {
        //Creating an object of Date class
        Date date=new Date();
        //Printing the actual date
        String date1=date.toString();
        System.out.println(date1);
        //replacing the colon present in the date timestamp format to "_" using replaceAll()
        //method of String class
        String date2=date1.replaceAll(":","_");
        System.out.println(date2);
        driver.get("https://localhost:8080/login.do");
        //Typecasting the driver object to TakesScreenshot interface type.
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        //getting the source file using getScreenshotAs() method and storing in a file
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imageName=new Object() {} .getClass().getEnclosingMethod().getName();
        File destFile = new File("/home/admin142/eclipse-workspace/TestNGProject/screenshot/"+date2+ imageName);
        /*copyFile() method is a static method present in FileUtils class of JAVA
storing the screenshot in the destination location*/
        FileUtils.copyFile(srcFile,destFile);
    }

    @Test
    public void loginUsingXpath() throws InterruptedException {
        //Enter the xpath of username
        WebElement unTB = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        unTB.clear();
        unTB.sendKeys("priyankagund18@gmail.com");
        //Enter the Xpath of password
        WebElement passTB = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        passTB.clear();
        Thread.sleep(2000);
        //Enter the value of password
        passTB.sendKeys("861997");
        //Enter the Xpath of login button
        driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
        Thread.sleep(2000);
    }

}
