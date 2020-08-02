package step_definitions;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import pageobjects.SecurePage;

public class LoginTest {
    public WebDriver driver;

    public LoginTest()
    {
        //setUp and cleanUP functions
        driver = hookTest.driver;
    }

    @Given("^I am on the Login page$")
    public void i_am_on_login_page() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(loginPage.loginPageURL());
    }

    @When("^I enter credentials (.*) and (.*)$")
    public void i_enter_credentials(String username,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentials(username, password);
    }

    @When("^I press the button to login$")
    public void i_press_button_to_login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("^I see the success message contains \"([^\"]*)\"$")
    public void i_see_success_message( String expectedMessage) {
        SecurePage securePage = new SecurePage(driver);
        String successfulMessage = securePage.getSuccessMessage();
        assertTrue(successfulMessage.contains(expectedMessage));
    }

    @Then("^I see the error message contains \"([^\"]*)\"$")
    public void i_see_error_message( String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        String errorMessage = loginPage.getErrorPasswordMessage();
        assertTrue(errorMessage.contains(expectedMessage));
    }

    @Then("^I am on Login page$")
    public void i_am_on_login_page_check() {
        LoginPage loginPage = new LoginPage(driver);
        assertEquals(loginPage.loginPageURL(), driver.getCurrentUrl());

    }

    @Then("^I am on Secure page$")
    public void i_am_on_secure_page_check() {
        SecurePage securePage = new SecurePage(driver);
        assertEquals(securePage.securePageURL(), driver.getCurrentUrl());

    }
}
