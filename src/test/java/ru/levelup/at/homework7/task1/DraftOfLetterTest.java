package ru.levelup.at.homework7.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.testng.annotations.Test;
import ru.levelup.at.homework7.RunBrowser;

public class DraftOfLetterTest extends RunBrowser {

    @Test
    public void draftLetterTest() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/test/resources/unit/tools/data.txt"));
        String[] data = new String[14];
        int i = 0;
        while (scanner.hasNextLine()) {
            data[i] = scanner.nextLine();
            i++;
        }

        DraftOfLetterPage registrationPage = new DraftOfLetterPage(this.driver);
        boolean result1 = registrationPage.enterToMail(data[0], data[1]);
        assertTrue(result1, "Не зашла в почту!!!");

        DraftOfLetterPage letterPage = new DraftOfLetterPage(this.driver);
        int result2 = letterPage.saveDraft(data[2], data[3], data[4]);
        assertNotEquals(result2, 0, "Письмо не сохранилось!!!");

        DraftOfLetterPage addrPage = new DraftOfLetterPage(this.driver);
        String result3 = addrPage.mailPage();
        assertEquals(result3, data[2], "Невалидный адрес!!!");

        DraftOfLetterPage subjPage = new DraftOfLetterPage(this.driver);
        String result4 = subjPage.themePage();
        assertEquals(result4, data[3], "Невалидная тема!!!");

        DraftOfLetterPage bdPage = new DraftOfLetterPage(this.driver);
        String result5 = bdPage.bodyPage();
        assertEquals(result5, data[5], "Невалидный текст письма!!!");

        DraftOfLetterPage sendDraftLetter = new DraftOfLetterPage(this.driver);
        Boolean result6 = sendDraftLetter.sendLetterPage(data[3], data[6]);
        assertTrue(result6, "Письмо не отправилось!!!");

        DraftOfLetterPage chkSend = new DraftOfLetterPage(this.driver);
        int result7 = chkSend.checkSendLetter();
        assertNotEquals(result7, 0, "Письма нет в Отправленных!!!");

        DraftOfLetterPage extFromMail = new DraftOfLetterPage(this.driver);
        extFromMail.exitMail();
    }
}









