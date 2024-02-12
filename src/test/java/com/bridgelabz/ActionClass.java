package com.bridgelabz;

import com.beust.ah.A;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClass {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
    }


    @Test
    public  void rightClick() throws InterruptedException
    {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement userName = driver.findElement(By.id("email"));
        Actions action =new Actions(driver);
       // Thread.sleep(3000);
        action.contextClick(userName).perform();

    }

    @Test
    public void dragandDrop() throws InterruptedException
    {
        driver.get("https://jqueryui.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Thread.sleep(3000);
        Actions action=new Actions(driver);
     // action.dragAndDrop(src,des).perform();
       action.moveToElement(src).clickAndHold().perform();
       action.release(des).perform();
    }

    @Test
    public void doubleClicks() throws InterruptedException
    {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement doubleclick =driver.findElement(By.linkText("Forgotten password?"));
        Thread.sleep(3000);
        Actions action =new Actions(driver);
        action.doubleClick(doubleclick).perform();
        //driver.close();

    }

    @Test
    public void keyboardAction()
    {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Actions action =new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    @Test
    public void keyboard_Action()
    {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("Vishlesha");
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ENTER);
    }

}
