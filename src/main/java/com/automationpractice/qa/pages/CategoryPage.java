package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage extends TestBase {

    @FindBy(xpath = "//p[@class='subcategory-heading']")
    WebElement titleCategoryPageDiv;

    @FindBy(xpath = "//a[@title='Printed Chiffon Dress']")
    WebElement PrintedChiffonDressCard;

    @FindBy(xpath = "//button[@class='exclusive']")
    WebElement BtnAddToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement BtnProceedToCheckout;

    //Initializing the Page Objects
    public CategoryPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyCategoryPageTitle(){
        String titleCategoryPageDivText = titleCategoryPageDiv.getText();
        return titleCategoryPageDivText;
    }

    public CartSummaryPage verifyNavigateToCartSummaryPage(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='center_column']/ul"));

        for(int i=0; i<list.size(); i++) {
//            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Chiffon")){
                JavascriptExecutor jsx = (JavascriptExecutor)driver;
                jsx.executeScript("arguments[0].scrollIntoView();", PrintedChiffonDressCard);
                Actions action = new Actions(driver);
                action.moveToElement(list.get(i)).build().perform();
                action.moveToElement(PrintedChiffonDressCard).build().perform();
                PrintedChiffonDressCard.click();
                BtnAddToCart.click();
                BtnProceedToCheckout.click();
                break;
            }
        }

        return new CartSummaryPage();
    }
}
