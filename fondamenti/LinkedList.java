/**
  *	LinkedList.java Classe per liste concatenate semplici
  *
  *
  * @author Bonafede Riccardo
  * @version 0.9
  *
  * Manca gestione eccezzioni
*/
	
	public class LinkedList<T> implements List<T>{
		/**
		 * Classe Contente la classe utilizzata per la creazine dei nodi. E' interna perchè mi ripropongo di usarla solo qua.
		 *In caso basta copia e incollarla fuori
		 */
		class NodeList<E>{
			/*
				next: collegmento a un'altra classe nodo
				item: il valore/contenuto del nodo
			*/
			private NodeList<E> next;
			private E item;

			/**
			  * Costruttore della classe NodeList. Inizializza il contenuto della classe a null come anche l nodo successivo
			  */

			public NodeList(){
				next=null;
				item = null;
			}

			/**
			  * Setta il prossimo nodo a n
			  * @param n Il nuovo prossimo nodo (accetta anche null)
			*/

			public void setNext(NodeList<E> n){
				next=n;
			}
			/**
			 * Ritorna istanza al prossimo oggetto di istanza
			 * @return L'istanza del prossimo oggetto
			 */
			public NodeList<E> getNext(){
				return next;
			}

			/**
			 * Ritorna istanza del valore (classe) assocciato
			 * @return il valore assocciato
			 */

			public E getItem(){
				return item;
			}

			/**
			 * Imposta il valore(classe) al node
			 * @param i istanza(classe) del valore da associare al nodo, accetta anche null
 			 */

			public void setItem(E i){
				item=i;
			}

		}
		/*public class EmptyListException extends RuntimeException{
			public EmptyListException(){

			}
			public EmptyListException(String e){
				super(e);
			}
		}*/

		private NodeList<T> head, tail;

		public LinkedList(){

			tail=new NodeList<T>();
			head=new NodeList<T>();
			head.setNext(tail);

		}
		 /**
	   * Aggiunge element in cima alla lista
	   * @param {T} element istanza del'elemento da aggiungere alla lista
	   */
		public void addFirst(T element){
			NodeList<T> tmp=new NodeList<T>();
			tmp.setItem(element);
			tmp.setNext(head.getNext());
			head.setNext(tmp);
		}
	 /**
	   * Ritorna il primo elemento della lista
	   * @return  {T} Istanza del primo elemento della lista
	   */
		public T getFirst(){
			/*if(isEmpty())
				throw new EmptyListException("Lista vuota");*/
			return head.getNext().getItem();
		}

		/**
	      * Aggiunge elemento alla fine della lista 
	   	  * @param {T} element istanza dell'oggetto da aggiungere alla classe
	      */
		public void addLast(T element){
			tail.setItem(element);
			NodeList<T> newTail=new NodeList<T>();
			tail.setNext(newTail);
			tail=newTail;
		}

	/**
	   * Ritorna l'ultimo elemento della lista
	   * @return  {T} Istanza dell'ultimo elemento della lista
	   */
		public T getLast(){
			/*if(isEmpty())
				throw new EmptyListException("Lista vuota");*/
			NodeList<T> node= head.getNext();
			while(node.getNext()!=null){
				node=node.getNext();
			}
			return node.getItem();
		}

		public T removeLast(){
			/*if(isEmpty())
				throw new EmptyListException("Lista vuota");*/
			NodeList<T> node= head.getNext();
			NodeList<T> nodeL= null; 
			while(node.getNext().getNext()!=null){ //Se è l'ultimo elemento (non la coda)
				nodeL=node; 						//prende quello che sarà il penultimo elemento
				node=node.getNext();
			}
			nodeL.setNext(tail);		//Taglia la coda
			return node.getItem();
		}
		public T removeFirst(){
			NodeList<T> tmp=head.getNext();
			head.setNext(tmp.getNext());
			return tmp.getItem();
		}

	/**
	  * Svuota la lista
	  *
	  */
		public void makeEmpty(){
			head.setNext(tail);
		}

	/** 
	 * Controlla se è la lista è vuota
	 * @return {boolean} true se vuota, false se ha elementi 
	 *	
	 */

		public boolean isEmpty(){
			if(head.getNext().getNext()==null)
				return true;
			return false;
		}
	/**
	  * Ritorna numero elementi della lista
	  * @return {int} Numero di elementi
	  */

		public int size(){
			int i=0;
			NodeList<T> node=head.getNext();
			while(node.getNext().getNext()!=null){
				i++;
				node=node.getNext();
			}
			return i;
		}


	}