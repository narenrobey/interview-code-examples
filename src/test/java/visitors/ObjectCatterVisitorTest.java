package visitors;

import static org.junit.Assert.*;
import list.List;

import list.listImpl.ListImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjectCatterVisitorTest {

	
	ObjectCatterVisitor<String> cut = null;
	List<String> listFixture = null;
	
	@Before
	public void setUp() throws Exception {
		cut = new ObjectCatterVisitor<String>();
		
		listFixture = new ListImpl<String>();
	}

	@After
	public void tearDown() throws Exception {
		cut = null;
		listFixture = null;
	}
	
	@Test
	public void testVisitEmpty() {
		
		assertEquals("", cut.getConcatenation());
	}
	
	@Test
	public void testVisitOneInList(){
		final String one = "foo";
		
		listFixture.add(one);
		
		listFixture.forEach(cut);
		
		assertEquals(one, cut.getConcatenation());
	}
	
	@Test
	public void testVisitMultiInList(){
		
		final String one = "foo";
		final String two = "bar";
		final String three = "baz";
		
		listFixture.add(one);
		listFixture.add(two);
		listFixture.add(three);
		
		listFixture.forEach(cut);
		
		assertEquals(one+two+three, cut.getConcatenation());
	}

	@Test
	public void testVisitOnce(){
		
		final String one = "foo";
		
		cut.visit(one);
		
		assertEquals(one, cut.getConcatenation());
	}
	
	@Test
	public void testVisitMulti(){
		
		final String one = "foo";
		final String two = "bar";
		final String three = "baz";
		
		cut.visit(one);
		cut.visit(two);
		cut.visit(three);
		
		assertEquals(one+two+three, cut.getConcatenation());
	}
}
