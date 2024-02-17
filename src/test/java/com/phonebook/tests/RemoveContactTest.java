package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Berlin")
                .setDescription("goalKeeper"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
}
