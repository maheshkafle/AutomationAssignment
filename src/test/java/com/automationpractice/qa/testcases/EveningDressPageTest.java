package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.EveningDressPage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EveningDressPageTest extends TestBase {

    LoginPage loginPage;
    EveningDressPage eveningDressPage;

    public EveningDressPageTest(){
        // BaseClass constructor will be called and properties will be initialized
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
        eveningDressPage = loginPage.NavigateToEveningDressesPage();;
    }

    @Test(priority = 1)
    public void verifyEveningDressPageTest(){
        String eveningDressPageTitle = eveningDressPage.verifyEveningDressPageTitle();
        Assert.assertEquals(eveningDressPageTitle, "EVENING DRESSES ", "EveningDresses Page Title Not Matched");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
