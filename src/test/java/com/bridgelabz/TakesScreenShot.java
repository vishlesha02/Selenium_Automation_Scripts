package com.bridgelabz;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakesScreenShot {
    public WebDriver driver;

    @Test
    public void screenShot() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("Vishlesha");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);
        File DFile = new File("D:\\CFP-251\\Facebook\\FacebookImage\\" + "FacebookSS.png");
        FileHandler.copy(SFile, DFile);
        //driver.close();

    }

    @Test
    public void portionOrSectionScreenShot() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebElement section = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File des = new File("D:\\CFP-251\\Facebook\\FacebookImage\\" + "LoginSS.png");
        FileHandler.copy(src, des);
    }

}
