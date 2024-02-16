package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public  void loginRegisteredUserPositiveTest(){
        click(By.cssSelector("[href='/login']"));

        type(By.name("email"), "example@gma.com");

        type(By.name("password"), "Pa$sWord1");

        click(By.name("login"));

        Assert.assertTrue(isElementPresent(By.cssSelector("button")));

    }

}
