package com.automationpractice.qa.base;

import com.automationpractice.qa.Utils.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

        // Global variables: Can be used inside constructor, methods in parent and child classes also
        public static WebDriver driver;
        // intialized prop variable
        public static Properties prop;

        // constructor name is classname
        public TestBase(){

            // read properties from config/config.properties
            try{
                prop = new Properties();
                FileInputStream input = new FileInputStream("C:\\Users\\kafle\\IdeaProjects\\AutomationAssignment\\src\\main\\java\\com\\automationpractice\\qa\\config\\config.properties");
                prop.load(input);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        public static void initialization(){
            String browserName = prop.getProperty("browser");
            if(browserName.equals("chrome")){
                // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            }
            else if(browserName.equals("FF")){
                // System.setProperty("webdriver.gekco.driver", "geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));

        }
}
