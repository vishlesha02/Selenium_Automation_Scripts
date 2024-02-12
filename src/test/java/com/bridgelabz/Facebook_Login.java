package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Facebook_Login {
    public WebDriver driver;

    @Test
    public void login() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("vishlesha@gmail.com");
        WebElement element= driver.findElement(By.id("pass"));
        element.sendKeys("password");
        driver.findElement(By.name("login")).click();       //click comes under web driver


    }
    @Test
    public void signUp() throws InterruptedException
    {
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.partialLinkText("Create new")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vishlesha");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mortale");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("vishlesha@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("vishlesha@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Password123");
        driver.findElement(By.name("birthday_day")).sendKeys("8");
        driver.findElement(By.name("birthday_month")).sendKeys("Jul");
        driver.findElement(By.name("birthday_year")).sendKeys("1999");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[text()='Custom']")).click();
        driver.findElement(By.name("preferred_pronoun")).sendKeys("She: Wish her a happy birthday!");
        driver.findElement(By.xpath("//input[@name='custom_gender']")).sendKeys("Her");
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        driver.close();

    }

}
