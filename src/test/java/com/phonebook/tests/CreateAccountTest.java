package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("example@gma.com");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Pa$sWord1");

        driver.findElement(By.name("registration")).click();

        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
    }
}
