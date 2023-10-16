package provider_staging;

import Base.TestBase_provider_admin_dashboard_egypt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.provider_staging_egypt.providerLogin_webElements;

public class providerLogin extends TestBase_provider_admin_dashboard_egypt {

    providerLogin_webElements stg;

    @BeforeTest()
    public void init() throws InterruptedException {
        stg = new providerLogin_webElements(getdriver.get());
    }

    @Description("Login into the provider dashboard using valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void validLogin() throws Exception {
        try {
            stg.login();

            trh.updateResultToTestRail(1, "6209", "90", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            trh.updateResultToTestRail(5, "6209", "90", String.valueOf(e));
            Assert.fail();
        }

    }


    @Description("Login into the provider dashboard using invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void invalidLogin() throws Exception {
        try {

            stg.invalidLogin();

            //stg.updateResultToTestRail(1, "2408", "95", "Test Passed");
        } catch (
                Error |
                Exception e) {
            System.out.println("Assert failed");
            //stg.updateResultToTestRail(5, "2408", "95", String.valueOf(e));
            Assert.fail();
        }

    }
    @AfterTest(alwaysRun = true)
    public void Quit() {
        getdriver.get().quit();
    }

}
