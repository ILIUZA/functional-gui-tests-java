package pageobjects;

import cucumber.api.DataTable;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LargePage extends BasePage{
    public LargePage(WebDriver driver) {
        super(driver);
    }

    // LargePage URL
    public String largePageURL() {
        return baseURL + "/large";
    }

    // 1. Take data from scenario
    // 2. In a loop:
    // 2.1. Create a locator for an element (by its id from scenario).
    // 2.2. Find the element using ID
    // 2.3.Highlight the found element using JavascriptExecutor
    // Problem: if an element has a class=parent it works incorrectly.
    // Idea to solve: change DOM, add <span> and apply JavascriptExecutor for them.

    public void highlightListItems(DataTable dt) {
        List<String> data=dt.asList(String.class);
        for (String datum : data) {
            String id_to_search = "sibling-" + datum;
            WebElement element = driver.findElement(By.id(id_to_search));

            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 2px solid Magenta;");
        }
    }

    // 1. Take data from scenario
    // 2. In a loop:
    // 2.1. Create a locator for an element -- xpath (by its text from scenario).
    // 2.2. Find the element using xpath
    // 2.3.Highlight the found element using JavascriptExecutor
    public void highlightHeaders (@NotNull DataTable dt) {
        List<String> data=dt.asList(String.class);

        for (String datum : data) {
            String xpath_element = "//h4[text()='" + datum + "']";

            WebElement element = driver.findElement(By.xpath(xpath_element));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 2px solid Magenta;");

        }
    }

}
