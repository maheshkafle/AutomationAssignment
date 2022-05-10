package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // PageFactory / Object Repositories / Collection of WebElements
    @FindBy(xpath="//li[@class='sfHoverForce sfHover']//a[@title='Dresses'][normalize-space()='Dresses']")
    WebElement Dresses;

    @FindBy(xpath="//li[@class='sfHover']//a[@title='Evening Dresses'][normalize-space()='Evening Dresses']")
    WebElement EveningDresses;

    // Initializing Page Objects with Constructor
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateLoginPageTitle()  {
        return driver.getTitle();
    }

    public EveningDressPage login(String uname, String pwd){

        Actions action  = new Actions(driver);
        action.moveToElement(Dresses).perform();

        return new EveningDressPage();
    }





}
