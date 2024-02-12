package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearcgContextFindElement {
    public WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void find_Element()
    {

        //find Element returns single element
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=678802104188&hvpos=&hvnetw=g&hvrand=16785083222563523473&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062279&hvtargid=kwd-10573980&hydadcr=14453_2371562");
        driver.manage().window().maximize();
        WebElement singleElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        singleElement.sendKeys("Iphone");
        WebElement singleEle = driver.findElement(By.xpath("//div[@id='navFooter']//a"));
        System.out.println(singleEle.getText());
    }

    @Test
    public void find_Elements()
    {
        //find Elements returns multiple elements
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=678802104188&hvpos=&hvnetw=g&hvrand=16785083222563523473&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062279&hvtargid=kwd-10573980&hydadcr=14453_2371562");
        driver.manage().window().maximize();
        List<WebElement> categories = driver.findElements(By.xpath("//*[@id='navFooter']/div[1]/div"));
        System.out.println(categories.size());
        for (WebElement categogry :categories) {
            System.out.println(categogry.getText());

        }
    }
}
