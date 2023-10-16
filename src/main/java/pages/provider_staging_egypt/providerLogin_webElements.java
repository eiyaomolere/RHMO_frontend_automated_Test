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

import static utility.ActionClassUtil.DoSendKeysActionClass;
import static utility.Utility.fetchvalue;

public class providerLogin_webElements {

    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    ActionClassUtil ac;
    String validEmail = System.getenv("validEmail") != null ? System.getenv("validEmail")
            : fetchvalue("validEmail");
    String validPassword = System.getenv("validPassword") != null ? System.getenv("validPassword")
            : fetchvalue("validPassword");

    //Login Elements
    @FindBy(xpath = "//h2[normalize-space()='Login']")
    @CacheLookup
    private WebElement loginButton;
    @FindBy(xpath = "//input[@placeholder='Email']")
    @CacheLookup
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    @CacheLookup
    private WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    @CacheLookup
    private WebElement submitButton;
    @FindBy(xpath = "//h1[normalize-space()='Dashboard']")
    @CacheLookup
    private WebElement validAlert;
    @FindBy(xpath = "//p[@role='alert']")
    @CacheLookup
    private WebElement invalidwarningAlert;


    //TODO: What does it do?
    public providerLogin_webElements(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void login() throws IOException {
        javaScriptUtil.waitForPageLoad();
        DoSendKeysActionClass(emailField, validEmail);
        DoSendKeysActionClass(passwordField, validPassword);
        (submitButton).click();
        String validMessage = (validAlert).getText();
        Assert.assertEquals(validMessage, "Dashboard");
    }

    public void invalidLogin() throws IOException {
        javaScriptUtil.waitForPageLoad();
        (loginButton).click();
        DoSendKeysActionClass(emailField, "gt@gmail.com");
        DoSendKeysActionClass(passwordField, "Password111x");
        (submitButton).click();
        String errorMessage = (invalidwarningAlert).getText();
        Assert.assertEquals(errorMessage, "incorrect credential, please try again");
        (emailField).clear();
        (passwordField).clear();
    }
}

