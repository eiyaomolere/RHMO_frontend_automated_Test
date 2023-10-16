package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.DB_Operations;
import utility.OptionsManager;
import utility.testrail.TestRailHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static utility.Utility.fetchvalue;

public class TestBase_daara {

    public TestRailHandler trh;

    String testrailusername = System.getenv("TESTRAIL_USERNAME") != null ? System.getenv("TESTRAIL_USERNAME")
            : fetchvalue("TESTRAIL_USERNAME");
    String testrailpassword = System.getenv("TESTRAIL_PASSWORD") != null ? System.getenv("TESTRAIL_PASSWORD")
            : fetchvalue("TESTRAIL_PASSWORD");
    String testrailurl = System.getenv("TESTRAIL_URL") != null ? System.getenv("TESTRAIL_URL")
            : fetchvalue("TESTRAIL_URL");
    public static DB_Operations d;

    public OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> getdriver = new ThreadLocal<>();

    @BeforeClass
    public void PageObject() {
        d = new DB_Operations();
    }

    @BeforeTest(alwaysRun = true)
    public void SetUp() {

        optionsManager = new OptionsManager();

        switch (fetchvalue("BrowserName")) {
            case "Chrome":
                getdriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

                break;

            case "RemoteChrome":
                try {
                    getdriver.set(new RemoteWebDriver(new URL(fetchvalue("RemoteURL")), optionsManager.getChromeOptions()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "Firefox":
                getdriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                break;

            case "RemoteFirefox":
                try {
                    getdriver.set(new RemoteWebDriver(new URL(fetchvalue("RemoteURL")), optionsManager.getFirefoxOptions()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }

        getdriver.get().manage().window().maximize();

        getdriver.get().get(fetchvalue("admin_url"));
        getdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(fetchvalue("PageLoad.wait"))));
        getdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(fetchvalue("implicit.wait"))));

    }

    @AfterTest(alwaysRun = true)
    public void Quit() {
        try {
            if (getdriver.get() != null)
                getdriver.get().quit();
        } catch (Exception ignored) {
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void LinkTestrail() {
        {
            try {
                trh = new TestRailHandler(testrailusername, testrailpassword, testrailurl);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
