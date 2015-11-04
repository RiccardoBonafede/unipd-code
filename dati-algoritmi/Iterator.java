

interface Iterator<E>{

	public boolean hasNext();
	
	public E next() throws NoSuchElementException;

	public E remove() throws IllegalStateException;
}