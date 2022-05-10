package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    public LoginPageTest(){
        // BaseClass constructor will be called and properties will be initialized
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Thread.sleep(3000);
        System.out.println("Actual Title-->"+title);
        Assert.assertEquals(title, "My Store");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
