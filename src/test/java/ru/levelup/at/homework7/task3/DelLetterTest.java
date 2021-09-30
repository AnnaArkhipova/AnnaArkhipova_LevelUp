package ru.levelup.at.homework7.task3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.testng.annotations.Test;
import ru.levelup.at.homework7.RunBrowser;

public class DelLetterTest extends RunBrowser {

    @Test
    public void deleteLetterTest() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/test/resources/unit/tools/data.txt"));
        String[] data = new String[14];
        int i = 0;
        while (scanner.hasNextLine()) {
            data[i] = scanner.nextLine();
            i++;
        }

        DelLetterPage registrationPage = new DelLetterPage(this.driver);
        boolean result1 = registrationPage.enterToMail(data[0], data[1]);
        assertTrue(result1, "Не зашла в почту!!!");

        DelLetterPage letterPage = new DelLetterPage(this.driver);
        int result2 = letterPage.newLetter(data[7], data[12], data[12]);
        assertNotEquals(result2, 0, "Письма нет во Входящих!!!");

        DelLetterPage addrPage = new DelLetterPage(this.driver);
        String result3 = addrPage.mailPage();
        assertEquals(result3, data[11], "Невалидный адрес!!!");

        DelLetterPage subjPage = new DelLetterPage(this.driver);
        String result4 = subjPage.themePage();
        assertEquals(result4, data[12], "Невалидная тема!!!");

        DelLetterPage bdPage = new DelLetterPage(this.driver);
        String result5 = bdPage.bodyPage();
        assertEquals(result5, data[13], "Невалидный текст письма!!!");

        DelLetterPage chkSend = new DelLetterPage(this.driver);
        int result6 = chkSend.checkSendLetter();
        assertNotEquals(result6, 0, "Письма нет в Удаленных!!!");

        DelLetterPage extFromMail = new DelLetterPage(this.driver);
        extFromMail.exitMail();
    }
}

