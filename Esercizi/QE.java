import java.lang.Comparable;
public class QE extends Q{

	public QE(){

		super(); //Chiama il metodo costruttore della classe padre. Non Obbligatorio ma buona norma metterlo.
	}

	public void enqueue(Object x){

		if( x instanceof Comparable)
			super.enqueue((Comparable)x);
		else
			throw new IllegalArgumentException();

	}

	public Object[] toSortedArray(){
		if(isEmpty())
			return null;

		return sort(toArray());

	}

	private Object[] sort(Object[] l){
		
		if(!(l instanceof Comparable[]))
			return null;
		Comparable[] t=(Comparable[]) l;
		if(t.length==0)
			throw new IllegalArgumentException();

		else if(t.length==1)
			return t;
		else if(t.length==2){
			if(t[0].compareTo(t[1])>=0)
				return t;
			else{
				Comparable tmp=t[0];
				t[0]=t[1];
				t[1]=tmp;
				return t;
			}
		}

		Comparable[] t1=new Comparable[t.length/2];
		Comparable[] t2=new Comparable[t.length/2+1];

		//divido in due l'array. Mettendo un elemento in più nel secondo nel caso l'array di partenza sia dispari
		for(int i=0;i<t.length;i++){

			if(i<t.length/2)
				t1[i]=t[i];

			else{
				t2[t.length/2]=t[i];
			}

		}

		//ordino i due array
		t1=(Comparable[])sort(t1);
		t2=(Comparable[])sort(t2);

		//i=index array principale
		//i1 index array 1 (t1)
		//i2 index array 2 (t2)

		for(int i=0, i1=0, i2=0;i<t.length;i++){

			if(i1>=t1.length){
				t[i]=t2[i2];
				i2++;
			}
			else if(i2>=t2.length){

			}

			if(t1[i1].compareTo(t2[i2]) >= 0){
				t[i]=t1[i1];
				i1++;
			}
			else{
				t[i]=t2[i2];
				i2++;
			}
		}
		return t;
	}

	public Comparable[] toArray(){
		if(isEmpty()){
			throw new EmptyQueueException();
		}

		Object[] tmp=new Comparable[size()];

		for(int i=0;i<size();i++){
			tmp[i]=(Comparable)dequeue();
		}
		for(int i=0;i<size();i++)
			enqueue(tmp[size()-i]);
		return (Comparable[])tmp;

	}



	public Object[] toSet(){
		Object[] tmp=toSortedArray();
		QE newArray=new QE(); //mi piace perchè ha complessità temporale O(1) in acesso e scrittura
		int nsize=1, ni=0;
		
		newArray.enqueue(tmp[0]); //Ci metto dentro un elemento
		for(int i=1;i<tmp.length;i++){

			if(!tmp[i].equals((Comparable)newArray.front())){
				newArray.enqueue(tmp[i]);
			}
		}
		return newArray.toArray();
	}
		


}