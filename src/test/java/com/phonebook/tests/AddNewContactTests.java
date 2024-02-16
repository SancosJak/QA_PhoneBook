package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));

        type(By.name("email"), "example@gma.com");

        type(By.name("password"), "Pa$sWord1");

        click(By.name("login"));
    }
    @Test
    public void addNewContactPositiveTest() {
        click(By.cssSelector("[href='/add'"));
        type(By.cssSelector("input:nth-child(1)"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "goalKeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactCreated("Karl"));

    }

    public boolean isContactCreated(String text) {
        List <WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }
}
