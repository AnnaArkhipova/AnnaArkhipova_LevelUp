package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForDoublePositiveTest")
    public Object[][] dataForDoublePositiveTest() {
        return new Object[][] {
            {5, 5, 10},
            {0, 100, 100},
            {1000, 0, 1000},
            {-10, 5, -5},
            {10, -2, 8},
            {-12, -3, -15},
            {5.1, 2.2, 7.3}
        };
    }

    @Test(dataProvider = "dataForDoublePositiveTest")
    public void sumDoublePositiveTest(double a, double b, double expectedSum) {
        System.out.println("sumDoublePositiveTest");
        double actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @DataProvider(name = "dataForLongPositiveTest")
    public Object[][] dataForLongPositiveTest() {
        return new Object[][] {
            {5, 5, 10},
            {0, 100, 100},
            {1000, 0, 1000},
            {-10, 5, -5},
            {10, -2, 8},
            {-12, -3, -15},
            {0xffffffffL, 2L, 0xffffffffL + 2L}
        };
    }

    @Test(dataProvider = "dataForLongPositiveTest")
    public void sumLongPositiveTest(long a, long b, long expectedSum) {
        System.out.println("sumLongPositiveTest");
        long actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @DataProvider(name = "dataForDoubleNegativeTest")
    public Object[][] dataForDoubleNegativeTest() {
        return new Object[][] {
            {5, 5, 1},
            {0, 100, 0},
            {1000, 0, 1001},
            {-10, 5, -15},
            {10, -2, -12},
            {-12, -3, -9},
            {5.1, 2.05, 3.1}
        };
    }

    @Test(dataProvider = "dataForDoubleNegativeTest")
    public void sumDoubleNegativeTest(double a, double b, double expectedSum) {
        System.out.println("sumDoubleNegativeTest");
        double actualSum = calculator.sum(a, b);
        assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }

    @DataProvider(name = "dataForLongNegativeTest")
    public Object[][] dataForLongNegativeTest() {
        return new Object[][] {
            {5, 5, 1},
            {0, 100, 10},
            {1000, 0, 0},
            {-10, 5, 15},
            {10, -2, -12},
            {-12, -3, -9},
            {0xffffffffL, 2L, 0xffffffffL - 3L}
        };
    }

    @Test(dataProvider = "dataForLongNegativeTest")
    public void sumLongNegativeTest(long a, long b, long expectedSum) {
        System.out.println("sumLongNegativeTest");
        long actualSum = calculator.sum(a, b);
        assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}

