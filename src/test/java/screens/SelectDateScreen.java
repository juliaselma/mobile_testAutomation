package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class SelectDateScreen extends BaseScreen {
    public SelectDateScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.ImageButton/following-sibling::android.widget.TextView")
    private AndroidElement pickDate;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDatesSelectionCalendarApplyTextView\")")
    private AndroidElement confirmDateButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"octubre\")]/following-sibling::android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[6]")
    private AndroidElement arrivalDate;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"octubre\")]/following-sibling::android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[3]")
    private AndroidElement departureDate;


    public boolean checkSeleccionarFechas() {
        return pickDate.isDisplayed();
    }
    public boolean checkButtonDisabled() {
        return (!confirmDateButton.isEnabled());
    }
    public void pickArrivalDate() {
        scrollToText("octubre de 2021");
        click(arrivalDate);
    }
    public void pickDepartureDate() {
        click(departureDate);
    }
    public SelectedSearchScreen confirmDate(){
        click(confirmDateButton);
        return new SelectedSearchScreen(driver);
    }
}
