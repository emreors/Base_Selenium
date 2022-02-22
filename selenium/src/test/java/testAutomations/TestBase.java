package testAutomations;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Created by Emre Örs
 * Date : 09.01.2022
 */


public class TestBase extends TestCase {

    protected static WebDriver driver;
    protected static FluentWait<WebDriver> Fwait;
    protected static final String SERVIS_ADRESI = "https://hepsiburada.com/";
    protected String servisAdresi = SERVIS_ADRESI;
    protected static final Logger Logger = LoggerFactory.getLogger(TestBase.class);
    protected JavascriptExecutor scroll;
    protected StringBuffer verificationErrors = new StringBuffer();
    ChromeOptions options = new ChromeOptions();

    @Before
    public void setUp() throws IOException {
        Locale.setDefault(new Locale("tr", "TR"));
        driver = new ChromeDriver();
        Logger.info("setUp(servisAdresi=" + servisAdresi + ").");
        Fwait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);
        scroll = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        options.addArguments("-incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();
        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 0);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.get(servisAdresi);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
