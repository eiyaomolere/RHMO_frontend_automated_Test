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

public class passwordValidation_webElement {

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


    //Click Profile dropdown after login
    @FindBy(xpath = "//span[@class='hidden-xs']")
    @CacheLookup
    private WebElement profileDropdown;

    @FindBy(xpath = "//a[normalize-space()='Profile']")
    @CacheLookup
    private WebElement profile;


    @FindBy(xpath = "//a[normalize-space()='Sign out']")
    @CacheLookup
    private WebElement signOut;

    //Provider
    @FindBy(xpath = "//a[normalize-space()='First Provider 2']")
    @CacheLookup
    private WebElement firstProvider;

    //Change Password
    @FindBy(xpath = "//input[@id='old_password']")
    @CacheLookup
    private WebElement oldPassword;

    @FindBy(xpath = "//input[@id='new_password']")
    @CacheLookup
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirm_new_password']")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(xpath = "//b[normalize-space()='Change Password']")
    @CacheLookup
    private WebElement changePassword_Button;

    @FindBy(xpath = "//p[@role='alert']")
    @CacheLookup
    private WebElement changePasswordErrorAlert;

    @FindBy(xpath = "//p[@role='alert']")
    @CacheLookup
    private WebElement incorrectOldPasswordAlert;
    //"Incorrect Old Password"


    //TODO: What does it do?
    public passwordValidation_webElement(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void updateConfirmPassword() throws IOException, InterruptedException {
        (firstProvider).click();
        (profileDropdown).click();
        (profile).click();
        (oldPassword).sendKeys("149806da");
        (newPassword).sendKeys("149806da123");
        (confirmPassword).sendKeys("");
        (changePassword_Button).click();
       // waitForElementClickable(changePasswordErrorAlert, 20);
        javaScriptUtil.waitForPageLoad();
        javaScriptUtil.waitForPageLoad();
        String validMessage = (changePasswordErrorAlert).getText();
        Assert.assertEquals(validMessage, "Error updating password, fields cannot be empty");
        (oldPassword).clear();
        (newPassword).clear();
        (confirmPassword).clear();
        Thread.sleep(4000);
    }

    public void updateOldPassword() throws IOException, InterruptedException {
        javaScriptUtil.waitForPageLoad();
        (oldPassword).sendKeys("");
        (newPassword).sendKeys("149806da123");
        (confirmPassword).sendKeys("149806da123");
        (changePassword_Button).click();
        //waitForElementClickable(changePasswordErrorAlert, 20);
        javaScriptUtil.waitForPageLoad();
        String validMessage = (changePasswordErrorAlert).getText();
        Assert.assertEquals(validMessage, "Error updating password, fields cannot be empty");
        Thread.sleep(4000);
        (oldPassword).clear();
        (newPassword).clear();
        (confirmPassword).clear();
    }

    public void incorrectOldPassword() throws IOException, InterruptedException {
        javaScriptUtil.waitForPageLoad();
        (oldPassword).sendKeys("149806daz456");
        (newPassword).sendKeys("149806da12");
        (confirmPassword).sendKeys("149806da12");
        (changePassword_Button).click();
        javaScriptUtil.waitForPageLoad();
        //waitForElementClickable(incorrectOldPasswordAlert, 20);
        String validMessage = (incorrectOldPasswordAlert).getText();
        Assert.assertEquals(validMessage, "Incorrect Old Password");
    }
}
