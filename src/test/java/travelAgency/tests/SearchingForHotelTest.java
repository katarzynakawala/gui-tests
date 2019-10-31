package travelAgency.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import travelAgency.helpers.SeleniumHelpers;
import travelAgency.pages.HomePage;
import travelAgency.pages.ResultPage;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchingForHotelTest extends BaseTest {

    @Test
    public void searchHotelTest() {
        driver.get("https://www.phptravels.net/");
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage
                .setCityHotel("Dubai")
                .setDateRange("12/20/2019", "12/29/2019")
                .openTravellersModal()
                .addAdult()
                .addChild()
                .performSearch();

        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));


        List<String> prices = resultPage.getHotelPrices();
        Assert.assertEquals("$22", prices.get(0));
        Assert.assertEquals("$50", prices.get(1));
        Assert.assertEquals("$80", prices.get(2));
        Assert.assertEquals("$150", prices.get(3));

    }
}