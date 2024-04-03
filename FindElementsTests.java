package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/");
        driver.manage().window().maximize();
        //woit for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void findElementByTagName(){
        //by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());


        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());

    }
    @Test
    public void findElementByLocators() {
        //id
        driver.findElement(By.id("city"));
        //class name
        driver.findElement(By.className("input-container"));
        //link text
        driver.findElement(By.linkText("Let the car work"));
        //partial link text
        driver.findElement(By.partialLinkText("work"));

    }
    //css selector
    @Test
    public void findElementByCssSelector() {

        //id -> #id
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        //class name -> .className
        // driver.findElement(By.className("input-container"));
        driver.findElement(By.cssSelector(".input-container"));
        //[name='user']
        driver.findElement(By.cssSelector("[for='city']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='work']"));
    }
    //xPath
    @Test
    public void findElementByXpath(){
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//*[@id='city']"));
        // driver.findElement(By.className("input-container"));
        driver.findElement(By.xpath("//*[@class='input-container']"));
        //contains
        driver.findElement(By.xpath("//*[contains(@href,'car')]"));
        //start -> //*[starts-with
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));
        //Text
        driver.findElement(By.xpath("//span[text()=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[.=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[contains(text(),'mistake')]"));
        driver.findElement(By.xpath("//span[contains(.,'mistake')]"));

        // search of parent element - //input[@id='username']/..
       //     //div/a - child - css = div>a
       //     //div//a - any level child - css = div a

        //tag1[.tag2[@attr='value']]
        //*[@id='firstName' or @name='lastName']
         //*[@id='firstName' and @name='lastName']

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
