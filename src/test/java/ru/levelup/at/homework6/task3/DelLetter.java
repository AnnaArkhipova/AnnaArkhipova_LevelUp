package ru.levelup.at.homework6.task3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.RunBrowser;

public class DelLetter extends RunBrowser {

    @Test
    public void deleteLetter() {
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
        addressNewLetter.sendKeys("arkhipova_21@list.ru");
        WebElement themeNewLetter = driver.findElement(By.name("Subject"));
        action.moveToElement(themeNewLetter);
        themeNewLetter.sendKeys("Deleting letter");

        List<WebElement> saveLetter = driver.findElements(By.className("button2__txt"));
        System.out.println("Элемент:" + saveLetter.get(1).getText());
        action.moveToElement(saveLetter.get(1))
              .click()
              .perform();
        WebElement confirmNewLetter = driver.findElement(By.className("inner-0-2-93"));
        action.moveToElement(confirmNewLetter)
              .click()
              .perform();
        WebElement closeConfirmMessage = driver.findElement(By.className("ico_16-close"));
        action.moveToElement(closeConfirmMessage)
              .click()
              .perform();

        List<WebElement> nameFolder = driver.findElements(By.className("nav__item"));
        nameFolder.get(4).click();
        List<WebElement> sentListLetters = driver.findElements(By.className("llc"));
        //System.out.print(sentListLetters.size());
        Assert.assertNotEquals(sentListLetters.size(), 0,
            "Письма нет во Входящих!!!");

        List<WebElement> listLettersCrpt = driver.findElements(By.className("ll-crpt"));
        System.out.println(listLettersCrpt.get(0).getText());
        assertEquals(listLettersCrpt.get(0).getText(), "Ann Arkhipova",
            "Адрес в письме не валиден!!!");
        List<WebElement> listLettersTitle = driver.findElements(By.className("ll-sj__normal"));
        assertEquals(listLettersTitle.get(0).getText(), "Deleting letter",
            "Тема в письме не валидна!!!");
        List<WebElement> listLettersBody = driver.findElements(By.className("ll-sp__normal"));
        assertEquals(listLettersBody.get(0).getText(), "-- Ann Arkhipova",
            "Текст письма не валиден!!!");

        WebElement selAllLetter = driver.findElement(By.className("button2__explanation"));
        action.moveToElement(selAllLetter)
              .click()
              .perform();
        List<WebElement> clickDel = driver.findElements(By.className("button2__txt"));
        System.out.println("Элемент:" + clickDel.get(2).getText());
        action.moveToElement(clickDel.get(2))
              .click()
              .perform();
        WebElement clickConfirm = driver.findElement(By.className("layer__submit-button"));
        action.moveToElement(clickConfirm)
              .click()
              .perform();

        nameFolder.get(10).click();
        List<WebElement> dumpListLetters = driver.findElements(By.className("llc"));
        Assert.assertNotEquals(dumpListLetters.size(), 0,
            "Письма нет в Удаленных!!!");

        WebElement exitBox = driver.findElement(By.className("ph-project__user-name"));
        action.moveToElement(exitBox)
              .click()
              .perform();
        List<WebElement> buttonExit = driver.findElements(By.className("ph-text"));
        action.moveToElement(buttonExit.get(3))
              .click()
              .perform();
    }
}
