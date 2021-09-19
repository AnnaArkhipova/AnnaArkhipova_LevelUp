package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForDoublePositiveTest")
    public Object[][] dataForDoublePositiveTest() {
        return new Object[][] {
            {5, 5, 1},
            {10, 1, 10},
            {0, 100, 0},
            {1000, 1000, 1},
            {-10, 5, -2},
            {10, -2, -5},
            {-12, -3, 4},
            {1.5, 0.5, 3}
        };
    }

    @Test(dataProvider = "dataForDoublePositiveTest")
    public void divDoublePositiveTest(double a, double b, double expectedDiv) {
        System.out.println("divDoublePositiveTest");
        double actualDiv = calculator.div(a, b);
        assertEquals(actualDiv, expectedDiv, "Incorrect result");
    }

    @DataProvider(name = "dataForLongPositiveTest")
    public Object[][] dataForLongPositiveTest() {
        return new Object[][] {
            {5, 5, 1},
            {10, 1, 10},
            {0, 100, 0},
            {1000, 1000, 1},
            {-10, 5, -2},
            {10, -2, -5},
            {-12, -3, 4}
        };
    }

    @Test(dataProvider = "dataForLongPositiveTest")
    public void divLongPositiveTest(long a, long b, long expectedDiv) {
        System.out.println("divLongPositiveTest");
        long actualDiv = calculator.div(a, b);
        assertEquals(actualDiv, expectedDiv, "Incorrect result");
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
    public void divDoubleNegativeTest(double a, double b, double expectedDiv) {
        System.out.println("divDoubleNegativeTest");
        double actualDiv = calculator.div(a, b);
        assertNotEquals(actualDiv, expectedDiv, "Incorrect result");
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
    public void divLongNegativeTest(long a, long b, long expectedDiv) {
        System.out.println("divLongNegativeTest");
        long actualDiv = calculator.div(a, b);
        assertNotEquals(actualDiv, expectedDiv, "Incorrect result");
    }
}

