package template.callback;


import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    Calculator calculator;
    String filepath;

    @Before
    public void setup(){
        this.calculator = new Calculator();
        this.filepath = getClass().getResource("numbers.txt").getPath();
    }

    @Test
    public void calcSumTest() throws IOException {
        int sum = calculator.calcSum(filepath);
        assertThat(sum, is(10));
    }

    @Test
    public void calcMultiplyTest() throws IOException {
        int ret = calculator.calcMultiply(filepath);
        assertThat(ret, is(24));
    }

    @Test
    public void concatLinesTest() throws IOException{
        String ret = calculator.concatLines(filepath);
        assertThat(ret, is("1234"));
    }
}