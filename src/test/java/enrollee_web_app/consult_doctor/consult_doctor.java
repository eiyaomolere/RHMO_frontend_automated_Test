package enrollee_web_app.consult_doctor;

import Base.TestBase_admin_portal;
import Base.TestBase_enrollee_web_app;
import enrollee_web_app.enrollee_login_test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.enrollee_web_pages.call_doctor_page;

import java.io.IOException;

public class consult_doctor extends TestBase_enrollee_web_app {

    call_doctor_page cd;
    enrollee_web_app.enrollee_login_test enrollee_login_test;

    @BeforeMethod()
    public void init() throws InterruptedException {
        cd = new call_doctor_page(getdriver.get());
        enrollee_login_test = new enrollee_login_test();

        enrollee_login_test.init();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void enrollee_login() throws InterruptedException, IOException {
        enrollee_login_test.verify_login_to_enrollee_page();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void Verify_that_enrollee_can_select_doctor() throws InterruptedException, IOException {
        cd.consult_doctor_tab();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void Verify_that_enrollee_can_view_consultations() throws InterruptedException, IOException {
        cd.consult_doctor_tab();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Verify_that_enrollee_can_view_closed_consultation() throws InterruptedException, IOException {
        cd.select_closed_consultation();
        cd.check_first_consultation_in_list();
        cd.select_first_consultation_in_list();
        String closed_button = cd.get_text_closed_consultation();
        Assert.assertEquals(closed_button, "Consultation is closed for new messages at this time");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Verify_that_enrollee_can_create_new_consultation() throws InterruptedException, IOException {
        getdriver.get().manage().window().fullscreen();
        cd.consult_doctor_tab();
        cd.new_consultation();
        cd.select_cough();
        cd.select_headache();
        cd.reason_for_consultation();
        String please_note = cd.check_note();
        Assert.assertEquals(please_note, "THIS APP IS NOT INTENDED FOR THE TREATMENT OF PREGNANT WOMEN AND CHILDREN OF 6 MONTHS AND BELOW");
        cd.click_submit();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Verify_that_enrol() throws InterruptedException, IOException {
        cd.consult_doctor_tab();
        cd.new_consultation();
        cd.select_cough();
        cd.select_headache();
    }

}
