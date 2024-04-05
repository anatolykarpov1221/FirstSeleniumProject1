package com.ait.qa34;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class CreateAccountTests extends TestBase{

    @Test(enabled = true)
    public void createNewAccountPositiveTest() {
       Random random = new Random();
       int i = random.nextInt(1000)+1000;
        //click on register link
        click(By.xpath("//*[@href='/register']"));
        //enter firstName
        type(By.id("FirstName"),"Petr");
        //input lastName
        type(By.id("LastName"),"Kifa");

        //enter email
        type(By.id("Email"), "student17" + i + "@web.com");
        //enter password
        type(By.id("Password"), "Super1557!");
        //Confirm password:
        type(By.id("ConfirmPassword"),"Super1557!");
        //click on Registration button
        click(By.cssSelector("#register-button"));
        //assert Sign Out button is present
        Assert.assertTrue(isElementPresent(By.cssSelector("[value='Continue']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
        click(By.cssSelector("[href='/logout']"));
    }
    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }


}
