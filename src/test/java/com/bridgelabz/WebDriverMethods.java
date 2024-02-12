package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WebDriverMethods {
        public WebDriver driver;

        @Test
        public void methodsOfWebDriver() throws InterruptedException
        {
            driver =new ChromeDriver();
            driver.get("https://www.facebook.com/");
            driver.manage().window().maximize();
            // driver.manage().window().minimize();
            String url=driver.getCurrentUrl();
            System.out.println(url);
            String title=driver.getTitle();
            System.out.println(title);
            String pageSource =driver.getPageSource();
            System.out.println(pageSource);
            Thread.sleep(5000);
            driver.navigate().to("https://www.flipkart.com");
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().refresh();
            driver.close();
            driver.quit();

        }
        @Test
        public void windowHandel()
        {
            driver =new ChromeDriver();
            driver.get("https://www.facebook.com/");
            driver.manage().window().maximize();
            String windowId = driver.getWindowHandle();
            System.out.println("Window id of current page " + windowId);
        }
        @Test
         public void windowHandels() throws InterruptedException {
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

        }
}
