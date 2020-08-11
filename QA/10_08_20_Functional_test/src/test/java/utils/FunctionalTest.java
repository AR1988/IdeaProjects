package utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    public static WebDriver driver;

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
}
