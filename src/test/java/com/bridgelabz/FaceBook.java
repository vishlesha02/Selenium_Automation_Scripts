package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FaceBook {
    public WebDriver driver;
    @BeforeTest
    public void setUp() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver=new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("vishleshamortale02@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Vishlesha&02");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }
    @Test
    public void login() throws InterruptedException, IOException {

        Thread.sleep(5000);
        //Home button
        driver.findElement(By.xpath("//ul//li//span[@class='x4k7w5x x1h91t0o x1h9r5lt x1jfb8zj xv2umb2 x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1qrby5j']//span[@class='x1n2onr6'][1]")).click();
        Thread.sleep(3000);
        //Post Photo/Video button
        driver.findElement(By.xpath("//span[text()='Photo/video']")).click();
        Thread.sleep(3000);
        //Enter status
        driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']")).sendKeys("Morning Sunshine!!");
        Thread.sleep(3000);
        //Upload Photo
        driver.findElement(By.xpath("//div[@class='x1n2onr6 x1ja2u2z x9f619 x78zum5 xdt5ytf x2lah0s x193iq5w x5yr21d']//div[@class='x14yjl9h xudhj91 x18nykt9 xww2gxu x6s0dn4 x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x3nfvp2 xl56j7k x1n2onr6 x1qhmfi1 x1vqgdyp x100vrsf']")).click();
        Thread.sleep(3000);

        Runtime.getRuntime().exec("D:\\CFP-251\\Facebook\\FaceBookAssignment.exe");
        Thread.sleep(4000);
        //Post Button
        //driver.findElement(By.xpath("//div[@class='x6s0dn4 x9f619 x78zum5 x1qughib x1pi30zi x1swvt13 xyamay9 xh8yej3']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']")).click();
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(4000);

    }

    @Test
    public void coutnLikes() throws InterruptedException {
        //clicks on profile
        driver.findElement(By.xpath("//span[text()='Vishlesha Mortale']")).click();
        Thread.sleep(5000);
      //  driver.findElement(By.xpath("//span[@class='xt0b8zv x2bj2ny xrbpyxo xl423tq']")).click();
        driver.findElement(By.xpath("//div[@class='x1n2onr6']//div[@class='x6s0dn4 x78zum5 x1iyjqo2 x6ikm8r x10wlt62']//span[@class='xt0b8zv x2bj2ny xrbpyxo xl423tq']")).click();
       Thread.sleep(6000);
       // List<WebElement> countOfLikes=driver.findElements(By.xpath("//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']//div[@class='x1lq5wgf xgqcy7u x30kzoy x9jhf4c x1lliihq']"));
        List<WebElement> countOfLikes=driver.findElements(By.xpath("//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div[@data-visualcompletion='ignore-dynamic']"));
        System.out.println("Number of likes : " + countOfLikes.size());
    }


    @Test
    public void likefrndPhoto() throws InterruptedException, AWTException {

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Swapnill Patil");
        driver.findElement(By.xpath("//span[1][@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']")).click();
        Thread.sleep(3000);
        Robot robot=new Robot();
        robot.mouseWheel(6);
        Thread.sleep(9000);
       // driver.findElement(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']//div[@class='xu06os2 x1ok221b']")).click();
        driver.findElement(By.xpath("//div[@class='xq8finb x16n37ib']//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x193iq5w xeuugli x1r8uery x1iyjqo2 xs83m0k xg83lxy x1h0ha7o x10b6aqq x1yrsyyn']//span[text()='Like'][1]")).click();

    }
}
