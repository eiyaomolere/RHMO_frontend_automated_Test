package utility;

import Base.TestBase_admin_portal;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class ElementUtil {

    private static WebDriver driver;

    public ElementUtil(WebDriver driver) {
        ElementUtil.driver = driver;
    }
    public static String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public static void DoSelectValuesByVisibleText(WebElement locator, String value) throws IOException, InterruptedException {
        Select select = new Select(locator);
        select.selectByVisibleText(value);
    }

    public static void DoSelectValuesByIndex(WebElement locator, int index) throws IOException, InterruptedException {
        Select select = new Select(locator);
        locator.click();
        select.selectByIndex(index);
    }

    public static String Password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial) {
        Faker faker = new Faker();
        if (includeSpecial) {
            char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
            for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(password);
        } else {
            return faker.lorem().characters(minimumLength, maximumLength, includeUppercase);
        }
    }

    public static void DoSendKeyEnter(WebElement locator, String actualText){
        locator.sendKeys(actualText + Keys.ENTER);
    }

    public static void CheckBusinessNameExist() throws IOException {
        if (driver.findElements(By.xpath(("usenamechecker_XPATH"))).size() != 0) {
            Faker faker = new Faker();
            String BusinessName = faker.name().firstName() + faker.name().lastName();

            System.out.println("New Business Name : " + BusinessName);
            //  DoSendkeyFluentWait("Businessname_XPATH", BusinessName, 2, 20);
            //  DoClickFluentWait("NextButton_XPATH", 2, 20);
        } else {
            System.out.println("Business Name Doesn't Exist");
        }
    }

    public static String GetPageTittle(){
        return driver.getTitle();
    }

    public static String GetTitle(){
        return driver.getTitle();
    }
}
