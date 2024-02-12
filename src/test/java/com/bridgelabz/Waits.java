package com.bridgelabz;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
public class Waits {

    public WebDriver driver;
        @Test
        public void ImplicitWaits() {
            //driver.manage().timeouts().implicitlyWait(time);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.name("q")).sendKeys("Selenium");
            driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
            driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
        }

        @Test
        public void ExplicitWaits() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");

            WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.findElement(By.name("q")).sendKeys("Selenium");
            driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

            WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            // driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
            element.click();

        }

        @Test
        public void FluentWait() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30L))
                    .pollingEvery(Duration.ofSeconds(5L))
                    .ignoring(NoSuchElementException.class);

            driver.get("https://www.google.com/");


            driver.findElement(By.name("q")).sendKeys("Selenium");
            driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

            WebElement element = mywait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
                }
            });

            element.click();
    }
}
