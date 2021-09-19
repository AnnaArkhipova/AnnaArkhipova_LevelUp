package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForDoublePositiveTest")
    public Object[][] dataForDoublePositiveTest() {
        return new Object[][] {
            {5, 5, 0},
            {10, 1, 9},
            {0, 100, -100},
            {1000, 0, 1000},
            {-10, 5, -15},
            {10, -2, 12},
            {-12, -3, -9},
            {5.1, 2.05, 3.05}
        };
    }

    @Test(dataProvider = "dataForDoublePositiveTest")
    public void subDoublePositiveTest(double a, double b, double expectedSub) {
        System.out.println("subDoublePositiveTest");
        double actualSub = calculator.sub(a, b);
        assertEquals(actualSub, expectedSub, "Incorrect result");
    }

    @DataProvider(name = "dataForLongPositiveTest")
    public Object[][] dataForLongPositiveTest() {
        return new Object[][] {
            {5, 5, 0},
            {10, 1, 9},
            {0, 100, -100},
            {1000, 0, 1000},
            {-10, 5, -15},
            {10, -2, 12},
            {-12, -3, -9},
            {0xffffffffL, 2L, 0xffffffffL - 2L}
        };
    }

    @Test(dataProvider = "dataForLongPositiveTest")
    public void subLongPositiveTest(long a, long b, long expectedSub) {
        System.out.println("subLongPositiveTest");
        long actualSub = calculator.sub(a, b);
        assertEquals(actualSub, expectedSub, "Incorrect result");
    }

    @DataProvider(name = "dataForDoubleNegativeTest")
    public Object[][] dataForDoubleNegativeTest() {
        return new Object[][] {
            {5, 5, 1},
            {10, 1, 1},
            {0, 100, 100},
            {1000, 0, 1001},
            {-10, 5, -5},
            {10, -2, -12},
            {-12, -3, -15},
            {5.1, 2.05, 3.1}
        };
    }

    @Test(dataProvider = "dataForDoubleNegativeTest")
    public void subDoubleNegativeTest(double a, double b, double expectedSub) {
        System.out.println("subDoubleNegativeTest");
        double actualSub = calculator.sub(a, b);
        assertNotEquals(actualSub, expectedSub, "Incorrect result");
    }

    @DataProvider(name = "dataForLongNegativeTest")
    public Object[][] dataForLongNegativeTest() {
        return new Object[][] {
            {5, 5, 1},
            {10, 1, 11},
            {0, 100, 100},
            {1000, 0, 0},
            {-10, 5, 15},
            {10, -2, -12},
            {-12, -3, -15},
            {0xffffffffL, 2L, 0xffffffffL - 3L}
        };
    }

    @Test(dataProvider = "dataForLongNegativeTest")
    public void subLongNegativeTest(long a, long b, long expectedSub) {
        System.out.println("subLongNegativeTest");
        long actualSub = calculator.sub(a, b);
        assertNotEquals(actualSub, expectedSub, "Incorrect result");
    }
}

