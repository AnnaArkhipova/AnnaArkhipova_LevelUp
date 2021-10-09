package ru.levelup.at.homework9.task3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import org.testng.annotations.Test;
import ru.levelup.at.homework9.RunBrowser;

@Epic("Удаление")
@Feature("Удаление письма")
@Story("Написать письмо, отправить, проверить адрес, тему, текст и удалить")

public class DelLetterTest extends RunBrowser {

    @Test(description = "Тест удаления письма")
    @Description("Проверка удаления письма")
    public void deleteLetterTest() throws FileNotFoundException, UnsupportedEncodingException {

        Scanner scanner = new Scanner(new File("src/test/resources/unit/tools/data.txt"));
        String[] data = new String[14];
        String str;
        int i = 0;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            data[i] = new String(str.getBytes(), "UTF-8");
            i++;
        }

        DelLetterPage registrationPage = new DelLetterPage(this.driver);
        boolean result1 = registrationPage.enterToMail(data[0], data[1]);
        assertTrue(result1, "Не зашла в почту!!!");

        DelLetterPage letterPage = new DelLetterPage(this.driver);
        int result2 = letterPage.newLetter(data[7], data[12], data[12]);
        System.out.println(result2);
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

