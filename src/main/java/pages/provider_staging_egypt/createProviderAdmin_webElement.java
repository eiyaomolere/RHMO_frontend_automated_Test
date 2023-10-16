package pages.provider_staging_egypt;


import org.openqa.selenium.Alert;
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

public class createProviderAdmin_webElement {

    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;

    ActionClassUtil ac;
    String SUPERADMIN_EMAIL = System.getenv("SUPERADMIN_EMAIL") != null ? System.getenv("SUPERADMIN_EMAIL")
            : fetchvalue("SUPERADMIN_EMAIL");
    String SUPERADMIN_PASS = System.getenv("SUPERADMIN_PASS") != null ? System.getenv("SUPERADMIN_PASS")
            : fetchvalue("SUPERADMIN_PASS");

    //Login Elements

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    @CacheLookup
    private WebElement emailField;


    //Provider Module Elements
    @FindBy(xpath = "//span[normalize-space()='Providers']")
    @CacheLookup
    private WebElement sideMenuProvider;
    @FindBy(xpath = "(//a[normalize-space()='All Providers'])[1]")
    @CacheLookup
    private WebElement sideMenuProvider_AllProvider;
    @FindBy(xpath = "//button[@class='btn btn-info dropdown-toggle']")
    @CacheLookup
    private WebElement ViewProvider_Button;
    @FindBy(xpath = "//b[normalize-space()='Add Admins']")
    @CacheLookup
    private WebElement addProviderAdmin_Button;


    //Select and view a provider
    @FindBy(xpath = "//*[@id=\"providers-table\"]/tbody/tr[1]/td[13]/a")
    @CacheLookup
    private WebElement selectProvider;


    //Create Provider admin element
    @FindBy(xpath = "//input[@placeholder='First Name']")
    @CacheLookup
    private WebElement CreateProvider_Admin_firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    @CacheLookup
    private WebElement CreateProvider_Admin_lastName;
    @FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
    @CacheLookup
    private WebElement CreateProvider_Admin_phoneNumber;
    @FindBy(xpath = "//input[@placeholder='email@client.com']")
    @CacheLookup
    private WebElement CreateProvider_Admin_emailAddress;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    @CacheLookup
    private WebElement CreateProviderAdmin_Submit;
    @FindBy(xpath = "//a[normalize-space()='Back']")
    @CacheLookup
    private WebElement clickBack_Button;

    //Delete Provider Admin
    @FindBy(xpath = "//tbody/tr[2]/td[7]/a[2]")
    @CacheLookup
    private WebElement DeleteProviderAdmin;
    @FindBy(xpath = "//div[@role='alert']")
    @CacheLookup
    private WebElement ProviderDeleteAlert;

    public createProviderAdmin_webElement(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        ac = new ActionClassUtil(driver);
    }

    public void loginEgyptAdmin() throws IOException {
        javaScriptUtil.waitForPageLoad();
        DoSendKeysActionClass(emailField, SUPERADMIN_EMAIL);
        DoSendKeysActionClass(passwordField, SUPERADMIN_PASS);
        (submitButton).click();
    }

    public void navigate2Provider() {
        javaScriptUtil.waitForPageLoad();
        (sideMenuProvider).click();
        (sideMenuProvider_AllProvider).click();
        (selectProvider).click();
        (ViewProvider_Button).click();
        (addProviderAdmin_Button).click();
        javaScriptUtil.waitForPageLoad();
        (CreateProvider_Admin_firstName).sendKeys("Reliance");
        (CreateProvider_Admin_lastName).sendKeys("Automation");
        (CreateProvider_Admin_phoneNumber).sendKeys("20345645343");
        (CreateProvider_Admin_emailAddress).sendKeys("test@automation.rel");
        (CreateProviderAdmin_Submit).click();

    }

    public void deleteProviderAdmin(WebDriver driver) throws InterruptedException {
        javaScriptUtil.waitForPageLoad();
        (clickBack_Button).click();
        (DeleteProviderAdmin).click();
        Thread.sleep(1000);
        Alert clickAlert = driver.switchTo().alert(); // switch to alert
        String alertMessage = driver.switchTo().alert().getText(); //capture alert message
        System.out.println(alertMessage); // Print Alert Message
        clickAlert.accept();
        Assert.assertEquals(true, (ProviderDeleteAlert).isDisplayed());
        String providerDeleteSuccessMsg = (ProviderDeleteAlert).getText();
        boolean x = providerDeleteSuccessMsg.contains("Admin Deleted Successfully");
        Assert.assertTrue(x);
        System.out.println(true); // Print delete Alert Message

    }
}
