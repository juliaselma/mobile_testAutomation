package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class ConfigScreen extends BaseScreen{
    public ConfigScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentSettingsManageMyDataTextView\")")
    private AndroidElement privacyConfigButton;

    public boolean checkPrivacyLinkDesplayed(){
        return privacyConfigButton.isDisplayed();
    }

    public PrivacyConfigScreen clickConfigurarPrivacidad(){
        click(privacyConfigButton);
        return new PrivacyConfigScreen(driver);
    }

}
