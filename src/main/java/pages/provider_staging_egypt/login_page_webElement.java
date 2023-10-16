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
import java.util.Random;

import static utility.ActionClassUtil.DoSendKeysActionClass;
import static utility.Utility.fetchvalue;

public class login_page_webElement {

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




    //TODO: What does it do?
    public login_page_webElement(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void login_action() throws IOException, InterruptedException {
        javaScriptUtil.waitForPageLoad();
        loginButton.click();
        DoSendKeysActionClass(emailField, validEmail);
        DoSendKeysActionClass(passwordField, validPassword);
        (submitButton).click();
    }
}
