package utility;

import Base.TestBase_admin_portal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLink  {

    private static WebDriver driver;

    public BrokenLink(WebDriver driver) {
        BrokenLink.driver = driver;
    }


    public static void BrokenLink() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + links.size());
        for (WebElement element : links) {
            String url = element.getAttribute("href");
            verifyLink(url);
        }
    }

    public static void verifyLink(String urlLink) {
        try {
            URL link = new URL(urlLink);
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            Assert.assertEquals(httpConn.getResponseCode(),200);
            System.out.println(urlLink + ":::: is a Valid link ::::" + httpConn.getResponseCode() + " " + httpConn.getResponseMessage());
        } catch (Exception ignored) {
        }
    }
}