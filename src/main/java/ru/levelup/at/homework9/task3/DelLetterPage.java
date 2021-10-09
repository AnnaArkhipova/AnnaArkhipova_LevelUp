package ru.levelup.at.homework9.task3;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DelLetterPage {

    public WebDriver driver;

    public DelLetterPage(WebDriver driver) {
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

    public int newLetter(String addr, String theme, String body) {

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
        themeNewLetter.sendKeys(theme);
        WebElement bodyNewLetter = driver.findElement(By.cssSelector("div[role='textbox'] div"));
        action.moveToElement(bodyNewLetter);
        bodyNewLetter.sendKeys(body);

        List<WebElement> saveLetter = driver.findElements(By.className("button2__txt"));
        //System.out.println("Элемент:" + saveLetter.get(1).getText());
        action.moveToElement(saveLetter.get(1))
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
        return sentListLetters.size();
    }

    public String mailPage() {
        List<WebElement> addrOfMail = driver.findElements(By.className("ll-crpt"));
        //System.out.println(addrOfMail.get(0).getAttribute("title"));
        return addrOfMail.get(0).getAttribute("title");
    }

    public String themePage() {
        List<WebElement> themeOfMail = driver.findElements(By.className("ll-sj__normal"));
        return themeOfMail.get(0).getText();
    }

    public String bodyPage() {
        List<WebElement> bodyOfMail = driver.findElements(By.className("ll-sp__normal"));
        return bodyOfMail.get(0).getText();
    }

    public int checkSendLetter() {

        WebElement selAllLetter = driver.findElement(By.className("button2__explanation"));
        Actions action = new Actions(driver);
        action.moveToElement(selAllLetter)
              .click()
              .perform();
        List<WebElement> clickDel = driver.findElements(By.className("button2__txt"));
        //System.out.println("Элемент:" + clickDel.get(2).getText());
        action.moveToElement(clickDel.get(2))
              .click()
              .perform();
        WebElement clickConfirm = driver.findElement(By.className("layer__submit-button"));
        action.moveToElement(clickConfirm)
              .click()
              .perform();

        List<WebElement> nameFolder = driver.findElements(By.className("nav__item"));
        nameFolder.get(10).click();
        List<WebElement> dumpListLetters = driver.findElements(By.className("llc"));
        return dumpListLetters.size();
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
