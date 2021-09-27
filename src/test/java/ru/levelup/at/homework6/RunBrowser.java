package ru.levelup.at.homework6;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RunBrowser {

    public WebDriver driver;

    @BeforeClass
    public void setUpSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(1000000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(300000, TimeUnit.MILLISECONDS);

        driver.navigate().to("https://www.mail.ru/");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Mail.ru: почта, поиск в интернете, новости, игры",
            "НЕ ОТКРЫЛАСЬ СТРАНИЦА!!!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


