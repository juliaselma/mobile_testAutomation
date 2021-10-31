package screens;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class LanguageScreen extends BaseScreen{

    public LanguageScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"Colombia\")]/following-sibling::android.widget.RadioButton")
    private AndroidElement espaniolColombiaLanguage;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Confirm\")")
    private AndroidElement confirmLanguageButton;

    public PrivacyTermsScreen selectEspaniolLanguage(){
        scrollToText("Colombia");
        click(espaniolColombiaLanguage);
        click(confirmLanguageButton);
        return new PrivacyTermsScreen(driver);
    }
}
