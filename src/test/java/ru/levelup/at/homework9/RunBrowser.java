package ru.levelup.at.homework9;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class RunBrowser {

    public WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver.exe");
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(3000000, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://www.mail.ru/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
