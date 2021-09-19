package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5, Math.tan(5)},
            {10.1234, Math.tan(10.1234)},
            {-5, Math.tan(-5)},
            {-10.1234, Math.tan(-10.1234)}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void tgDoublePositiveTest(double a, double expectedTg) {
        System.out.println("tgDoublePositiveTest");
        double actualTg = calculator.tg(a);
        assertEquals(actualTg, expectedTg, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, Math.tan(6)},
            {10.1234, Math.tan(11.1234)},
            {-5, Math.tan(-6)},
            {-10.1234, Math.tan(-11.1234)}
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void tgDoubleNegativeTest(double a, double expectedTg) {
        System.out.println("tgDoubleNegativeTest");
        double actualTg = calculator.tg(a);
        assertNotEquals(actualTg, expectedTg, "Incorrect result");
    }
}

