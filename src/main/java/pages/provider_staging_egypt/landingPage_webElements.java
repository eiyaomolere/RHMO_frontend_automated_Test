package pages.provider_staging_egypt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import utility.ActionClassUtil;
import utility.ElementUtil;
import utility.JavaScriptUtil;
import java.io.IOException;

public class landingPage_webElements {

    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;

    ActionClassUtil ac;

    //Social Icons
    @FindBy(xpath = "//*[@id=\"header\"]/nav/ul/li[1]")
    @CacheLookup
    private WebElement twitter;
    @FindBy(css = "#header > nav > ul > li:nth-child(1) > a")
    @CacheLookup
    private WebElement validTwitter;
    @FindBy(xpath = "//*[@id=\"header\"]/nav/ul/li[2]/a")
    @CacheLookup
    private WebElement facebook;
    @FindBy(xpath = "//h1[normalize-space()='Reliance Health Egypt']")
    @CacheLookup
    private WebElement validFacebook;
    @FindBy(xpath = "//a[@class='icon fa-instagram']")
    @CacheLookup
    private WebElement instagram;
    @FindBy(xpath = "//a[@class='icon fa-envelope-o']")
    @CacheLookup
    private WebElement mail;

    @FindBy(xpath = "//div[@aria-label='Close']")
    @CacheLookup
    private WebElement lom;


    //TODO: What does it do?
    public landingPage_webElements(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void validFacebook() throws IOException {
        javaScriptUtil.waitForPageLoad();
        String fbk = (facebook).getAttribute("href");
        System.out.println(fbk);
        (facebook).click();
        lom.click();
        String validMessage = (validFacebook).getText();
        Assert.assertEquals(validMessage, "Reliance Health Egypt");

    }

    public void validInstagram() throws IOException {
        javaScriptUtil.waitForPageLoad();
        String socials = (instagram).getAttribute("href");
        System.out.println(socials);

    }

    public void validMail() throws IOException {
        javaScriptUtil.waitForPageLoad();
        String M = (mail).getAttribute("href");
        System.out.println(M);

    }

    public void validTwitter() throws IOException {
        javaScriptUtil.waitForPageLoad();
        String url = (twitter).getAttribute("href");
        String txt = (validTwitter).getAttribute("href");
        System.out.println(txt);
        System.out.println(url);

    }
}
