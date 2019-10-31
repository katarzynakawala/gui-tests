package travelAgency.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import travelAgency.helpers.SeleniumHelpers;

public class HomePage {

    @FindBy(xpath ="//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement selectResult;

    private SeleniumHelpers helpers;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.helpers = new SeleniumHelpers(driver);
        this.driver = driver;
    }


    public HomePage setCityHotel(String cityName){
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        helpers.waitForElementToBeDisplayed(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage setDateRange(String checkInDate, String checkOutDate){
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
        return this;
    }

    public HomePage openTravellersModal(){
        travellersInput.click();
        helpers.waitForElementToBeDisplayed(adultPlusBtn);
        return this;
    }

    public HomePage addAdult(){
        adultPlusBtn.click();
        return this;
    }

    public HomePage addChild(){
        childPlusBtn.click();
        return this;
    }

    public ResultPage performSearch(){
        searchButton.click();
        return new ResultPage(driver);
    }
}