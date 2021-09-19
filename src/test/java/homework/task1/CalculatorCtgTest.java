package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5, Math.cos(5) / Math.sin(5)},
            {10.1234, Math.cos(10.1234) / Math.sin(10.1234)},
            {-5, Math.cos(-5) / Math.sin(-5)},
            {-10.1234, Math.cos(-10.1234) / Math.sin(-10.1234)}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void ctgDoublePositiveTest(double a, double expectedCtg) {
        System.out.println("ctgDoublePositiveTest");
        double actualCtg = calculator.ctg(a);
        assertEquals(actualCtg, expectedCtg, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, Math.cos(5.1) / Math.sin(5.1)},
            {10.1234, Math.cos(10.12) / Math.sin(10.12)},
            {0, Math.cos(0.001) / Math.sin(0.001)},
            {-5, Math.cos(-5.1) / Math.sin(-5.1)},
            {-10.1234, Math.cos(-10.12) / Math.sin(-10.12)},
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void ctgDoubleNegativeTest(double a, double expectedCtg) {
        System.out.println("ctgDoubleNegativeTest");
        double actualCtg = calculator.ctg(a);
        assertNotEquals(actualCtg, expectedCtg, "Incorrect result");
    }
}

