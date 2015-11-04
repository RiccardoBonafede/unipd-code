interface TreeADT<E>{
	
	public int size();

	public boolean isEmpty();

	public Iterator<E> iterator();

	public Iterable<PositionADT<E>> positions();

	public PositionADT<E> root() throws EmptyTreeException;

	public PositionADT<E> parent(PositionADT<E> p) throws InvalidPositionException;

	public Iterator<PositionADT<E>> children(PositionADT<E> p) throws InvalidPositionException;

	public boolean isInternal(PositionADT<E> p) throws InvalidPositionException;

	public boolean isExternal(PositionADT<E> p) throws InvalidPositionException;

	public boolean isRoot(PositionADT<E> p) throws InvalidPositionException;

	public E replace(PositionADT<E> p, E element) throws InvalidPositionException ;
}