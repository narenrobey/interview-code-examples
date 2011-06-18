package visitors;

import list.ListVisitor;

public class ObjectCatterVisitor<E> implements ListVisitor<E> {

	String catted = "";

	@Override
	public void visit(final E e)
    {
		catted += e.toString();
	}

	public String getConcatenation()
    {
		return catted;
	}
}
