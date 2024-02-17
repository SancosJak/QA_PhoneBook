package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User().setEmail("example@gma.com").setPassword("Pa$sWord1"));

        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addNewContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Berlin")
                .setDescription("goalKeeper"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
