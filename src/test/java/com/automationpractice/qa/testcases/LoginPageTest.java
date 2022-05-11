package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.EveningDressPage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    EveningDressPage eveningDressPage;

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
    public void ClickEveningDressButtonTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        //Thread.sleep(3000);
        //System.out.println("Actual Title-->"+title);
        Assert.assertEquals(title, "My Store");
//        loginPage.ValidateClickEveningDressButton();
        eveningDressPage = loginPage.NavigateToEveningDressesPage();
        Thread.sleep(3000);
//        Assert.assertEquals("EVENING DRESSES", eveningDressPage);
        //TechnicalTools.addToCart(driver, page_evening_dresses.img_printed_dress);
        Thread.sleep(3000);
        //page_evening_dresses.btn_continue_shopping.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
