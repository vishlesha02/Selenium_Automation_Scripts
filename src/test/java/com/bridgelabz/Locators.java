package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Locators {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver =new ChromeDriver();
    }
    @Test
    public void webDriver_locators() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("VishleshaMortale@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Vishlesha123");
        Thread.sleep(4000);
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.partialLinkText("Create new")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vishlesha");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mortale");
        driver.findElement(By.cssSelector("input[type='text'][name='reg_email__']")).sendKeys("vishlesha@gmail.com");
        List<WebElement> tags = driver.findElements(By.tagName("input"));
        System.out.println("Number of tags" + tags.size());
        driver.findElement(By.className("_6lux"));
    }
}
