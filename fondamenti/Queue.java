
public interface Queue{

	boolean isEmpty();

	void enqueue(Object x);

	Object front() throws EmptyQueueException;

	Object dequeue() throws EmptyQueueException;

	Object[] toArray();

}