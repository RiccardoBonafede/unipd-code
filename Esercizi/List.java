/**
 * Interfaccia per strutture di dati di tipo genericia
 * @author Riccardo Bonafede
 * @version 1.0 (finale)
 */
public interface List<T>{

	/** 
	 * Controlla se è la lista è vuota
	 * @return {boolean} true se vuota, false se ha elementi 
	 *	
	 */

	 boolean isEmpty();

	 /**
	  * Svuota la lista
	  *
	  */

	 void makeEmpty();
	  /**
	   * Ritorna numero elementi della lista
	   * @return {int} Numero di elementi
	   */

	 int size();
	  /**
	   * Aggiunge element in cima alla lista
	   * @param {T} element istanza del'elemento da aggiungere alla lista
	   */

	 void addFirst(T element);
	  /**
	   * Ritorna il primo elemento della lista
	   * @return  {T} Istanza del primo elemento della lista
	   */

	 T getFirst();
	  /**
	   * Aggiunge elemento alla fine della lista 
	   * @param {T} element istanza dell'oggetto da aggiungere alla classe
	   */

	 void addLast(T element);

	 /**
	   * Ritorna l'ultimo elemento della lista
	   * @return  {T} Istanza dell'ultimo elemento della lista
	   */

	 T getLast();

}