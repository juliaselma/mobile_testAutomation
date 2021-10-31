package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class LandingScreen extends BaseScreen{
    public LandingScreen (AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/largeLabel\")")
    private AndroidElement navigation;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\")")
    private AndroidElement confirmPrivacyButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHomeExpandedDealformDestinationTextView\")")
    private AndroidElement formDestination;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/action_home\")")
    private AndroidElement busquedaButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/action_discover\")")
    private AndroidElement sorprendeteButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/action_favourites\")")
    private AndroidElement favoritosButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/action_settings\")")
    private AndroidElement configuracionButton;



    public String checkBeingInLandingPage(){
        return navigation.getText();
    }

    public boolean checkPrivacyNotVisible(){
       return confirmPrivacyButton.isDisplayed();
    }

    public FillInDestinationPage goTofillInDestination() {
        click(formDestination);
        return new FillInDestinationPage(driver);
    }

    public boolean checkBusquedaNavBr(){
        return busquedaButton.isDisplayed();
    }
    public boolean checkSorprendeteNavBr(){
        return sorprendeteButton.isDisplayed();
    }
    public boolean checkFavsNavBr(){
        return favoritosButton.isDisplayed();
    }
    public boolean checkConfigNavBr(){
        return configuracionButton.isDisplayed();
    }

    public ConfigScreen clickConfigButton(){
        click(configuracionButton);
        return new ConfigScreen(driver);
    }

}
