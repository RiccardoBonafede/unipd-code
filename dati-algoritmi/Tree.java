abstract class Tree<E> implements TreeADT<E>{

	class TreeNode<E> extends Position<E>{

		protected Position<E> treeNode;
		protected Position<E> parent;
		protected PositionList<E> children;

	}

	protected int size;
	protected TreeNode<E> troot;

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size==0;
	}

	public Iterator<E> iterator(){
		/*Qui bisogna creare una classe che cntenga tutti gli elementi*/
	}

	public Position<E> root(){
		if(this.isEmpty())
			throw new  EmptyTreeException();
		return this.troot;
	}

	public Position<E> parent(Position<E> p) throws InvalidPositionException{

		if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		return tmp.parent;
	}

	public Position<E> children(Position<E> p)  throws InvalidPositionException{
		if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		return tmp.children;
	}

	public boolean isInternal(Position<E> p) throws InvalidPositionException{

	 if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		return tmp.iterator().hasNext();
	}

	public boolean isExternal(Position<E> p) throws InvalidPositionException{

	 if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		return !tmp.iterator().hasNext();
	}

	public boolean isRoot(PositionADT<E> p) throws InvalidPositionException{

		if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		return tmp.parent==null;
	}

	public E replace(PositionADT<E> p, E element) throws InvalidPositionException {
		if(!(p instanceof TreeNode<E>))
			throw new InvalidPositionException();

		TreeNode<E> tmp=(TreeNode<E>) p;
		E prev=tmp.element();
		tmp.setElement(e);
		return prev;
	}



}