package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.LargePage;

public class LargeTest {

    public WebDriver driver;
    //WebDriver driver;

    public LargeTest()
    {
        //setUp and cleanUP functions
        driver = hookTest.driver;
    }

    @Given("^I am on the Large page$")
    public void i_am_on_login_page() {
        LargePage largePage = new LargePage(driver);
        driver.get(largePage.largePageURL());
    }


    @When("^I select the following rows$")
    public void i_select_rows(DataTable dt) {
        //select and highlight rows
        LargePage largePage = new LargePage(driver);
        largePage.highlightListItems(dt);
    }

    @When("^I select the following headers$")
    public void i_select_headers(DataTable dt) {
        //select and highlight headers
        LargePage largePage = new LargePage(driver);
        largePage.highlightHeaders(dt);
    }
}
