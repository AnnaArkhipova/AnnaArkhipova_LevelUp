package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5, Math.cos(5)},
            {10.1234, Math.cos(10.1234)},
            {0, Math.cos(0)},
            {-5, Math.cos(-5)},
            {-10.1234, Math.cos(-10.1234)},
            {4.9e-324, Math.cos(4.9e-324)},
            {1.7e+308, Math.cos(1.7e+308)}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void cosDoublePositiveTest(double a, double expectedCos) {
        System.out.println("cosDoublePositiveTest");
        double actualCos = calculator.cos(a);
        assertEquals(actualCos, expectedCos, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, Math.cos(5.1)},
            {10.1234, Math.cos(10.12)},
            {0, Math.cos(0.001)},
            {-5, Math.cos(-5.1)},
            {-10.1234, Math.cos(-10.12)},
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void cosDoubleNegativeTest(double a, double expectedCos) {
        System.out.println("cosDoubleNegativeTest");
        double actualCos = calculator.cos(a);
        assertNotEquals(actualCos, expectedCos, "Incorrect result");
    }
}


