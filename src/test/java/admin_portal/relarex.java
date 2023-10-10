package admin_portal;

import Base.TestBase_admin_portal;
import Base.TestBase_enrollee_web_app;
import enrollee_web_app.consult_doctor.consult_doctor;
import enrollee_web_app.enrollee_login_test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin_dashboard.Admin_login_page;
import pages.admin_dashboard.Prescription_page;

import java.io.IOException;

public class relarex extends TestBase_enrollee_web_app {

    Admin_login_page lp;
    Prescription_page pp;
    admin_login_test lt;

    enrollee_login_test el;
    consult_doctor cdoector;


    @BeforeMethod()
    public void init() throws InterruptedException {
        lp = new Admin_login_page(getdriver.get());
        lt = new admin_login_test();
        pp = new Prescription_page(getdriver.get());
        el = new enrollee_login_test();
        cdoector= new consult_doctor();
        cdoector.init();
        lt.init();
        el.init();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void Verify_enrollee_login() throws InterruptedException, IOException {
        el.verify_login_to_enrollee_page();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void Verify_enrollee_can_consult_doctor() throws InterruptedException, IOException {
        cdoector.Verify_that_enrollee_can_select_doctor();
        cdoector.Verify_that_enrollee_can_view_closed_consultation();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void Verify_enrollee_can_create_consultation() throws InterruptedException, IOException {
        Thread.sleep(100000);

        cdoector.Verify_that_enrollee_can_create_new_consultation();
        Thread.sleep(100000);
    }


}
