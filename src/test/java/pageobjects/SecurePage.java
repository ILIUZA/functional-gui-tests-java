package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//The Secure Page opens if login is successful
public class SecurePage extends BasePage {
    public SecurePage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    By successMessage = By.cssSelector("div#flash.flash.success");

    //SecurePage URL
    public String securePageURL() {
        return baseURL + "/secure";
    }

    //If login is successful a success message displays
    public String getSuccessMessage() {
        return readText(successMessage);
    }
}
