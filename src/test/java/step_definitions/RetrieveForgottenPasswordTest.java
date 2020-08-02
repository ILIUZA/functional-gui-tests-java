package step_definitions;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.ForgotPasswordPage;
import pageobjects.EmailSentPage;

public class RetrieveForgottenPasswordTest {

    WebDriver driver;

    public RetrieveForgottenPasswordTest()
    {
        driver = hookTest.driver;
    }

    @Given("^I am on the Forgot Password page$")
    public void i_am_on_forgot_password_page() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.forgotPasswordPageURL());
    }

    @When("^I enter email (.*)$")
    public void i_enter_email(String emailAddress) {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.setEmailAddress(emailAddress);

    }

    @When("^I press the button to retrieve password$")
    public void i_press_button_to_retrieve_password() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickRetrievePasswordButton();

    }
    @Then("^I am on the Email_sent page$")
    public void i_am_on_email_sent_page() {
        EmailSentPage emailSentPage = new EmailSentPage(driver);
        assertEquals(emailSentPage.emailSentPageURL(), driver.getCurrentUrl());
    }

    //According to the task I have to store the text of the result message in a variable
    public static String getVariableYouWantToUse() {
        return message_to_save;
    }
    private static String message_to_save;

    @Then("^I see the message \"([^\"]*)\"$")
    public void i_see_message(String expectedMessage) {
        EmailSentPage emailSentPage = new EmailSentPage(driver);
        message_to_save = emailSentPage.getEmailSentMessage();
        //System.out.println(message_to_save);
        assertTrue(message_to_save.contains(expectedMessage));
    }


}

