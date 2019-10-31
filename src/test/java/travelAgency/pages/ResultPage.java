package travelAgency.pages;

import travelAgency.helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    private SeleniumHelpers helpers;

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        helpers = new SeleniumHelpers(driver);

    }

    public List<String> getHotelNames() {
        List<String> hotlelNames = new ArrayList<>();
        helpers.waitForListOfWebElements(resultsTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> hotelNameWebElements = resultsTable.findElements(By.xpath("//h4//b"));
        for (WebElement hotelNameElement : hotelNameWebElements) {
            System.out.println(hotelNameElement.getText());
            hotlelNames.add(hotelNameElement.getText());
        }
        return hotlelNames;
    }

    public List<String> getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        return hotelPrices.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
