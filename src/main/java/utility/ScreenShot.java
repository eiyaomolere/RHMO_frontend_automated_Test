package utility;

import Base.TestBase_admin_portal;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ScreenShot {

    private static WebDriver driver;
    public ScreenShot(WebDriver driver) {
        ScreenShot.driver = driver;
    }

    public static void ScreenShotWebElementWebEvent(WebElement locator) throws IOException{
        Path path = Paths.get("./Screenshot/");
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        File Dest = new File("src/../Screenshot/" + "Screenshot" + System.currentTimeMillis() + ".png");
        String extentReportImageqm11 = Dest.getAbsolutePath();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = locator.getLocation();
        int width = locator.getSize().getWidth();
        int height = locator.getSize().getHeight();

        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(extentReportImageqm11));
    }


    public static void screenShot() throws IOException, InterruptedException {
        Path path = Paths.get("./Screenshot/");
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        File Dest = new File("src/../Screenshot/" + "Screenshot" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        try {
            File srcam11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcam11, new File(errflpath));
        } catch (IOException e) {
            System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
        }

    }

    public static void takeScreenShot(String methodName) {
        Path path1 = Paths.get("./Screenshot/");
        // if directory exists?
        if (!Files.exists(path1)) {
            try {
                Files.createDirectories(path1);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        File Dest = new File("src/../Screenshot/" + "Screenshot" + System.currentTimeMillis() + ".png");
        String path = Dest.getAbsolutePath();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(path + methodName + ".png"));
            System.out.println("***Placed screen shot in " + path + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ScreenShotFullPage() throws IOException {
        Path path = Paths.get("./Screenshot/");
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        File Dest = new File("src/../Screenshot/" + "Screenshot" + System.currentTimeMillis() + ".png");
        String extentReportImageqm11 = Dest.getAbsolutePath();
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File(extentReportImageqm11));
    }

    public static String getScreenshot() {
        Path path1 = Paths.get("./Screenshot/");
        // if directory exists?
        if (!Files.exists(path1)) {
            try {
                Files.createDirectories(path1);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshot/" +"Screenshot"+ System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}


