package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    By search_button = By.cssSelector(".site-header__item--desktop > .site-header__button");
    By search_field = By.id("search-input--desktop");
    By title_article = By.xpath("//span[@class='gray-card__heading h5']");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchButton(){
        driver.findElement(search_button).click();
    }

    public void setSearchInput(String keyword) {
        driver.findElement(search_field).isEnabled();
        driver.findElement(search_field).sendKeys(keyword);
        driver.findElement(search_field).sendKeys(Keys.ENTER);
    }

    public List<WebElement> getTitleArticle(){
        List<WebElement> searchResult = driver.findElements(title_article);
        return searchResult;
    }
}
