package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedDressPage extends TestBase {

    @FindBy(xpath = "//h1[text()='Printed Dress']")
    WebElement titlePrintedDressDiv;

    @FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']//span")
    WebElement BtnUpdateQty;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement dropdownListSize;

    @FindBy(xpath = "//a[@id='color_24']")
    WebElement btnSelectPinkColor;

    @FindBy(xpath = "//button[@class='exclusive']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElement btnContinueShopping;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement btn_women;

    //Initializing the Page Objects
    public PrintedDressPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyPrintedDressPageTitle(){
        String divPrintedDressTitleText = titlePrintedDressDiv.getText();
        return divPrintedDressTitleText;
    }

    public CategoryPage VerifyNavigateToCategoryPage() {
        BtnUpdateQty.click();
        Select dropdown_opt = new Select(dropdownListSize);
        dropdown_opt.selectByValue("3");
        btnSelectPinkColor.click();
        btnAddToCart.click();
        btnContinueShopping.click();
        btn_women.click();

        return new CategoryPage();
    }
}
