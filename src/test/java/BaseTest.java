import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver webDriver=null;
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver96.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(chromeOptions));
        getWebDriver().navigate().to("https://aykutde96.github.io/");
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void testLogin() throws InterruptedException {
        Random rand = new Random();
        webDriver.findElements(By.cssSelector("article>nav>ul>li")).get(rand.nextInt(webDriver.findElements(By.cssSelector("article>nav>ul>li")).size())).click();
        webDriver.findElements(By.cssSelector("article>nav>ul>li")).get(rand.nextInt(webDriver.findElements(By.cssSelector("article>nav>ul>li")).size())).click();
        webDriver.findElements(By.cssSelector("article>nav>ul>li")).get(rand.nextInt(webDriver.findElements(By.cssSelector("article>nav>ul>li")).size())).click();
        System.out.println("test bitiyor");
    }
    @After
    public void tearDown(){
        getWebDriver().quit();
        System.out.println("test bitti");
    }
    public static WebDriver getWebDriver() {

        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

}
