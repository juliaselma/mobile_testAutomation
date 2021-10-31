package tests;

import org.testng.annotations.Test;
import screens.*;

import static org.testng.Assert.assertTrue;

public class HotelsSearchTests extends BaseMobileTest {

    @Test(dataProvider = "TestData",dataProviderClass = utils.NewSearchProvider.class)
    public void searchHotelsFunctionality (String destination, String dates){
        log.info("Initializing app");
        setUpStartApp();
        log.info("Selecting language");
        PrivacyTermsScreen privacidadScreen = languageScreen.selectEspaniolLanguage();
        log.info("Accepting privacy terms");
        LandingScreen landingScreen = privacidadScreen.acceptPrivacyTerms();
        log.info("selecting destination and dates");
        FillInDestinationPage fillInDestinationPage = landingScreen.goTofillInDestination();
        SelectDateScreen selectDateScreen =fillInDestinationPage.enterDestination(destination);

        assertTrue(selectDateScreen.checkSeleccionarFechas());
        selectDateScreen.pickArrivalDate();

        log.info("Testing search");
        assertTrue(selectDateScreen.checkButtonDisabled());
        selectDateScreen.pickDepartureDate();
        SelectedSearchScreen selectedSearchScreen =selectDateScreen.confirmDate();

        assertTrue(selectedSearchScreen.checkDestinationText()
                        .contains(destination),
                "Destination is incorrect");
        assertTrue(selectedSearchScreen.checkDatesText()
                        .contains(dates),
                "date is incorrect");

    }
}
