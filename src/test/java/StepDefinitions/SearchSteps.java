package StepDefinitions;

import PageObjects.SearchPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class SearchSteps {
    protected WebDriver driver = Driver.getDriver();
    SearchPage SearchPage = new SearchPage(driver);
    
    @Given("user visits the Verint website")
    public void visit_website(){
        driver.get("https://www.verint.com/");
    }

    @When("click the search button")
    public void click_search_button() {
        SearchPage.clickSearchButton();
    }

    @And("search with {string} keyword")
    public void set_search(String keyword) {
        SearchPage.setSearchInput(keyword);
    }

    @Then("article contains that {string} appears")
    public void use_logiaan(String keyword) throws InterruptedException {
        Thread.sleep(5000); // handle race condition
//        List<WebElement> searchResult = SearchPage.getTitleArticle();
        if(SearchPage.getTitleArticle().size() != 0) {
            for(WebElement result : SearchPage.getTitleArticle()) {
                System.out.println(result.getAttribute("innerHTML"));
                Assert.assertTrue(result.getAttribute("innerHTML").toLowerCase().contains(keyword.toLowerCase()));
            }
        }
        driver.close();
        driver.quit();
    }
}
