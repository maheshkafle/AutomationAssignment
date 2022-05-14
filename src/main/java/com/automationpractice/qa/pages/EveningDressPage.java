package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressPage extends TestBase {

    @FindBy(xpath = "//span[@class='cat-name']")
    WebElement titleEveningDressDiv;

    @FindBy(xpath = "//a[@title='Printed Dress']")
    WebElement PrintedDressCard;

    @FindBy(xpath = "//a[@title='View']")
    WebElement BtnViewMore;


    // Initializing the Page Objects
    public EveningDressPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyEveningDressPageTitle(){
        String divEveningDressTitleText = titleEveningDressDiv.getText();
        return divEveningDressTitleText;
    }

    public PrintedDressPage NavigateToPrintedDressPage(){
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Actions action = new Actions(driver);
        action.moveToElement(PrintedDressCard).build().perform();
        action.moveToElement(BtnViewMore).build().perform();
        BtnViewMore.click();
        return new PrintedDressPage();
    }
}
