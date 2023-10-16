package provider_staging;

import Base.TestBase_provider_admin_dashboard_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.userProfile_webElement;

public class userProfile extends TestBase_provider_admin_dashboard_egypt {

    userProfile_webElement UsrP;
    login_provider_admin lpa;


    @BeforeTest()
    public void init() throws InterruptedException {
        UsrP = new userProfile_webElement(getdriver.get());
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

    @Description("Validate user profile when editing the user profile page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void Update_provider_admin() throws Exception {
        try {
            UsrP.updateUserProfile();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }

    @Description("Validate user profile update")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void validate_profile_was_updated() throws Exception {
        try {
            UsrP.validate_update();

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
