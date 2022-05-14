package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CategoryPageTest extends TestBase {

    LoginPage loginPage;
    EveningDressPage eveningDressPage;
    PrintedDressPage printedDressPage;
    CategoryPage categoryPage;
    CartSummaryPage cartSummaryPage;

    public CategoryPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
        eveningDressPage = loginPage.NavigateToEveningDressesPage();
        printedDressPage =  eveningDressPage.NavigateToPrintedDressPage();
        categoryPage = printedDressPage.VerifyNavigateToCategoryPage();
    }

    @Test(priority = 1)
    public void verifyNavigateToCartSummaryPageTest() {
        String categoryPageTitle = categoryPage.verifyCategoryPageTitle();
        assertTrue(categoryPageTitle.contains("s"));
        cartSummaryPage = categoryPage.verifyNavigateToCartSummaryPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
