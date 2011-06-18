package list;

import list.ListVisitor;

public interface List <E>{

	public void add(E e);
	
	public void forEach(ListVisitor<E> visitor);
	
	public int size();
}
