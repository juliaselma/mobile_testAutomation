package tests;

import org.testng.annotations.Test;
import screens.LandingScreen;
import screens.PrivacyTermsScreen;

import static org.testng.Assert.assertTrue;

public class RedirectingToLandingTests extends BaseMobileTest {

    @Test
    public void redirectedToLandingChecked(){
        log.info("Initializing app");
        setUpStartApp();
        log.info("Selecting language");
        PrivacyTermsScreen privacidadScreen = languageScreen.selectEspaniolLanguage();
        log.info("accepting privacy terms");
        LandingScreen landingScreen = privacidadScreen.acceptPrivacyTerms();

        log.info("Testing langing page");
        System.out.println(landingScreen.checkBeingInLandingPage());
        assertTrue(landingScreen.checkBeingInLandingPage().contains("Búsqueda"),
                "Text is incorrect");
        assertTrue(landingScreen.checkPrivacyNotVisible());
    }
}
