public class QE extends Q{

	public QE(){

		super(); //Chiama il metodo costruttore della classe padre. Non Obbligatorio ma buona norma metterlo.
	}

	public void enqueue(Object x){

		if(x instaceof Comparable)
			super.enqueue(x)
		else
			throw new IllegalArgumentException();

	}

	public Object[] toSortedArray(){
		if(isEmpty())
			return null;

		return sort(toArray());

	}

	private Object[] sort(Object[] t){

		if(t.lenght==0)
			throw new IllegalArgumentException();

		else if(t.lenght==1)
			return t;
		else if(t.lenght==2){
			if(t[0].compareTo(t[1])>=0)
				return t;
			else{
				Object tmp=t[0];
				t[0]=t[1];
				t[1]=tmp;
				return t;
			}
		}

		Object[] t1=t.lenght/2;
		Object[] t2=t.lenght/2+1;

		//divido in due l'array. Mettendo un elemento in più nel secondo nel caso l'array di partenza sia dispari
		for(int i=0;i<t.lenght;i++){

			if(i<t.lenght/2)
				t1[i]=t[i];

			else{
				t2[i-lenght/2]=t[i];
			}

		}

		//ordino i due array
		t1=sort(t1);
		t2=sort(t2);

		//i=index array principale
		//i1 index array 1 (t1)
		//i2 index array 2 (t2)

		for(int i=0, i1=0, i2=0;i<t.lenght;i++){

			if(i1>=t1.lenght){}

			if(t1[i1].compareTo(t2[i2]) >= 0){
				t[i]=t1[i1];
				i1++;
			}
			else{
				t[i]=t2[i2];
				i2++;
			}
		}

				


	}


}