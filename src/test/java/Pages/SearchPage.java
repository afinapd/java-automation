package Pages;

import Data.FormData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class SearchPage {
    WebDriver driver;

    By search_button = By.cssSelector(".site-header__item--desktop > .site-header__button");
    By search_field = By.id("search-input--desktop");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchButton(){
        driver.findElement(search_button).click();
    }

    public void setSearchInput(String keyword) throws InterruptedException {
        driver.findElement(search_field).isEnabled();
        driver.findElement(search_field).sendKeys(keyword);
        driver.findElement(search_field).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        FormData.setKeyword(keyword);
    }
}
