package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
    }

    @Test
    public void framesActions() throws InterruptedException
    {
        driver.get("file:///D:/CFP-251/Facebook/JavaScript/PageTwoOfFrame.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("t1")).sendKeys("Vishlesha");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("Mortale");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.close();
    }
}
