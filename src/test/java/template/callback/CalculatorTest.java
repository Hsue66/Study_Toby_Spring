package template.callback;


import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void calcSumTest() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath());
        assertThat(sum, is(10));
    }
}