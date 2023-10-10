package utility;

import Base.TestBase_admin_portal;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class ActionClassUtil  {

    private static WebDriver driver;

    public ActionClassUtil(WebDriver driver) {
        ActionClassUtil.driver = driver;
    }

    public static void DoSendKeysWithMoveToElement(WebElement locator, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(locator).sendKeys(value).build().perform();
    }

    public static void DoActionSendKeys(WebElement locator) {
        Actions action = new Actions(driver);
        Faker faker= new Faker();
        action.sendKeys(locator, faker.name().firstName()).perform();
    }

    public static void DoSendKeysActionClass(WebElement locator, String actualText) throws IOException {
        Actions ac = new Actions(driver);
        ac.sendKeys((locator), actualText).perform();
    }

    public static void DoClickWithMoveToElement(WebElement locator){
        Actions action = new Actions(driver);
        action.moveToElement(locator).click().build().perform();
    }

    public static void DoDoubleClickAction(WebElement locator){
        Actions action = new Actions(driver);
        action.moveToElement(locator).doubleClick().perform();
    }

    public static void DoClickActionClass(WebElement locator) {
        Actions ac = new Actions(driver);
        ac.click(locator).perform();
    }

    public static void DoClearActionClass(WebElement locator) {
        Actions ac = new Actions(driver);
        ac.sendKeys(locator, Keys.DELETE).perform();
    }

    public static void DoHoverEffectClick(WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement((locator));
        actions.click().build().perform();
    }

}
