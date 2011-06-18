package visitors;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListAndAveragingVisitorTest {

	ListAndAveragingVisitor<BigDecimal> cut = null;
	
	@Before
	public void setUp() throws Exception {
		cut = new ListAndAveragingVisitor<BigDecimal>();
	}

	@After
	public void tearDown() throws Exception {
		cut = null;
	}

	@Test (expected=NullPointerException.class)
	public void testVisitNull() {
		cut.visit(null);

	}
	
	@Test
	public void testVisitNone() {
		
		
	}
	
	@Test
	public void testVisitOne() {
		
		final BigDecimal hundred = new BigDecimal(100);
		cut.visit(hundred);
		
		assertEquals("100", cut.catted);
		assertEquals(1, cut.numberVisits);
		assertEquals(new BigDecimal(100), cut.sum);
	}
	
	@Test
	public void testVisitTwo() {
		
		final BigDecimal hundred = new BigDecimal(100);
		final BigDecimal fifty = new BigDecimal(50);
		
		cut.visit(hundred);
		cut.visit(fifty);
		
		assertEquals("100 50", cut.catted);
		assertEquals(2, cut.numberVisits);
		assertEquals(new BigDecimal(150), cut.sum);
	}

	@Test
	public void testGetListStringTwo() {
		
		cut.visit(new BigDecimal(114));
		cut.visit(new BigDecimal(116));
		
		assertEquals("114 116", cut.getListString());
	}
	
	@Test
	public void testGetListStringOne() {
		
		cut.visit(new BigDecimal(366));
		
		assertEquals("366", cut.getListString());
	}

	@Test
	public void testGetListStringNone() {

		assertEquals("", cut.getListString());
	}

	@Test
	public void testGetAverage() {

		cut.numberVisits = 3;
		cut.sum = new BigDecimal(600);

		assertEquals(new BigDecimal(200), cut.getAverage());
	}
	
	@Test(expected = ArithmeticException.class)
	public void testGetAverageNone() {
		cut.getAverage();
	}

	@Test
	public void testToString() {
		final String someStuff = "foo bar 42";
		
		cut.catted = someStuff;
		cut.numberVisits = 4;
		cut.sum = new BigDecimal(80);
		
		final String actual = cut.toString();
		
		assertEquals("The list of numbers is " + someStuff + " The average is 20", actual);
	}

}
