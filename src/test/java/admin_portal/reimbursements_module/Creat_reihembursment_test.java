package admin_portal.reimbursements_module;

import Base.TestBase_admin_portal;
import admin_portal.admin_login_test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin_dashboard.Admin_login_page;
import pages.admin_dashboard.Prescription_page;
import pages.admin_dashboard.riehembursement.riehenbursement_page;

import java.io.IOException;

public class Creat_reihembursment_test extends TestBase_admin_portal {
    Admin_login_page ap;

    Admin_login_page lp;
    Prescription_page pp;
    admin_login_test lt;
    riehenbursement_page rp;


    @BeforeMethod()
    public void init() throws InterruptedException {
        lp = new Admin_login_page(getdriver.get());
        lt = new admin_login_test();
        pp = new Prescription_page(getdriver.get());
        rp = new riehenbursement_page(getdriver.get());
        lt.init();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void Verify_Admin_login() throws InterruptedException, IOException {
        lt.SuccessfulLoginTest();
        lt.verify_sign_in();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void create_reihembursement() throws InterruptedException, IOException {
        rp.select_riehenbursement();

        Thread.sleep(100000);
    }




}
