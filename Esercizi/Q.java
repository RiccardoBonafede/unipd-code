/**
	* @author Riccardo Bonafede
	* @version untested
	*Ancora da commentare e testare.
*/

public class Q implements Queue{

	private Object[] queueA;
	private int index, size;
	private final int START_SIZE=1;

	public Q(){
		queueA=new Object[START_SIZE];
		index=0;
		size=START_SIZE;
	}

	public boolean isEmpty(){
		return index == 0;
	} 

	public int size(){
		return index;
	}

	public void enqueue(Object e){
		if(index >= size)
			resize(size*2);

		queueA[index++]=e;

	}

	private void resize( int newSize){
		if(newSize<=size)
			return;

		Object[] tmp=new Object[size];

		//copia solo elementi presenti, senza copiare tutto l'array
		for(int i=0;i<index;i++)
			tmp[i]=queueA[i];

		queueA=new Object[newSize];

		for(int i=0;i<index;i++)
			queueA[i]=tmp[i];

	}

	public Object front() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Coda Vuota");

		return queueA[index-1];

	}

	public Object dequeue() throws EmptyQueueException{

		if(isEmpty())
			throw new EmptyQueueException("Coda Vuota");

		//decrementa e poi ritorna l'oggetto. 
		return queueA[--index];
	}

	public Object[] toArray(){
		//così dovrei evitare stupidi errori di java
		if(isEmpty())
			return null;

		Object[] tmp=new Object[index];
		int tmpI=index;

		//inverte e ritorna
		for(int i=index;i>=0;i--){
			tmp[index-i]=queueA[i];
		}
		return tmp;
	}







}