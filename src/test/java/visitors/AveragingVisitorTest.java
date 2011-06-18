package visitors;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AveragingVisitorTest {

	AveragingVisitor<BigDecimal> cut;

	@Before
	public void setUp() throws Exception {
		cut = new AveragingVisitor<BigDecimal>();
	}

	@After
	public void tearDown() throws Exception {
		cut = null;
	}

	@Test
	public void testVisitTwoElems() {

		final BigDecimal one = new BigDecimal(1.0);
		final BigDecimal two = new BigDecimal(2.0);

		cut.visit(one);
		cut.visit(two);

		assertEquals(new BigDecimal(1.5), cut.getAverage());
	}

	@Test
	public void testVisitOneElem() {

		final BigDecimal one = new BigDecimal(1.0);

		cut.visit(one);

		assertEquals(new BigDecimal(1.0), cut.getAverage());
	}

	@Test (expected=ArithmeticException.class)
	public void testVisitNoElems()
    {
		cut.getAverage();
	}
}
