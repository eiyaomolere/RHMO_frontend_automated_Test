package utility;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

import static utility.Utility.fetchvalue;

public class OptionsManager {

    ChromeOptions co;
    FirefoxOptions fo;

    /**
     * This method is used to set the chrome option
     */
    public ChromeOptions getChromeOptions(){
        co = new ChromeOptions();
        if(Boolean.parseBoolean(fetchvalue("headless"))) co.addArguments("--headless");
        if(Boolean.parseBoolean(fetchvalue("incognito"))) co.addArguments("--incognito");
        if(Boolean.parseBoolean(fetchvalue("PopUp"))) co.addArguments("disable-notifications");

        if(Boolean.parseBoolean(fetchvalue("remote"))) {
            co.setBrowserVersion(fetchvalue("browserversion"));
            co.setPlatformName("linux");
            co.setCapability("enableVNC", true);
        }
        return co;
    }

    /**
     * This method is used to set the firefox option
     */
    public FirefoxOptions getFirefoxOptions(){
        fo = new FirefoxOptions();
        if(Boolean.parseBoolean(fetchvalue("headless"))) fo.addArguments("--headless");
        if(Boolean.parseBoolean(fetchvalue("incognito"))) fo.addArguments("--incognito");
        if(Boolean.parseBoolean(fetchvalue("PopUp"))) fo.addArguments("disable-notifications");

        if(Boolean.parseBoolean(fetchvalue("remote"))) {
            co.setBrowserVersion(fetchvalue("browserversion"));
            co.setPlatformName("linux");
            co.setCapability("enableVNC", true);
        }

        return fo;
    }

}