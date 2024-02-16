package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        clickOnLoginLink();

        fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));

        clickOnRegistrationButton();

//        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
        Assert.assertTrue(isAlertPresent());
    }

}
