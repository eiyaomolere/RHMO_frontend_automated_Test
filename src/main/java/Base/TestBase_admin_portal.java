package Base;

import Listeners.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utility.DB_Operations;
import utility.OptionsManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static utility.Utility.fetchvalue;

public abstract class TestBase_admin_portal {

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

        getdriver.get().manage().window().fullscreen();

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
}