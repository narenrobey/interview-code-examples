package list.listImpl;

import list.listImpl.ListElem;

class ListElem<E> {

	public final E obj;
	
	public ListElem<E> next;
	
	ListElem( final E object, final ListElem<E> next)
	{
		this.obj = object;
		this.next = next;
	}
}
