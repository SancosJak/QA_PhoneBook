package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void registerExistedUserNegativeTest() {
        click(By.cssSelector("[href='/login']"));

        type(By.name("email"), "example@gma.com");

        type(By.name("password"), "Pa$sWord1");

        click(By.name("registration"));

//        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
        Assert.assertTrue(isAlertPresent());
    }

}
