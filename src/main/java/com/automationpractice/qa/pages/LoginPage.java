package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // PageFactory | Object Repositories | Collection of WebElements
    @FindBy(xpath = "//a[@title='Women']")
    WebElement btn_women;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Evening Dresses']")
    WebElement link_hover_evening_dresses;

    // Initializing Page Objects with Constructor
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public EveningDressPage NavigateToEveningDressesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(btn_women).build().perform();
        action.moveToElement(link_hover_evening_dresses).build().perform();
        link_hover_evening_dresses.click();
        return new EveningDressPage();
    }


}
