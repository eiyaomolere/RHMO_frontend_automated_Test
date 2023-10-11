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

import static utility.ActionClassUtil.DoActionSendKeys;
import static utility.JavaScriptUtil.CheckElementPresent;
import static utility.JavaScriptUtil.DoScrollIntoView;
import static utility.Utility.fetchvalue;

public class call_doctor_page {

    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    ActionClassUtil actionClassUtil;

    @FindBy(xpath = "(//div[contains(.,'THIS APP IS NOT INTENDED FOR THE TREATMENT OF PREGNANT WOMEN AND CHILDREN OF 6 MONTHS AND BELOW')])[8]")
    @CacheLookup
    private WebElement Note;
    @FindBy(xpath = "//p[contains(.,'Headache')]")
    @CacheLookup
    private WebElement headache;

    @FindBy(xpath = "//textarea[@name='reasons']")
    @CacheLookup
    private WebElement consultation_reason;


    @FindBy(xpath = "//p[contains(.,'Cough')]")
    @CacheLookup
    private WebElement cough;

    @FindBy(xpath = "//input[@class='input']")
    @CacheLookup
    private WebElement select_symptoms;
    @FindBy(xpath = "//a[contains(.,'Consult a Doctor')]")
    @CacheLookup
    private WebElement call_doctor;

    @FindBy(xpath = "//button[contains(.,'New Consultation')]")
    @CacheLookup
    private WebElement create_new_consultation;

    @FindBy(xpath = "//select[@name='mediumId']")
    @CacheLookup
    private WebElement chat_with_a_doctor;

    @FindBy(xpath = "//button[contains(.,'Closed Consultations')]")
    @CacheLookup
    private WebElement closed_consultation;

    @FindBy(xpath = "(//button[contains(@class,'primary-btn')])[1]")
    @CacheLookup
    private WebElement select_closed_consultation;

    @FindBy(xpath = "//p[contains(.,'Consultation is closed for new messages at this time')]")
    @CacheLookup
    private WebElement followup_closed_consultation;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    @CacheLookup
    private WebElement submit_button;


    public call_doctor_page(WebDriver driver) {
        elementUtil = new ElementUtil(driver);
        actionClassUtil = new ActionClassUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        PageFactory.initElements(driver, this);
    }

    public call_doctor_page username() throws IOException {
        String Enrollee_email = fetchvalue("enrollee_Email");
        //   DoSendKeysActionClass(enrollee_email, Enrollee_email);
        return this;
    }

    public call_doctor_page password() throws IOException {
        String Enrollee_password = fetchvalue("enrollee_password");
        //DoSendKeysActionClass(enrollee_password, Enrollee_password);
        return this;
    }

    public call_doctor_page consult_doctor_tab() throws IOException {
        call_doctor.click();
        return this;
    }

    public call_doctor_page select_headache() throws IOException {
        select_symptoms.click();
        headache.click();
        return this;
    }

    public call_doctor_page select_cough() throws IOException {
        select_symptoms.click();
        cough.click();
        return this;
    }

    public call_doctor_page new_consultation() throws IOException {
        create_new_consultation.click();
        return this;
    }

    public call_doctor_page reason_for_consultation() throws IOException {
        consultation_reason.sendKeys("i want to get better");
        return this;
    }

    public call_doctor_page select_closed_consultation() throws IOException {
        closed_consultation.click();
        return this;
    }

    public call_doctor_page select_first_consultation_in_list() throws IOException {
        select_closed_consultation.click();
        return this;
    }

    public String get_text_closed_consultation() throws IOException {
        return followup_closed_consultation.getText();
    }

    public boolean check_first_consultation_in_list() throws InterruptedException {
        return CheckElementPresent(select_closed_consultation);
    }

    public String check_note() throws IOException {
        return Note.getText();
    }

    public call_doctor_page click_submit() throws IOException {
        DoScrollIntoView(submit_button);
        submit_button.click();
        return this;
    }
}
