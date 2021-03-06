package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testEvenMoreNumbers(){
    	assertEquals(36, Calculator.add("1,2,3,4,5,6,7,8"));
    }

    @Test 
    public void testStringContainingNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testOtherDelimiters(){
    	assertEquals(5, Calculator.add("//;//2,3"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegatives(){
        assertEquals(0, Calculator.add("-1,2"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativesWithMoreParamenters(){
        assertEquals(0, Calculator.add("1,-2,4"));
    }

    @Test
    public void testNumbersGreaterThanThousand(){
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testNumbersGreaterThanThousandB(){
        assertEquals(0, Calculator.add("1001,2000"));
    }

    @Test
    public void testNewDelimiters(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }	

    @Test
    public void testMultipleDelimiters(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }
}   
