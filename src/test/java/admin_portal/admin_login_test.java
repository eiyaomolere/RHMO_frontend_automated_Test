package admin_portal;

import Base.TestBase_admin_portal;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin_dashboard.Admin_login_page;
import java.io.IOException;
import static pages.admin_dashboard.Admin_login_page.CheckHomeTittle;
import static pages.admin_dashboard.Admin_login_page.check_landing_page_tittle;

public class admin_login_test extends TestBase_admin_portal {

    Admin_login_page lp;

    @BeforeMethod()
    public void init() throws InterruptedException {
        lp = new Admin_login_page(getdriver.get());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void LandingPage() throws InterruptedException {
        System.out.println(getdriver.get().getTitle());
        Assert.assertTrue(CheckHomeTittle());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void SuccessfulLoginTest() throws InterruptedException, IOException {
        lp.Loginbutton();
        lp.username();
        lp.password();
        lp.sign_in();

    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void verify_sign_in() throws InterruptedException, IOException {
        System.out.println(getdriver.get().getTitle());
        Assert.assertTrue(check_landing_page_tittle());
    }
}
