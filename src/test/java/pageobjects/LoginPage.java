package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    By user = By.id("username");
    By pass = By.id("password");
    By loginButton = By.cssSelector("button.radius");
    By invalidPasswordMessage = By.cssSelector("div#flash.flash.error");

    //LoginPage URL
    public String loginPageURL() {
        return baseURL + "/login";
    }

    public void setCredentials(String username, String password){
        //Enter Username
        writeText(user,username);
        //Enter Password
        writeText(pass, password);
    }
    //After clicking the Login Button the Secure Page opens OR an error message displays
    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorPasswordMessage () {
        return readText(invalidPasswordMessage);
    }


}
