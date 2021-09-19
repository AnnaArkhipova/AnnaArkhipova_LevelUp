package homework.task1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5.1, Math.sqrt(Math.abs(5.1))},
            {-10.33, Math.sqrt(Math.abs(-10.33))},
            {5.00001234, Math.sqrt(Math.abs(5.00001234))}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void sqrtDoublePositiveTest(double a, double expectedSqrt) {
        System.out.println("sqrtDoublePositiveTest");
        double actualSqrt = calculator.sqrt(a);
        assertEquals(actualSqrt, expectedSqrt, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5.1, Math.sqrt(Math.abs(6.1))},
            {-10.33, Math.sqrt(Math.abs(-11.33))},
            {5.00001234, Math.sqrt(Math.abs(6.00001234))}
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void sqrtDoubleNegativeTest(double a, double expectedSqrt) {
        System.out.println("sqrtDoubleNegativeTest");
        double actualSqrt = calculator.sqrt(a);
        assertNotEquals(actualSqrt, expectedSqrt, "Incorrect result");
    }
}

