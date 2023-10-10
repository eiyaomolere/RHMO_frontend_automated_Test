package enrollee_web_app;

import Base.TestBase_admin_portal;
import Base.TestBase_enrollee_web_app;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.enrollee_web_pages.enrollee_page;

import java.io.IOException;

public class enrollee_login_test extends TestBase_enrollee_web_app {

    enrollee_page ep;

    @BeforeMethod()
    public void init() throws InterruptedException {
        ep = new enrollee_page(getdriver.get());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void verify_login_to_enrollee_page() throws InterruptedException, IOException {
        ep.username();
        ep.password();
        ep.sign_in();
    }
}
