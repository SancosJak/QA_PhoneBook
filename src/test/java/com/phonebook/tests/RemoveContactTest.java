package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Berlin", "goalKeeper");
        clickOnSaveButton();
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
}
