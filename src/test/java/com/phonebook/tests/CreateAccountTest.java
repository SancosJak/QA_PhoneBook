package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));

        app.getUser().clickOnRegistrationButton();

//        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
