package homework.task1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {-5, true},
            {-0xffffffffL, true},
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void positiveLongTest(long a, boolean expectedIsNegative) {
        System.out.println("PositiveLongTest");
        boolean actualIsNegative = calculator.isNegative(a);
        assertEquals(actualIsNegative, expectedIsNegative, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {5, false},
            {0xffffffffL, false},
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void negativeLongTest(long a, boolean expectedIsNegative) {
        System.out.println("NegativeLongTest");
        boolean actualIsNegative = calculator.isNegative(a);
        assertEquals(actualIsNegative, expectedIsNegative, "Incorrect result");
    }

    @DataProvider(name = "dataForZeroTest")
    public Object[][] dataForZeroTest() {
        return new Object[][] {
            {0, false}
        };
    }

    @Test(dataProvider = "dataForZeroTest")
    public void zeroLongTest(long a, boolean expectedIsNegative) {
        System.out.println("ZeroLongTest");
        boolean actualIsNegative = calculator.isNegative(a);
        assertEquals(actualIsNegative, expectedIsNegative, "Incorrect result");
    }
}

