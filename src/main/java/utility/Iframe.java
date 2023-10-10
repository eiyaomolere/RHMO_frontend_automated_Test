package utility;

import Base.TestBase_admin_portal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Iframe extends TestBase_admin_portal {

    public static void DoSwitchToFrame(int frameIndex, int sleepindex) throws InterruptedException {
        Thread.sleep(sleepindex);
        getdriver.get().switchTo().frame(frameIndex);
    }

    public static void IframeFinder() {
        List<WebElement> elements = getdriver.get().findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
    }
}