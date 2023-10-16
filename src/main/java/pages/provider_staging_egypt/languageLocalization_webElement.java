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

public class languageLocalization_webElement {

    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    ActionClassUtil actionsUtilityx;

    String validEmail = System.getenv("validEmail") != null ? System.getenv("validEmail")
            : fetchvalue("validEmail");
    String validPassword = System.getenv("validPassword") != null ? System.getenv("validPassword")
            : fetchvalue("validPassword");


    //Provider Dashboard language Selector Dropdown
    @FindBy(xpath = "//p[@class='drop-down-link ar']")
    @CacheLookup
    private WebElement Arabic;

    @FindBy(xpath = "//p[@class='drop-down-link en']")
    @CacheLookup
    private WebElement English;

    @FindBy(xpath = "//i[@class='fa fa-chevron-down drop-down-icon language-selector-drpdwn-toggler']")
    @CacheLookup
    private WebElement dropdown;

    //Login Elements
    @FindBy(xpath = "//h1[contains(text(),'لوحة البيانات')]")
    @CacheLookup
    private WebElement validAlert;


    @FindBy(xpath = "//button[contains(text(),'تسجيل الدخول')]")
    @CacheLookup
    private WebElement submitButton;


    @FindBy(xpath = "//input[@id='password']")
    @CacheLookup
    private WebElement passwordField;


    @FindBy(xpath = "//input[@placeholder='البريد الإلكتروني']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//h2[contains(text(),'تسجيل الدخول')]")
    @CacheLookup
    private WebElement loginButton;


    public languageLocalization_webElement(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        actionsUtilityx = new ActionClassUtil(driver);
    }

    public void languageLogin() throws IOException {
        //  javaScriptUtil.waitForPageLoad();
        (dropdown).click();
        (Arabic).click();
        (loginButton).click();
        DoSendKeysActionClass(emailField, validEmail);
        DoSendKeysActionClass(passwordField, validPassword);
        (submitButton).click();
        String validMessage = validAlert.getText();
        Assert.assertEquals(validMessage, "لوحة البيانات");

    }
}
