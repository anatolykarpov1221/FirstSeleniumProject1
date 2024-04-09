package com.ait.qa34;
import com.firstseleniumproect.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = true)
    public void createNewAccountPositiveTest() {
       //Random random = new Random();
       //int i = random.nextInt(1000)+1000;

        app.getUser().clickOnRegisterLink();
        app.getUser().fillNameRegisterForm("Petr", "Kifa");
        app.getUser().fillLoginRegisterForm(new User().setEmail("student17@web.com")
                .setPassword("Super1557!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }


}
