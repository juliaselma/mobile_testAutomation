package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class PrivacyConfigScreen extends BaseScreen{
    public PrivacyConfigScreen (AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerTitleTextView\")")
    private AndroidElement titleText;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerAppsFlyerCheckbox\")")
    private AndroidElement appsFlyerCheckBox;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFirebaseCheckbox\")")
    private AndroidElement firebaseCheckBox;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFacebookCheckbox\")")
    private AndroidElement facebookCheckBox;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerLearnMoreTextView\")")
    private AndroidElement learnMoreText;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerSaveButton\")")
    private AndroidElement saveConfigButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\")")
    private AndroidElement goBackButton;


    public String checkTitle(){
        return titleText.getText();
    }

    public String appsFlyerIsChecked(){
        return appsFlyerCheckBox.getAttribute("checked");
    }


    public ConfigScreen changeConfiguration(){
        click(appsFlyerCheckBox);
        click(firebaseCheckBox);
        click(facebookCheckBox);
        click(saveConfigButton);
        return new ConfigScreen(driver);
    }

    public ConfigScreen ClickGoBack(){
        click(goBackButton);
        return new ConfigScreen(driver);
    }

    public String learnMoreText(){
        return learnMoreText.getText();
    }
    public boolean checkEnableButton(){
        return saveConfigButton.isEnabled();
    }

}
