package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class FillInDestinationPage extends BaseScreen{

    public FillInDestinationPage (AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activitySearchDestinationSearchEditText\")")
    private AndroidElement formDestination;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private AndroidElement selectedCity;

    public SelectDateScreen enterDestination (String destination){
        sendKeys(formDestination, destination);
        click(selectedCity);
        return new SelectDateScreen(driver);
    }

}
