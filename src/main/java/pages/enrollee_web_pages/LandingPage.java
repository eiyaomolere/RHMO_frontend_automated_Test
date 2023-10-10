package pages.enrollee_web_pages;

import Base.TestBase_admin_portal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.*;

public class LandingPage extends TestBase_admin_portal {

    public static String HomeTittle = "RelianceHMO";

    @FindBy(xpath = "//a[@id='login']")
    @CacheLookup
    private WebElement Loginbutton;

    @FindBy(xpath = "")
    @CacheLookup
    public static WebElement WinfreeHealthInsurancePopUp;

    @FindBy(xpath = "//button[@class='button button_secondary login-card__button'][contains(.,'Log in')]")
    @CacheLookup
    private WebElement EnrolleLoginButton;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    @CacheLookup
    private WebElement EnrolleLoginEmail_Hmo_Number;
    @FindBy(xpath = "//input[contains(@name,'password')]")
    @CacheLookup
    private WebElement EnrolleePassword;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    @CacheLookup
    private WebElement LoginEnrollee;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LandingPage Loginbutton() {
        Loginbutton.click();
        return this;
    }

    public LandingPage EnrolleLoginButton() {
        DoClick(EnrolleLoginButton);
        return this;
    }

    public LandingPage EnrolleLoginEmail_Hmo_Number(String Email_HmoNumber){
        EnrolleLoginEmail_Hmo_Number.sendKeys(Email_HmoNumber);
        return this;
    }

    public LandingPage EnrolleePassword(String Email_HmoNumber){
        EnrolleePassword.sendKeys(Email_HmoNumber);
        return this;
    }

    public LandingPage LoginEnrollee() {
        DoClickActionClass(LoginEnrollee);
        return this;
    }


    public static boolean Checker() throws InterruptedException {
        return CheckElementPresent(WinfreeHealthInsurancePopUp);
    }
}
