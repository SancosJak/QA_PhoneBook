package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
    }

    @Test
    public  void loginRegisteredUserPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));
        clickOnLoginButton();

        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
    }
    @Test
    public  void loginRegisteredUserNegativeTestWithoutEmail(){
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setPassword("Pa$sWord1"));
        clickOnLoginButton();

        Assert.assertTrue(isAlertPresent());
    }

}
