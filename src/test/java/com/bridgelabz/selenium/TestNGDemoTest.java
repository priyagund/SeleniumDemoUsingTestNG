package com.bridgelabz.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestNGDemoTest extends BaseClass {

    @Test
    public void navigationOfBrowser() throws InterruptedException {
        driver.navigate().to("http://www.gmail.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close();
    }

    @Test
    public void keyboardRelatedOperation() throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        Thread.sleep(5000);
        Robot robort=new Robot();
        robort.mouseMove(300,500);
        robort.keyPress(KeyEvent.VK_ALT);
        robort.keyPress(KeyEvent.VK_F);
        robort.keyRelease(KeyEvent.VK_F);
        robort.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(3000);
        robort.keyPress(KeyEvent.VK_W);
        robort.keyRelease(KeyEvent.VK_W);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        WebElement unTB = driver.findElement(By.id("email"));
        unTB.clear();
        unTB.sendKeys("priyankagund18@gmail.com");
        WebElement passTB = driver.findElement(By.id("pass"));
        passTB.clear();
        //Thread.sleep(2000);
        passTB.sendKeys("861997");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);
    }

   @Test
    public void logout() throws InterruptedException, AWTException {
       driver.get("https://www.facebook.com/");
       WebElement unTB = driver.findElement(By.id("email"));
       unTB.clear();
       unTB.sendKeys("priyankagund18@gmail.com");
       WebElement passTB = driver.findElement(By.name("pass"));
       passTB.clear();
       Thread.sleep(2000);
       passTB.sendKeys("861997");
       driver.findElement(By.id("loginbutton")).click();
       Thread.sleep(2000);
       driver.get("https://www.facebook.com");
       driver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]")).click();
//       WebElement log = driver.findElement(By.className("hasLeftCol _2yq home composerExpanded _5vb_ fbx _-kb _605a o_1pp1dqnc- chrome webkit x1 Locale_en_GB cores-gte4 hasAXNavMenubar _19_u"));
//       log.click();
//       Thread.sleep(5000);
//       WebElement logOut = driver.findElement(By.className("_54ni navSubmenu _6398 _64kz __MenuItem"));
//       logOut.click();
//       Thread.sleep(5000);
//       WebElement signOut = driver.findElement(By.name("Log Out"));
//       logOut.click();
       driver.close();

    }

    @Test
    public void capterScreenShortActiTimePage() throws IOException {
        Date date=new Date();
        String date1=date.toString();
        System.out.println(date1);
        String date2=date1.replaceAll(":","_");
        System.out.println(date2);
        driver.get("https://localhost:8080/login.do");
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("/home/admin142/eclipse-workspace/TestNGProject/screenshot/"+date2+"__actiTIMELoginPage.png");
        FileUtils.copyFile(srcFile,destFile);
        driver.close();
    }
}
