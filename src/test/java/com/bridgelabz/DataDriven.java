package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {
    public WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "LoginData" )
    public void loginTest(String user,String pwd,String exp)
    {
        driver.findElement(By.id("email")).sendKeys("user");
        driver.findElement(By.id("pass")).sendKeys("pwd");
        driver.findElement(By.name("login")).click();



    }

    @DataProvider(name="LoginData")
    public String [][] getData()
    {
        String loginData[][]={
                {"vishleshamortale02@gmail.com","vishlesha&02","valid"},
                {"vishlesha@gmail.com","vishlesha&02","invalid"},
                {"vishlesha@gmail.com","visha&02","invalid"}
        };
        return loginData;
    }


    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
