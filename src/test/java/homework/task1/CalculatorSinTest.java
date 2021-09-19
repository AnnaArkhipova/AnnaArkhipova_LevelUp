package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {10, Math.sin(10)},
            {0, Math.sin(0)},
            {-10, Math.sin(-10)},
            {5.00001234, Math.sin(5.00001234)}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void sinDoublePositiveTest(double a, double expectedSin) {
        System.out.println("sinDoublePositiveTest");
        double actualSin = calculator.sin(a);
        assertEquals(actualSin, expectedSin, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, Math.sin(6)},
            {0, Math.sin(1)},
            {-10, Math.sin(-11)},
            {5.00001234, Math.sin(5.00001235)}
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void sinDoubleNegativeTest(double a, double expectedSin) {
        System.out.println("sinDoubleNegativeTest");
        double actualSin = calculator.sin(a);
        assertNotEquals(actualSin, expectedSin, "Incorrect result");
    }
}

