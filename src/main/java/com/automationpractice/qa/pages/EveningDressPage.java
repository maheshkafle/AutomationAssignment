package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressPage extends TestBase {

    @FindBy(xpath = "//span[@class='cat-name']")
    WebElement titleEveningDressDiv;

    // Initializing the Page Objects
    public EveningDressPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyEveningDressPageTitle(){
        String divEveningDressTitleText = titleEveningDressDiv.getText();
        return divEveningDressTitleText;
    }

}
