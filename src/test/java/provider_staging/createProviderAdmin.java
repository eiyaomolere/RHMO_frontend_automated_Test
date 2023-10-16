package provider_staging;

import Base.TestBase_admin_portal_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.createProviderAdmin_webElement;

public class createProviderAdmin extends TestBase_admin_portal_egypt {

    createProviderAdmin_webElement CrPrd;

    @BeforeTest()
    public void init() throws InterruptedException {
        CrPrd = new createProviderAdmin_webElement(getdriver.get());
    }


    @Description("Validate user can login to the Egypt Admin dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void loginEgyptAdmin() throws Exception {
        try {
            CrPrd.loginEgyptAdmin();

            //trh.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //trh.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }

    @Description("Validate user can create Provider admin on the Egypt Admin dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void createProviderAdmin() throws Exception {
        try {
            CrPrd.navigate2Provider();

            trh.updateResultToTestRail(1, "6155", "90", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            trh.updateResultToTestRail(5, "6155", "90", String.valueOf(e));
            Assert.fail();
        }
    }

    @Description("Validate user can create Provider admin on the Egypt Admin dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void Email_verification_new_provider_admin() throws Exception {
        //Verify that Email is recieved after creating a new Provider admin
    }

    @Description("Validate user can delete Provider admin on the Egypt Admin dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void deleteProviderAdmin() throws Exception {
        try {
            CrPrd.deleteProviderAdmin(getdriver.get());

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
