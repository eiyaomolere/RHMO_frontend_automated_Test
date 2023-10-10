package pages.admin_dashboard;

import Base.TestBase_admin_portal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Prescription_page extends TestBase_admin_portal {

    @FindBy(xpath = "//span[contains(.,'Prescriptions')]")
    @CacheLookup
    private WebElement ps;

    @FindBy(xpath = "//a[contains(.,'All Prescriptions')]")
    @CacheLookup
    private WebElement all_prescription;

    public Prescription_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Prescription_page prescription_menu() {
        ps.click();
        return this;
    }

    public Prescription_page select_all_prescription() {
        all_prescription.click();
        return this;
    }
}
