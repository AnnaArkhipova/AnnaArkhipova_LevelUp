package ru.levelup.at.homework7.task2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RuleOfLetterPage {

    public WebDriver driver;

    public RuleOfLetterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean enterToMail(String name, String pwd) {

        WebElement mail = driver.findElement(By.className("email-input"));
        mail.sendKeys(name);
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
        passwd.sendKeys(pwd);
        WebElement enterPwdButton = driver.findElement(By.className("second-button"));
        action.moveToElement(enterPwdButton)
              .click()
              .perform();

        WebElement writeNewLetter = driver.findElement(By.className("compose-button"));
        return writeNewLetter.isDisplayed();
    }

    public int sendLetter(String addr, String subj, String body) {
        WebElement writeNewLetter = driver.findElement(By.className("compose-button"));
        Actions action = new Actions(driver);
        action.moveToElement(writeNewLetter)
              .click()
              .perform();

        WebElement addressNewLetter = driver.findElement(By.className("container--zU301"));
        action.moveToElement(addressNewLetter);
        addressNewLetter.sendKeys(addr);
        WebElement themeNewLetter = driver.findElement(By.name("Subject"));
        action.moveToElement(themeNewLetter);
        themeNewLetter.sendKeys(subj);
        WebElement bodyNewLetter = driver.findElement(By.cssSelector("div[role='textbox'] div"));
        action.moveToElement(bodyNewLetter);
        bodyNewLetter.sendKeys(body);

        List<WebElement> sendLetter = driver.findElements(By.className("button2__txt"));
        //System.out.println("Элемент:" + sendLetter.get(1).getText());
        action.moveToElement(sendLetter.get(1))
              .click()
              .perform();
        WebElement closeConfirmMessage = driver.findElement(By.className("ico_16-close"));
        action.moveToElement(closeConfirmMessage)
              .click()
              .perform();

        List<WebElement> nameFolder = driver.findElements(By.className("nav__item"));
        nameFolder.get(6).click();
        List<WebElement> sentListLetters = driver.findElements(By.className("llc"));
        //System.out.print(sentListLetters.size());
        return sentListLetters.size();
    }

    public int ruleLetter() {

        List<WebElement> nameFolder = driver.findElements(By.className("nav__item"));
        nameFolder.get(5).click();
        List<WebElement> ruleListLetters = driver.findElements(By.className("llc"));
        return ruleListLetters.size();
    }

    public String mailPage() {

        List<WebElement> listLettersCrpt = driver.findElements(By.className("ll-crpt"));
        System.out.println(listLettersCrpt.get(0).getText());
        return listLettersCrpt.get(0).getAttribute("title");
    }

    public String themePage() {

        List<WebElement> listLettersTitle = driver.findElements(By.className("ll-sj__normal"));
        return listLettersTitle.get(0).getText();
    }

    public String bodyPage() {

        List<WebElement> listLettersBody = driver.findElements(By.className("ll-sp__normal"));
        return listLettersBody.get(0).getText();
    }

    public void exitMail() {
        WebElement exitBox = driver.findElement(By.className("ph-project__user-name"));
        Actions action = new Actions(driver);
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
