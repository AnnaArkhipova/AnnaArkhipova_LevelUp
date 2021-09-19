package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForDoublePositiveTest")
    public Object[][] dataForDoublePositiveTest() {
        return new Object[][] {
            {5, 5, 25},
            {10, 1, 10},
            {0, 100, 0},
            {1000, 1000, 1000000},
            {-10, 5, -50},
            {10, -2, -20},
            {-12, -3, 36},
            {5.00001234, 2, Math.floor(5.00001234 * 2)}
        };
    }

    @Test(dataProvider = "dataForDoublePositiveTest")
    public void multDoublePositiveTest(double a, double b, double expectedMult) {
        System.out.println("multDoublePositiveTest");
        double actualMult = calculator.mult(a, b);
        assertEquals(actualMult, expectedMult, "Incorrect result");
    }

    @DataProvider(name = "dataForLongPositiveTest")
    public Object[][] dataForLongPositiveTest() {
        return new Object[][] {
            {5, 5, 25},
            {10, 1, 10},
            {0, 100, 0},
            {1000, 1000, 1000000},
            {-10, 5, -50},
            {10, -2, -20},
            {-12, -3, 36},
            {0xffffffffL, 2L, 0xffffffffL * 2L}
        };
    }

    @Test(dataProvider = "dataForLongPositiveTest")
    public void multLongPositiveTest(long a, long b, long expectedMult) {
        System.out.println("multLongPositiveTest");
        long actualMult = calculator.mult(a, b);
        assertEquals(actualMult, expectedMult, "Incorrect result");
    }

    @DataProvider(name = "dataForDoubleNegativeTest")
    public Object[][] dataForDoubleNegativeTest() {
        return new Object[][] {
            {5, 5, 1.1},
            {10, 1, 10.1},
            {0, 100, 0.1},
            {1000, 1000, 1.1},
            {-10, 5, -2.1},
            {10, -2, -5.1},
            {-12, -3, 4.1},
            {1.5, 0.5, 3.1}
        };
    }

    @Test(dataProvider = "dataForDoubleNegativeTest")
    public void multDoubleNegativeTest(double a, double b, double expectedMult) {
        System.out.println("multDoubleNegativeTest");
        double actualMult = calculator.mult(a, b);
        assertNotEquals(actualMult, expectedMult, "Incorrect result");
    }

    @DataProvider(name = "dataForLongNegativeTest")
    public Object[][] dataForLongNegativeTest() {
        return new Object[][] {
            {10, 1, 5},
            {0, 100, 5},
            {1000, 1000, 2},
            {-10, 5, 2},
            {10, -2, 5},
            {-12, -3, -4}
        };
    }

    @Test(dataProvider = "dataForLongNegativeTest")
    public void multLongNegativeTest(long a, long b, long expectedMult) {
        System.out.println("multLongNegativeTest");
        long actualMult = calculator.mult(a, b);
        assertNotEquals(actualMult, expectedMult, "Incorrect result");
    }
}

