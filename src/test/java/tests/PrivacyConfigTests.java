package tests;

import org.testng.annotations.Test;
import screens.LandingScreen;
import screens.PrivacyConfigScreen;
import screens.PrivacyTermsScreen;
import screens.ConfigScreen;

import static org.testng.Assert.*;

public class PrivacyConfigTests extends BaseMobileTest {
    @Test

    public void PrivacyConfigChecked(){

        log.info("Initializing app");
        setUpStartApp();
        log.info("Selecting language");
        PrivacyTermsScreen privacyScreen = languageScreen.selectEspaniolLanguage();
        log.info("Accepting privacy terms");
        LandingScreen landingScreen = privacyScreen.acceptPrivacyTerms();

        log.info("Going to Configuration");
        ConfigScreen configScreen = landingScreen.clickConfigButton();
        log.info("Checking privacy link");
        assertTrue(configScreen.checkPrivacyLinkDesplayed());

        log.info("Going to: configurar privacidad");
        PrivacyConfigScreen privacyConfigScreen =configScreen.clickConfigurarPrivacidad();

        log.info("Testing page elements");
        assertTrue(privacyConfigScreen.checkTitle().contains("Puedes inhabilitar determinados tipos de procesamiento"));
        assertTrue(privacyConfigScreen.learnMoreText().contains("política de privacidad"),"Text is incorrect");
        assertTrue(privacyConfigScreen.checkEnableButton(),"Button is not enable");
        assertEquals(privacyConfigScreen.appsFlyerIsChecked(),"true");

        log.info("changing privacy configuration");
        ConfigScreen configScreen1 = privacyConfigScreen.changeConfiguration();
        PrivacyConfigScreen privacyConfigScreen1 =configScreen1.clickConfigurarPrivacidad();
        log.info("checking changes saved");
        assertEquals(privacyConfigScreen1.appsFlyerIsChecked(),"false");
        log.info("Checking 'go back button'");
        ConfigScreen configScreen2 = privacyConfigScreen1.ClickGoBack();
        assertTrue(configScreen2.checkPrivacyLinkDesplayed(),"You are not in configuration Screen");

    }

}
