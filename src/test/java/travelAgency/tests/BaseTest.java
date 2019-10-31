package travelAgency.tests;

import drivers.DriverFactory;
import drivers.DriverType;
import drivers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws NoSuchDriverException {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }
}