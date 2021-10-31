package tests;

import org.testng.annotations.Test;
import screens.LandingScreen;
import screens.PrivacyTermsScreen;

import static org.testng.Assert.assertTrue;

public class NavBarTests extends BaseMobileTest{

    @Test
    public void NavBarElementsChecked(){
        log.info("Initializing app");
        setUpStartApp();
        log.info("Selecting language");
        PrivacyTermsScreen privacidadScreen = languageScreen.selectEspaniolLanguage();
        log.info("Accepting privacy terms");
        LandingScreen landingScreen = privacidadScreen.acceptPrivacyTerms();

        log.info("Testing navbar elements existence ");
        assertTrue(landingScreen.checkBusquedaNavBr(),"búsqueda element in not displayed");
        assertTrue(landingScreen.checkSorprendeteNavBr(),"Sorprendete element in not displayed");
        assertTrue(landingScreen.checkFavsNavBr(),"Favs element in not displayed");
        assertTrue(landingScreen.checkConfigNavBr(),"Config element in not displayed");

    }

}
