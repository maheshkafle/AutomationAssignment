package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.CategoryPage;
import com.automationpractice.qa.pages.EveningDressPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.pages.PrintedDressPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrintedDressPageTest extends TestBase {

    LoginPage loginPage;
    EveningDressPage eveningDressPage;
    PrintedDressPage printedDressPage;
    CategoryPage categoryPage;

    public PrintedDressPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
        eveningDressPage = loginPage.NavigateToEveningDressesPage();
        printedDressPage =  eveningDressPage.NavigateToPrintedDressPage();
    }

    @Test(priority = 1)
    public void VerifyNavigateToCategoryPageTest(){
        String printedDressPageTitle = printedDressPage.verifyPrintedDressPageTitle();
        Assert.assertEquals(printedDressPageTitle, "Printed Dress", "Printed Dress Page Title Not Matched");
        categoryPage = printedDressPage.VerifyNavigateToCategoryPage();
//        Assert.assertEquals(printedDressPageTitle, "Printed Dress", "Printed Dress Page Title Not Matched");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
