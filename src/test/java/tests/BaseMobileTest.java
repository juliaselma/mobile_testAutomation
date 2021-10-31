package tests;


import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import screens.LandingScreen;
import screens.LanguageScreen;
import utils.ConfigCapabilities;


public abstract class BaseMobileTest {

    protected LanguageScreen languageScreen;
    protected LandingScreen landingScreen;
    public static AndroidDriver<AndroidElement> driver;
    public Logger log = Logger.getLogger(BaseMobileTest.class);

    public void setUpStartApp() {
        languageScreen = new LanguageScreen(getDriver());
    }

    @BeforeClass(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }


    @AfterClass(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }


    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }


}

