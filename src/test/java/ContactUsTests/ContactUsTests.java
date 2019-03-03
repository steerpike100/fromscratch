package ContactUsTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ContactUsTests {

    WebDriver driver;

    @Before
    public void setUp() {
        String userDir = System.getProperty("user.dir");
       // System.setProperty("webdriver.chrome.driver", userDir + "\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", userDir + "\\drivers\\geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void canSelectContactUsPage() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/");
        Thread.sleep(5000);
        WebElement contactUsLink = driver.findElement(By.xpath("//h1[contains(text(),'CONTACT US')]"));
        contactUsLink.click();

        Thread.sleep(5000);
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));

        firstName.sendKeys("bob");

        //    Assert.assertEquals("CONTACT US", contactUsHeader);
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
