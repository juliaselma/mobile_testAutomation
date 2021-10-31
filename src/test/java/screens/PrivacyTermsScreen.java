package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class PrivacyTermsScreen extends BaseScreen{

    public PrivacyTermsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\")")
    private AndroidElement confirmPrivacyButton;


    public LandingScreen acceptPrivacyTerms(){
        isElementAvailable(confirmPrivacyButton);
        click(confirmPrivacyButton);
        return new LandingScreen(driver);
    }

}
