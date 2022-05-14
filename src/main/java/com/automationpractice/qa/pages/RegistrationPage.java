package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends TestBase {

    @FindBy(xpath = "//h3[normalize-space()='Create an account']\n")
    WebElement DivRegistrationPageTitle;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement InputEmail;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement BtnCreateAccount;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement InputFirstName;

    @FindBy(xpath = " //*[@id='customer_lastname']")
    WebElement InputLastName;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement InputPassword;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement InputAddress;

    @FindBy(xpath = "//*[@id='city']")
    WebElement InputCity;

    @FindBy(xpath = "//*[@id='id_state']")
    WebElement InputState;

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement InputPostCode;

    @FindBy(xpath = "//*[@id='id_country']")
    WebElement InputCountry;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement InputMobilePhone;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    WebElement BtnSubmitAccount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement BtnCheckoutAddressTab;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    WebElement CheckboxAgree;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement BtnCheckoutShippingTab;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement BtnPayByBankWire;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement BtnConfirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/span/strong")
    WebElement DivTotalAmount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/strong[2]")
    WebElement DivAccountDetails;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/strong[3]")
    WebElement DivBankName;

    @FindBy(xpath = "//div[@class='header_user_info']")
    WebElement DivViewMyCustomerAccount;

    @FindBy(xpath = "//a[@title='Orders']")
    WebElement DivViewMyOrder;

    @FindBy(xpath = " //*[@id=\"order-list\"]/tbody/tr/td[3]/span")
    WebElement DivAmountOrderHistoryTable;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement BtnLogOut;

    //Initializing the Page Objects
    public RegistrationPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyRegistrationPageTitle(){
        String titleRegistrationPageDivText = DivRegistrationPageTitle.getText();
        return titleRegistrationPageDivText;
    }

    public void navigateToRegistrationForm() throws InterruptedException {
        InputEmail.sendKeys(prop.getProperty("email"));
        BtnCreateAccount.click();
        InputFirstName.sendKeys(prop.getProperty("firstname"));
        InputLastName.sendKeys(prop.getProperty("lastname"));
        InputPassword.sendKeys(prop.getProperty("password"));
        InputAddress.sendKeys(prop.getProperty("address"));
        InputCity.sendKeys(prop.getProperty("city"));
        Select dropdown_city= new Select(InputState);
        dropdown_city.selectByValue(prop.getProperty("state_value"));
        InputPostCode.sendKeys(prop.getProperty("postal_code"));
        Select dropdown_country= new Select(InputCountry);
        dropdown_country.selectByValue(prop.getProperty("country_value"));
        InputMobilePhone.sendKeys(prop.getProperty("mobile_no"));
        BtnSubmitAccount.click();
        BtnCheckoutAddressTab.click();
        CheckboxAgree.click();
        BtnCheckoutShippingTab.click();
        BtnPayByBankWire.click();
        BtnConfirmOrder.click();
    }

    public String verifyTotalOrderAmount(){
        String total_amount = DivTotalAmount.getText();
        System.out.println("-"+total_amount+"-");
        return total_amount;
    }
    public String verifyAccountDetails(){
        String account_details = DivAccountDetails.getText();
        System.out.println("-"+account_details+"-");
        return account_details;
    }
    public String verifyBankName(){
        String bank_name = DivBankName.getText();
        System.out.println("-"+bank_name+"-");
        return bank_name;
    }

    public void verifyClickOnCustomerAccount(){
        DivViewMyCustomerAccount.click();
    }

    public void verifyClickOnOrderHistory(){
        DivViewMyOrder.click();
    }

    public String verifyTotalAmountFromOrderHistory(){
        String amount_order_history = DivAmountOrderHistoryTable.getText();
        return amount_order_history;
    }

    public void LogOut(){
        BtnLogOut.click();
    }
}
