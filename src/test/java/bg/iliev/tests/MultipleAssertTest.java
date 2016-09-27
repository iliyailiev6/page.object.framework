package bg.iliev.tests;

import java.math.BigDecimal;

import org.junit.Test;

import bg.iliev.core.MultipleAssert;

public class MultipleAssertTest {

	@Test(expected = AssertionError.class)
	public void testCompareStrings(){
		String expected = "123";
		String actual = "12 ";
		new MultipleAssert().assertEquals(expected, actual).executeChainAssertion();
	}
	
	@Test()
	public void testCompareEqualStrings(){
		String expected = "123";
		String actual = "123";
		new MultipleAssert().assertEquals(expected, actual).executeChainAssertion();
	}
	
	@Test(expected = AssertionError.class)
	public void testCompareStringsAndIntegers(){
		String expected = "123";
		String actual = "12 ";
		Integer expected2 = new Integer(1235);
		Integer actual2 = 1234;
		new MultipleAssert().assertEquals(expected, actual)
			.assertEquals(expected2, actual2)
			.executeChainAssertion();
	}
	
	@Test()
	public void testCompareEqualStringsAndIntegers(){
		String expected = "123";
		String actual = "123";
		Integer expected2 = new Integer(1234);
		Integer actual2 = 1234;
		new MultipleAssert().assertEquals(expected, actual)
			.assertEquals(expected2, actual2)
			.executeChainAssertion();
	}
	
	@Test(expected = AssertionError.class)
	public void testManyAssertionsButOnlyOneFails(){
		new MultipleAssert().assertEquals("1", "1")
			.assertEquals(1, 1)
			.assertEquals(5L, 5L)
			.assertEquals(12d, 12d)
			.assertEquals(new BigDecimal(5), new BigDecimal(5))
			.assertEquals("1", 2)
			.executeChainAssertion();
	}
}
