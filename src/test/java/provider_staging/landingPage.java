package provider_staging;

import Base.TestBase_provider_admin_dashboard_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.landingPage_webElements;

public class landingPage extends TestBase_provider_admin_dashboard_egypt {


    landingPage_webElements lp;

    @BeforeTest()
    public void init() throws InterruptedException {
        lp = new landingPage_webElements(getdriver.get());
    }


    @Description("Validate Facebook social icon works properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void validFacebook() throws Exception {
        try {
            lp.validFacebook();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }

    @Description("Validate Mail  icon works properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void validMail() throws Exception {
        try {

            lp.validMail();

            //stg.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //stg.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }

    @Description("Validate Instagram social icon works properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void validInstagram() throws Exception {
        try {

            lp.validInstagram();

            //stg.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //stg.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }


    @Description("Validate Twitter social icon works properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void validTwitter() throws Exception {
        try {

            lp.validTwitter();

            //stg.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //stg.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }
    }
}
