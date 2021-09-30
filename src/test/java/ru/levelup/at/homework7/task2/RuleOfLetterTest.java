package ru.levelup.at.homework7.task2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.at.homework7.RunBrowser;

public class RuleOfLetterTest extends RunBrowser {

    @Test
    public void ruleLetterTest() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/test/resources/unit/tools/data.txt"));
        String[] data = new String[14];
        int i = 0;
        while (scanner.hasNextLine()) {
            data[i] = scanner.nextLine();
            i++;
        }

        RuleOfLetterPage registrationPage = new RuleOfLetterPage(this.driver);
        boolean result1 = registrationPage.enterToMail(data[0], data[1]);
        assertTrue(result1, "Не зашла в почту!!!");

        RuleOfLetterPage letterPage = new RuleOfLetterPage(this.driver);
        int result2 = letterPage.sendLetter(data[7], data[8], data[9]);
        Assert.assertNotEquals(result2, 0, "Письма нет в Отправленных!!!");

        RuleOfLetterPage testLetterPage = new RuleOfLetterPage(this.driver);
        int result3 = testLetterPage.ruleLetter();
        Assert.assertNotEquals(result3, 0, "Письма нет в папке:Тест!!!");

        RuleOfLetterPage addrLetter = new RuleOfLetterPage(this.driver);
        String result4 = addrLetter.mailPage();
        assertEquals(result4, data[11], "Невалидный адрес!!!");

        RuleOfLetterPage subjPage = new RuleOfLetterPage(this.driver);
        String result5 = subjPage.themePage();
        assertEquals(result5, data[8], "Невалидная тема!!!");

        RuleOfLetterPage bdPage = new RuleOfLetterPage(this.driver);
        String result6 = bdPage.bodyPage();
        assertEquals(result6, data[10], "Невалидный текст письма!!!");

        RuleOfLetterPage extFromMail = new RuleOfLetterPage(this.driver);
        extFromMail.exitMail();
    }
}
