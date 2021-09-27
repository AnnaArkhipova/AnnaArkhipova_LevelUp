package ru.levelup.at.homework6.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.RunBrowser;

public class DraftOfLetter extends RunBrowser {

    @Test
    public void draftLetter() {
        WebElement mail = driver.findElement(By.className("email-input"));
        mail.sendKeys("arkhipova_21");
        WebElement enterButtonOfList = driver.findElement(By.className("domain-icon"));
        Actions action = new Actions(driver);
        action.moveToElement(enterButtonOfList)
              .click()
              .perform();
        List<WebElement> nameDomain = driver.findElements(By.tagName("option"));
        nameDomain.get(2).click();
        WebElement enterButton = driver.findElement(By.className("button"));
        action.moveToElement(enterButton)
              .click()
              .perform();
        WebElement passwd = driver.findElement(By.className("password-input"));
        passwd.sendKeys("fdnjntcns21");
        WebElement enterPwdButton = driver.findElement(By.className("second-button"));
        action.moveToElement(enterPwdButton)
              .click()
              .perform();

        WebElement writeNewLetter = driver.findElement(By.className("compose-button"));
        assertTrue(writeNewLetter.isDisplayed(),
            "Не зашла в почту!!!");
        action.moveToElement(writeNewLetter)
              .click()
              .perform();

        WebElement addressNewLetter = driver.findElement(By.className("container--zU301"));
        action.moveToElement(addressNewLetter);
        addressNewLetter.sendKeys("arkhipova_ay@mail.ru");
        WebElement themeNewLetter = driver.findElement(By.name("Subject"));
        action.moveToElement(themeNewLetter);
        themeNewLetter.sendKeys("Test");

        WebElement bodyNewLetter = driver.findElement(By.cssSelector("div[role='textbox'] div"));
        //WebElement bodyNewLetter = driver.findElement(By.xpath("//div[@role='textbox']/div"));
        action.moveToElement(bodyNewLetter);
        bodyNewLetter.sendKeys("Test");

        List<WebElement> saveLetter = driver.findElements(By.className("button2__txt"));
        System.out.println("Элемент:" + saveLetter.get(2).getText());
        action.moveToElement(saveLetter.get(2))
              .click()
              .perform();
        System.out.println("Элемент:" + saveLetter.get(3).getText());
        action.moveToElement(saveLetter.get(3))
              .click()
              .perform();

        List<WebElement> nameFolder = driver.findElements(By.className("nav__item"));
        nameFolder.get(7).click();
        List<WebElement> listLetters = driver.findElements(By.className("llc"));
        assertNotEquals(listLetters.size(), 0,
            "Письмо не сохранилось!!!");

        List<WebElement> listLettersCrpt = driver.findElements(By.className("ll-crpt"));
        assertEquals(listLettersCrpt.get(0).getAttribute("title"), "arkhipova_ay@mail.ru",
            "Адрес в сохраненном письме не валиден!!!");
        List<WebElement> listLettersTitle = driver.findElements(By.className("ll-sj__normal"));
        assertEquals(listLettersTitle.get(0).getText(), "Test",
            "Тема в сохраненном письме не валидна!!!");
        List<WebElement> listLettersBody = driver.findElements(By.className("ll-sp__normal"));
        assertEquals(listLettersBody.get(0).getText(), "Test -- Ann Arkhipova",
            "Текст сохраненного письма не валиден!!!");

        action.moveToElement(listLettersBody.get(0))
              .click()
              .perform();
        WebElement newThemeNewLetter = driver.findElement(By.name("Subject"));
        action.moveToElement(newThemeNewLetter);
        newThemeNewLetter.sendKeys(" letter");
        List<WebElement> sendLetter = driver.findElements(By.className("button2__txt"));
        System.out.println("Элемент:" + sendLetter.get(1).getText());
        action.moveToElement(sendLetter.get(1))
              .click()
              .perform();
        WebElement closeSendWindow = driver.findElement(By.className("ico_16-close"));
        action.moveToElement(closeSendWindow)
              .click()
              .perform();

        WebElement messageEmptyList = driver.findElement(By.className("octopus__title"));
        assertTrue(messageEmptyList.isDisplayed(),
            "Письмо не отправилось!!!");

        nameFolder.get(6).click();
        List<WebElement> sentListLetters = driver.findElements(By.className("llc"));
        //System.out.print(sentListLetters.size());
        assertNotEquals(sentListLetters.size(), 0,
            "Письма нет в Отправленных!!!");

        WebElement exitBox = driver.findElement(By.className("ph-project__user-name"));
        action.moveToElement(exitBox)
              .click()
              .perform();
        List<WebElement> buttonExit = driver.findElements(By.className("ph-text"));
        //  System.out.println("Элемент:" + buttonExit.get(3).getText());
        action.moveToElement(buttonExit.get(3))
              .click()
              .perform();
    }
}






