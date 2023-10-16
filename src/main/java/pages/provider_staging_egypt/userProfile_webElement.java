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

public class userProfile_webElement {

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

    //User Profile
    @FindBy(xpath = "//input[@id='first_name']")
    @CacheLookup
    private WebElement firstName;

    @FindBy(xpath = "(//input[@id='last_name'])[1]")
    @CacheLookup
    private WebElement lastName;

    @FindBy(xpath = "(//input[@id='phone_number'])[1]")
    @CacheLookup
    private WebElement phoneNumber;

    @FindBy(xpath = "//b[normalize-space()='Update Profile']")
    @CacheLookup
    private WebElement updateButton;
    @FindBy(xpath = "//p[@role='alert']")
    @CacheLookup
    private WebElement successUpdateAlert;
    //"Profile has been updated Successfully"

    //Provider
    @FindBy(xpath = "//a[normalize-space()='Best in Providing Care']")
    @CacheLookup
    private WebElement BestInProvider;


    //TODO: What does it do?
    public userProfile_webElement(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void updateUserProfile() throws IOException, InterruptedException {

        (BestInProvider).click();
        (profileDropdown).click();
        (profile).click();

        //Generate random admin name
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 6; // Length of the random name
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomName = sb.toString();
        (firstName).clear();
        (firstName).sendKeys(randomName);
        (updateButton).click();
        javaScriptUtil.waitForPageLoad();
    }
    public void validate_update() throws IOException, InterruptedException {

        String validMessage =(successUpdateAlert).getText();
        Assert.assertEquals(validMessage, "Profile has been updated Successfully");
    }
}
