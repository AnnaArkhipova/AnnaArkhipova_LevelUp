package homework.task1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractBaseCalculatorTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositiveTest() {
        return new Object[][] {
            {5, true},
            {0xffffffffL, true},
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void positiveLongTest(long a, boolean expectedIsPositive) {
        System.out.println("PositiveLongTest");
        boolean actualIsPositive = calculator.isPositive(a);
        assertEquals(actualIsPositive, expectedIsPositive, "Incorrect result");
    }

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegativeTest() {
        return new Object[][] {
            {-5, false},
            {-0xffffffffL, false},
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void negativeLongTest(long a, boolean expectedIsPositive) {
        System.out.println("NegativeLongTest");
        boolean actualIsPositive = calculator.isPositive(a);
        assertEquals(actualIsPositive, expectedIsPositive, "Incorrect result");
    }

    @DataProvider(name = "dataForZeroTest")
    public Object[][] dataForZeroTest() {
        return new Object[][] {
            {0, false}
        };
    }

    @Test(dataProvider = "dataForZeroTest")
    public void zeroLongTest(long a, boolean expectedIsPositive) {
        System.out.println("ZeroLongTest");
        boolean actualIsPositive = calculator.isPositive(a);
        assertEquals(actualIsPositive, expectedIsPositive, "Incorrect result");
    }
}

