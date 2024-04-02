package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementsHW {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void findElementByTagName(){
        WebElement element = driver.findElement(By.tagName("title"));
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.tagName("head"));
        System.out.println(element1.getText());
        WebElement element2 = driver.findElement(By.tagName("h3"));
        System.out.println(element2.getText());

    }
    @Test
    public void findElementByCssSelector() {

        //id -> #id
        driver.findElement(By.cssSelector("#bar-notification"));
        //class name -> .className
        driver.findElement(By.cssSelector(".bar-notification"));

        driver.findElement(By.cssSelector("body [tabindex='0']"));

        driver.findElement(By.cssSelector("h2.product-title "));

        driver.findElement(By.cssSelector(".footer-poweredby a"));

        driver.findElement(By.cssSelector(".header"));

        driver.findElement(By.cssSelector(".compare-products [value$='list']"));
       // driver.findElement(By.cssSelector(""));
        //driver.findElement(By.cssSelector(""));
       // driver.findElement(By.cssSelector(""));
    }


    //xPath
    @AfterMethod
    public void tearDown() {driver.quit();}

}
