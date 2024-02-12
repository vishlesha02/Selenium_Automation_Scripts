package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        driver=new ChromeDriver();
    }

    @Test
    public void statusOfWebElements()
    {
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=678802104188&hvpos=&hvnetw=g&hvrand=16785083222563523473&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062279&hvtargid=kwd-10573980&hydadcr=14453_2371562");
        driver.manage().window().maximize();

        WebElement searchItem = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        System.out.println("Display Status : " + searchItem.isDisplayed());
        System.out.println("Enabled Status : " + searchItem.isEnabled());
        //radiobuttons, checkboxes, dropdown
        WebElement categoriesDropDown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        System.out.println("Selected status" + categoriesDropDown.isSelected());

    }

    @Test
    public void status_Of_WebElements() throws InterruptedException {
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        WebElement emailInputBox= driver.findElement(By.id("Email"));
        emailInputBox.clear();
        emailInputBox.sendKeys("Vishlesha@gmail.com");
        Thread.sleep(4000);
        emailInputBox.clear();
        emailInputBox.sendKeys("admin@yourstore.com");
        System.out.println("Attribute value of value " + emailInputBox.getAttribute("value"));
        WebElement button = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        System.out.println("Attribute of button " + button.getAttribute("type"));
        System.out.println("Inner text of button " + button.getText());
        button.submit();
        Thread.sleep(5000);
        WebElement catalog =driver.findElement(By.linkText("Catalog"));
        catalog.click();
    }

    @Test
    public void locationAndSize()
    {
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement min_slider=driver.findElement(By.xpath("//span[1]"));

        System.out.println("Location of slider : " + min_slider.getLocation());
        System.out.println("Height and width of slider : " + min_slider.getSize());

    }
}
