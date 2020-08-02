package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    //Web Elements
    By email = By.id("email");
    By retrieveButton = By.id("form_submit");

    //ForgotPasswordPage URL
    public String forgotPasswordPageURL() {
        return baseURL + "/forgot_password";
    }
    //Enter email in the input
    public void setEmailAddress (String emailAddress){
        writeText(email, emailAddress);
    }
    //After clicking on the button email_sent page opens (or page with an error message)
    public void clickRetrievePasswordButton () {
       click(retrieveButton);
    }
}

