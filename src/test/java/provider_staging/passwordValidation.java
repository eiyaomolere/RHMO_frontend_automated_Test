package provider_staging;

import Base.TestBase_provider_admin_dashboard_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.passwordValidation_webElement;

public class passwordValidation extends TestBase_provider_admin_dashboard_egypt {

    passwordValidation_webElement Usr;
    login_provider_admin lpa;

    @BeforeTest()
    public void init() throws InterruptedException {
        Usr = new passwordValidation_webElement(getdriver.get());
        lpa = new login_provider_admin();
        lpa.init();
    }

    @Description("Validate Error when omitting confirm password fields in the user profile page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void provider_login() throws Exception {
        try {
            lpa.login_test();
            lpa.validate_login();
            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }
    @Description("Validate Error when omitting confirm password fields in the user profile page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void passwordValidationPrint() throws Exception {
        try {
            Usr.updateConfirmPassword();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }

    @Description("Validate Error when omitting Old Password fields in the user profile page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void passwordValidationError() throws Exception {
        try {
            Usr.updateOldPassword();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }


    @Description("Validate Error when omitting old password, prompt error message “Incorrect Old Password” is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void passwordError() throws Exception {
        try {
            Usr.incorrectOldPassword();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }

}
