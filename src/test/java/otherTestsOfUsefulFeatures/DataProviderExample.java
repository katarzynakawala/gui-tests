package otherTestsOfUsefulFeatures;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import travelAgency.helpers.TestListener;

@Listeners(TestListener.class)

public class DataProviderExample {

    //not very smart test which shows quite simple examle of @DataProvider useful for small "data driven development"

    @Test(dataProvider = "getData")
    public void notVerySmartTest(String username, String password){
        System.out.println("Logging test");
        System.out.println("Username " + username);
        System.out.println("Password " + password);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{"username1", "password1"},{"username2", "password2"}};
    }
}
