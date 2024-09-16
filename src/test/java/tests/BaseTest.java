package tests;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {

    @BeforeClass
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(SettingsTestData.getEnvData().getHost());
    }

    @AfterClass
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
