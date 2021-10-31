package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class SelectedSearchScreen extends BaseScreen{

    public SelectedSearchScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHotelSearchResultsExpandedDealformDestinationTextView\")")
    private AndroidElement searchViewDestination;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHotelSearchResultsExpandedDealformCalendarTextView\")")
    private AndroidElement searchViewDates;

    public String checkDestinationText(){
        customWait.waitAndroidElementVisibility(driver,searchViewDestination, 5);
        return searchViewDestination.getText();
    }
    public String checkDatesText(){
        return searchViewDates.getText();
    }


}
