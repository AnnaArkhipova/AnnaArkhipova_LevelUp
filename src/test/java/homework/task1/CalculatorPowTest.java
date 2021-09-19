package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5, 5, Math.pow(5, Math.floor(5))},
            {10, 1, Math.pow(10, Math.floor(1))},
            {0, 100, Math.pow(0, Math.floor(100))},
            {-10, 5, Math.pow(-10, Math.floor(5))},
            {10, -2, Math.pow(10, Math.floor(-2))},
            {-12, -3, Math.pow(-12, Math.floor(-3))},
            {5.00001234, 2.3, Math.pow(5.00001234, Math.floor(2.3))}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void powDoublePositiveTest(double a, double b, double expectedPow) {
        System.out.println("powDoublePositiveTest");
        double actualPow = calculator.pow(a, b);
        assertEquals(actualPow, expectedPow, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, 5, Math.pow(5, Math.floor(6))},
            {10, 1, Math.pow(10, Math.floor(2))},
            {-10, 5, Math.pow(-10, Math.floor(6))},
            {10, -2, Math.pow(10, Math.floor(-3))},
            {-12, -3, Math.pow(-12, Math.floor(-4))},
            {5.00001234, 2.3, Math.pow(5.00001234, Math.floor(3.3))}
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void powDoubleNegativeTest(double a, double b, double expectedPow) {
        System.out.println("powDoubleNegativeTest");
        double actualPow = calculator.pow(a, b);
        assertNotEquals(actualPow, expectedPow, "Incorrect result");
    }
}

