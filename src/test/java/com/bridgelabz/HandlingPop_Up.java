package com.bridgelabz;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class HandlingPop_Up {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
    }
    @Test
    public void simple_Alert() throws InterruptedException
    {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("alertButton")).click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        Thread.sleep(3000);
        alert.accept();
    }
//    @Test
//    public void simpleAlert() throws InterruptedException
//    {
//        driver.get("https://demoqa.com/alerts");
//        driver.manage().window().maximize();
//        driver.findElement(By.id("timerAlertButton")).click();
//        Alert alert=driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//    }
    @Test
    public void confirmationPopUp() throws InterruptedException
    {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmButton")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(3000);
        alert.dismiss();
    }
    @Test
    public void promptPopUp() throws InterruptedException
    {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        JavascriptExecutor jsexe =(JavascriptExecutor)driver;
        jsexe.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        //Thread.sleep(3000);
        alert.sendKeys("Vishlesha");
        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void authenticatedPopUp()
    {
       // driver.get("https://username:password@URL"); SYNTAX
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }

    @Test
    public void permissionPopupNotification()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver=new ChromeDriver(options); //when u pass (options in Chromedriver) at that time only it with applicable
        driver.get("https://www.redbus.in/");
    }
    @Test
    public void fileUploadUsingTypeFileElement() throws InterruptedException
    {
        driver.get("https://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\CFP-251\\Facebook\\FacebookImage");

    }

    @Test
    public void childBrowserPopUp() throws InterruptedException {
        driver =new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIds =  driver.getWindowHandles();
        Iterator<String> it=windowIds.iterator();

        String parentwindowid=it.next();
        String childwindowid=it.next();

        System.out.println("Parent window id " + parentwindowid);
        System.out.println("Child window id " + childwindowid);

        driver.switchTo().window(parentwindowid);
        System.out.println("Parent window title " + driver.getTitle());

        driver.switchTo().window(childwindowid);
        System.out.println("Child window title " + driver.getTitle());

    }
    @Test
    public void childBrowserPopUpOtherWay() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();
        for (String winId : windowIds) {
            String title = driver.switchTo().window(winId).getTitle();
            System.out.println("Title of window " + title );
        }

    }
}
