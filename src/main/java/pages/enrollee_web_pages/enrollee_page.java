package pages.enrollee_web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ActionClassUtil;
import utility.ElementUtil;
import utility.JavaScriptUtil;

import java.io.IOException;

import static utility.ActionClassUtil.DoSendKeysActionClass;
import static utility.Utility.fetchvalue;

public class enrollee_page {

    ElementUtil elementUtil;
    ActionClassUtil actionClassUtil;

    JavaScriptUtil javaScriptUtil;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    @CacheLookup
    private WebElement enrollee_email;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    private WebElement enrollee_password;

    @FindBy(xpath = "//input[@type='submit']")
    @CacheLookup
    private WebElement login_button;

    public enrollee_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
        actionClassUtil = new ActionClassUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    public enrollee_page username() throws IOException {
        String Enrollee_email = fetchvalue("enrollee_Email");
        DoSendKeysActionClass(enrollee_email, Enrollee_email);
        return this;
    }

    public enrollee_page password() throws IOException {
        String Enrollee_password = fetchvalue("enrollee_password");
        DoSendKeysActionClass(enrollee_password, Enrollee_password);
        return this;
    }

    public enrollee_page sign_in() throws IOException {
        login_button.click();
        return this;
    }
}
