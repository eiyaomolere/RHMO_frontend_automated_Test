package pages.admin_dashboard;

import Base.TestBase_admin_portal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ActionClassUtil;
import utility.ElementUtil;

import java.io.IOException;

import static utility.ActionClassUtil.DoSendKeysActionClass;
import static utility.ElementUtil.GetPageTittle;
import static utility.Utility.fetchvalue;

public class Admin_login_page {

    ElementUtil elementUtil;
    ActionClassUtil actionClassUtil;
    public static String HomeTittle = "RelianceHMO";
    public static String login_page_tittle = "RelianceHMO | Landing Page";

    @FindBy(xpath = "//h2[contains(.,'Login')]")
    @CacheLookup
    private WebElement Login;

    @FindBy(xpath = "//input[@name='email']")
    @CacheLookup
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement sign_in;


    public Admin_login_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
        actionClassUtil = new ActionClassUtil(driver);
    }

    public Admin_login_page Loginbutton() {
        Login.click();
        return this;
    }

    public Admin_login_page username() throws IOException {
        String admin_email = fetchvalue("admin_Email");
        DoSendKeysActionClass(email, admin_email);
        return this;
    }

    public Admin_login_page password() throws IOException {
        String Password = fetchvalue("admin_password");
        DoSendKeysActionClass(password, Password);
        return this;
    }

    public Admin_login_page sign_in() throws IOException {
        sign_in.click();
        return this;
    }

    public static boolean CheckHomeTittle() throws InterruptedException {
        return GetPageTittle().contains(HomeTittle);
    }

    public static boolean check_landing_page_tittle() throws InterruptedException {
        return GetPageTittle().contains(login_page_tittle);
    }
}
