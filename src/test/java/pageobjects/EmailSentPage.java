package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//The page that is open after clicking on the button to retrieve password
public class EmailSentPage extends BasePage{
    public EmailSentPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    By emailSentMessage = By.id("content");

    //EmailSentPage URL
    public String emailSentPageURL() {
        return baseURL + "/email_sent";
    }

    //Get message we see after sending email to retrieve password
    public String getEmailSentMessage() {
        return readText(emailSentMessage);
    }
}
