package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBase {

    LoginPage loginPage;
    EveningDressPage eveningDressPage;
    PrintedDressPage printedDressPage;
    CategoryPage categoryPage;
    CartSummaryPage cartSummaryPage;
    RegistrationPage registrationPage;

    public RegistrationPageTest(){
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
        registrationPage = cartSummaryPage.verifyNavigateToRegistrationPage();

    }

    @Test(priority = 1)
    public void verifyNavigateToOrderPage() throws InterruptedException {
        String registrationPageTitle = registrationPage.verifyRegistrationPageTitle();
        System.out.println("cartSummaryPageTitle"+registrationPageTitle);
        Assert.assertEquals(registrationPageTitle, "CREATE AN ACCOUNT", "Category Page Title Not Matched");
        registrationPage.navigateToRegistrationForm();
        String total_amount = registrationPage.verifyTotalOrderAmount();
        Assert.assertEquals(total_amount, "$69.39", "Total Order Amount Not Matched");
        String account_details = registrationPage.verifyAccountDetails();
        Assert.assertEquals(account_details, "xyz", "Account Details Not Matched");
        String bank_name = registrationPage.verifyBankName();
        Assert.assertEquals(bank_name, "RTP", "Bank Name Not Matched");
        registrationPage.verifyClickOnCustomerAccount();
        registrationPage.verifyClickOnOrderHistory();
        String amount_order_history = registrationPage.verifyTotalAmountFromOrderHistory();
        Assert.assertEquals(total_amount, amount_order_history, "Total Amount Not Matched");
        registrationPage.LogOut();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
