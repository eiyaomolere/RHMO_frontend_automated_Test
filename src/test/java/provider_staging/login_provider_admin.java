package provider_staging;

import Base.TestBase_provider_admin_dashboard_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.login_page_webElement;
import pages.provider_staging_egypt.passwordValidation_webElement;

public class login_provider_admin extends TestBase_provider_admin_dashboard_egypt {

    passwordValidation_webElement Usr;
    login_page_webElement lw;

    @BeforeTest()
    public void init() throws InterruptedException {
        lw = new login_page_webElement(getdriver.get());
    }

    @Description("Validate that users can login to the provider admin with a valid username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void login_test() throws Exception {
        try {
            lw.login_action();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }

    @Description("Validate that users can login to the provider admin with a valid username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void validate_login() throws Exception {
        //validate login
    }
}
