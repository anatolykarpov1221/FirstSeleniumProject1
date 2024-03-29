package com.ait.qa34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    //befor-setUP
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");// with history
        driver.navigate().back();
        driver.navigate().forward();
    }
    //test-name
    @Test
    public void opennGoogleTest(){
        System.out.println("Google is open");
    }
    //after-tearDown
    @AfterMethod(enabled = false)//disable method
    public void tearDown(){
        driver.quit();//close browser(all tabs)
        // driver.close(); only one tab close
    }



}
