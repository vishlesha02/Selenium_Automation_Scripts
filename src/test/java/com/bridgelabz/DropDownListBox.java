package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownListBox {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void lists() throws InterruptedException {
        driver.get("file:///D:/CFP-251/Facebook/JavaScript/ListBox.html");
        driver.manage().window().maximize();
        WebElement list =driver.findElement(By.id("mtr"));
        Select s=new Select(list);
        s.selectByIndex(0);
        Thread.sleep(3000);
        s.selectByValue("v");
        Thread.sleep(3000);
        s.selectByVisibleText("POORI");
        Thread.sleep(3000);
        s.deselectByValue("v");
        driver.close();
    }

    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=678802104188&hvpos=&hvnetw=g&hvrand=16785083222563523473&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062279&hvtargid=kwd-10573980&hydadcr=14453_2371562");
        driver.manage().window().maximize();
        Thread.sleep(7000);
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select s =new Select(dropDownElement);

        s.selectByVisibleText("Amazon Devices");
        Thread.sleep(4000);
        s.selectByIndex(3);
        Thread.sleep(4000);
        s.selectByValue("search-alias=nowstore");
        System.out.println("Type of dropdown " + s.isMultiple());


        List<WebElement> list = s.getOptions();
        System.out.println("List of all options ");
        for (WebElement ls :list) {
            System.out.println(ls.getText());
        }

        for (WebElement ls:list) {
            if(ls.getText().equals("Apps & Games"))
            {
                ls.click();
                break;
            }

        }
    }

}
