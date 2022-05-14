package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartSummaryPage extends TestBase {

    @FindBy(xpath = "//h1[@id='cart_title']")
    WebElement DivCartSummaryPageTitle;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement BtnProceedToCheckout;

    @FindBy(xpath = "//a[@id='cart_quantity_down_4_45_0_0']")
    WebElement BtnProductMinus;

    //Initializing the Page Objects
    public CartSummaryPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyCartSummaryPageTitle(){
        String titleCategoryPageDivText = DivCartSummaryPageTitle.getText();
        return titleCategoryPageDivText;
    }

    public RegistrationPage verifyNavigateToRegistrationPage(){
       BtnProductMinus.click();
       BtnProceedToCheckout.click();
       return new RegistrationPage();
    }


}
