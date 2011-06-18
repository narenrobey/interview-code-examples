package list.listImpl;

import list.listImpl.ListElem;
import list.List;
import list.ListVisitor;

public class ListImpl<E> implements List<E> {

	int size = 0;
	
	ListElem<E> head = null;
	ListElem<E> tail = null;
	
	@Override
	public void add(final E itemToAdd) {
		
		if(itemToAdd == null){
			throw new NullPointerException("added item cannot be null");
		}
		
		if(size == 0){
			addFirst(itemToAdd);
		}
		else{
			addAnother(itemToAdd);
		}
		
		this.size++;
	}

	private void addFirst(final E itemToAdd) {

		this.head = new ListElem<E>(itemToAdd, null);
		this.tail = this.head;
	}

	private void addAnother(final E itemToAdd) {

		this.tail.next = new ListElem<E>(itemToAdd, null);
		this.tail = this.tail.next;
	}

	@Override
	public void forEach(final ListVisitor<E> visitor) {
		
		ListElem<E> currentElem = this.head;

		while(currentElem != null){
			
			visitor.visit(currentElem.obj);
			
			currentElem = currentElem.next;
		}
	}

	@Override
	public int size() {
		
		return this.size;
	}

}
