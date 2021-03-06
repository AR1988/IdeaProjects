package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    public static WebDriver driver;

    public final Logger logger = LogManager.getLogger(getClass());

    @Rule
    public final TestRule watchman = new TestWatcher() {
        // This method gets invoked if the test fails for any reason:
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            // Now you can do whatever you need to do with it, for example take a screenshot
            takeScreenShot(description.getClassName(), description.getMethodName());
        }
    };

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\opt\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @After
    public void logOut() {
        driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button")).click();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    private void takeScreenShot(String className, String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File(
                            "src/screenshots/" + LocalDateTime.now().getMonth().toString().toLowerCase() + "_" + LocalDateTime.now().getDayOfMonth() + "/" + className + "/" + methodName + "/"
                                    + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute() + "-" + LocalTime.now().getSecond() + "_" + className.toUpperCase() + "_" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
