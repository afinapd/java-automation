package StepDefinitions;

import Data.FormData;
import Pages.SearchPage;
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

import static java.lang.Thread.sleep;


public class SearchSteps {
    protected WebDriver driver = Driver.getDriver();
    SearchPage SearchPage = new SearchPage(driver);
    
    @Given("user visits the Verint website")
    public void use_login(){
        driver.get("https://www.verint.com/");
    }

    @When("click the search button")
    public void use_logiana() {
        SearchPage.clickSearchButton();
    }

    @And("search with {string} keyword")
    public void use_logian(String keyword) throws InterruptedException {
        SearchPage.setSearchInput(keyword);
    }

    @Then("article contains that keyword appears")
    public void use_logiaan() {
       List<WebElement> searchResult = driver.findElements(By.xpath("//span[@class='gray-card__heading h5']"));
	   if(searchResult.size() != 0)
	   {
		   System.out.println(searchResult.size() + " Elements found by TagName as input \n");

		   for(WebElement result : searchResult)
		   {
               result.getAttribute("innerHTML").contains("news");
		   }
	   }
        driver.close();
        driver.quit();
    }
}
