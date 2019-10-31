package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {

        if (driverInstance == null) {
            getSpecificDriver(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }


    private static void getSpecificDriver(DriverType driverType) throws NoSuchDriverException {

        switch (driverType) {
            case CHROME:
                //we will use builder for that
                File chromeExe = new File("/Users/katarzynakawala/Downloads/TravelAgencyTestsGUI/src/main/resources/executables/drivers/chromedriver");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new ChromeDriver(chromeService);
                break;

            case FIREFOX:
                File firefoxExe = new File("/Users/katarzynakawala/Downloads/TravelAgencyTestsGUI/src/main/resources/executables/drivers/geckodriver");
                GeckoDriverService geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new FirefoxDriver(geckoDriverService);
                break;

                default:
                System.out.println("There is no driver like that");
                throw new NoSuchDriverException();
        }
    }
}


