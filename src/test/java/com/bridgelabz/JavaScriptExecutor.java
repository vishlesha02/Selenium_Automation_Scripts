package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    public static WebDriver driver;
    @BeforeTest
    public void setup()
    {
        driver=new ChromeDriver();
    }

    @Test
    public void enterTextInDisabledField() throws InterruptedException
    {
        driver.get("file:///D:/CFP-251/Facebook/JavaScript/javas.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        JavascriptExecutor jsexe=(JavascriptExecutor) driver;
        Thread.sleep(3000);
        jsexe.executeScript("document.getElementById('t1').value='Mortale'");
        Thread.sleep(3000);
        jsexe.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(3000);
        jsexe.executeScript("document.getElementById('t2').value='Ashok'");
        Thread.sleep(3000);
        jsexe.executeScript("document.getElementById('t2').type='button'");

    }

    @Test
    public void scrollUpAndMoveTo() throws InterruptedException
    {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        JavascriptExecutor jsexe=(JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        jsexe.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(5000);
        driver.close();
    }
}
