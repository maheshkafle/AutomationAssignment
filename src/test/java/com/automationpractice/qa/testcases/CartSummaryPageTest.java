package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartSummaryPageTest extends TestBase{

    LoginPage loginPage;
    EveningDressPage eveningDressPage;
    PrintedDressPage printedDressPage;
    CategoryPage categoryPage;
    CartSummaryPage cartSummaryPage;
    RegistrationPage registrationPage;

    public CartSummaryPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
        eveningDressPage = loginPage.NavigateToEveningDressesPage();
        printedDressPage =  eveningDressPage.NavigateToPrintedDressPage();
        categoryPage = printedDressPage.VerifyNavigateToCategoryPage();
        cartSummaryPage = categoryPage.verifyNavigateToCartSummaryPage();
    }

    @Test(priority = 1)
    public void verifyNavigateToSignInPageTest() {
        String cartSummaryPageTitle = cartSummaryPage.verifyCartSummaryPageTitle();
        System.out.println("cartSummaryPageTitle"+cartSummaryPageTitle);
        Assert.assertEquals(cartSummaryPageTitle, "SHOPPING-CART SUMMARY\nYour shopping cart contains: 3 Products", "Category Page Title Not Matched");
        registrationPage = cartSummaryPage.verifyNavigateToRegistrationPage();
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }
}
