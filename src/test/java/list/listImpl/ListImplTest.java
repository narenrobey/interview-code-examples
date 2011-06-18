package list.listImpl;

import static org.junit.Assert.*;
import list.ListVisitor;
import list.listImpl.ListImpl;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListImplTest {

	private static final String TEST_STRING_1 = "foo";
	private static final String TEST_STRING_2 = "42";
	ListImpl<Integer> cut = null;

	@Before
	public void setUp() throws Exception {
		cut = new ListImpl<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		cut = null;
	}

	@Test
	public void testAddFirst() {

		final Integer five = new Integer(5);

		cut.add(five);

		assertNotNull("expected head to point to something!", cut.head);
		assertEquals(cut.head, cut.tail);

		assertEquals(1, cut.size);
	}

	@Test
	public void testAddTwo() {

		cut.add(new Integer(7));

		cut.add(new Integer(11));

		assertEquals(new Integer(7), cut.head.obj);
		assertEquals(new Integer(11), cut.head.next.obj);
		assertNull(cut.head.next.next);

		assertEquals(new Integer(11), cut.tail.obj);

		assertEquals(2, cut.size);
	}

	@Test(expected = NullPointerException.class)
	public void testAddNull() {
		cut.add(null);
	}

	@Test
	public void testForEach() {

		cut.add(new Integer(13));
		cut.add(new Integer(17));

		final ListVisitor<Integer> stubbedVisitor = new ListVisitor<Integer>() {

			public int numTimesCalled = 0;

			@Override
			public void visit(Integer listElement) {
				numTimesCalled++;

				if (numTimesCalled == 1) {
					assertEquals(new Integer(13), listElement);
				} else if (numTimesCalled == 2) {
					assertEquals(new Integer(17), listElement);
				} else {
					fail("called too many times!");
				}
			}
		};

		cut.forEach(stubbedVisitor);
	}

	@Test
	public void testSize() {

		assertEquals(0, cut.size());
		
		addSomeElementsToCut(2);
		assertEquals(2, cut.size());

		addSomeElementsToCut(0);
		assertEquals(2, cut.size());

		addSomeElementsToCut(6);
		assertEquals(8, cut.size());

		addSomeElementsToCut(15);
		assertEquals(23, cut.size());
	}

	private void addSomeElementsToCut(final int numElements) {

		for (int i = 0; i < numElements; i++) {
			cut.add(new Integer(i));
		}
	}
	
	@Test
	public void testWithOtherTypes()
    {

		final ListImpl<String> stringList = new ListImpl<String>();
		stringList.add(TEST_STRING_1);
		stringList.add("bar");
		stringList.add(TEST_STRING_2);
		
		assertEquals(3, stringList.size());
		assertEquals(TEST_STRING_1, stringList.head.obj);
		assertEquals(TEST_STRING_2, stringList.tail.obj);
	}
}
