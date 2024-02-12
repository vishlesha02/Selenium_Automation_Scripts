package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Tables {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
    }
    @Test
    public void webTable() throws InterruptedException
    {
        driver.get("file:///D:/CFP-251/Facebook/JavaScript/Table.html");
        driver.manage().window().maximize();
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows=allRows.size();
        System.out.println("Total number of rows = "+ totalRows);
        Thread.sleep(3000);
        List<WebElement> columns = driver.findElements(By.xpath("//th"));
        int totalcolumns=columns.size();
        System.out.println("Total number of Columns = "+ totalcolumns);
        Thread.sleep(3000);
        List<WebElement> cells = driver.findElements(By.xpath("//th|//td"));
        int totalcells=cells.size();
        System.out.println("Total number of cells = "+ totalcells);


    }
}
