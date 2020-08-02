package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

//All the Page Test Classes use hookTest to prepare an environment and clean it after.
public class hookTest {

    public static WebDriver driver;

    @Before public void setUp(){
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

   @After public void cleanUp(){
       driver.quit();
    }
}
