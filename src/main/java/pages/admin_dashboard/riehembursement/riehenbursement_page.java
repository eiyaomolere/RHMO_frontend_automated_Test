package pages.admin_dashboard.riehembursement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.admin_dashboard.Admin_login_page;
import utility.ActionClassUtil;
import utility.ElementUtil;

import static utility.ActionClassUtil.DoClickActionClass;

public class riehenbursement_page {

    ElementUtil elementUtil;
    ActionClassUtil actionClassUtil;
    public static String HomeTittle_riehembursment = "RelianceHMO";

    @FindBy(xpath = "//span[contains(.,'Reimbursements')]")
    @CacheLookup
    private WebElement riehembursement_button;

    @FindBy(xpath = "/button[@type='button'][contains(.,'Create Request')]")
    @CacheLookup
    private WebElement create_reihembursement;

    public riehenbursement_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
        actionClassUtil = new ActionClassUtil(driver);
    }

    public riehenbursement_page select_riehenbursement() {
        DoClickActionClass(riehembursement_button);
        return this;
    }
}
