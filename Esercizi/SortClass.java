import java.util.Arrays;

public class SortClass{

	public SortClass(){
		//Costruttore vuoto

	}

	public static <T extends Comparable<T>> T[] selectionSort(T[] v){
		int size=v.length;
		int iWhile=0;

		if(size==0)
			throw new IllegalArgumentException("Array vuoto");

		if(size==1)
			return v;

		while(iWhile<size){

			T tmp=null;
			int iSmaller=iWhile;
			
			for(int i=iWhile;i<size;i++){
				if(v[iSmaller].compareTo(v[i])>0){	//Se iSmaller è più grande di i, allora fai si che i diventi iSmaller
					iSmaller=i;
				}
			}

			tmp=v[iWhile];
			v[iWhile]=v[iSmaller];
			v[iSmaller]=tmp;
			iWhile++;
		}
		return v;
	}
	public static <T extends Comparable<T>> T[] insertionSort(T[] v){
		int size=v.length;

		if(size==0)
			throw new IllegalArgumentException("Array vuoto");

		if(size==1)
			return v;

		for(int i=1;i+1<size;i++){
			
				for(int n=i;n>0 && v[n].compareTo(v[n-1])<0;n--){
					T tmp=v[n-1];
					v[n-1]=v[n];
					v[n]=tmp;

				}
			

		}
		return v;
	}
	/*public static  <T extends Comparable<T>> T[] iMergeSort(T[] v){
		int size=v.length, sSize=size, index=0; //subStringSize
		
		while(true){


			while(true){

					System.out.printf("[%2d %2d] [%2d %2d]\n",index, index+sSize, index+sSize, index+sSize*2);
				T[] v1=(T[])Arrays.copyOfRange(v, index, index+sSize);
				T[] v2=(T[])Arrays.copyOfRange(v, index+sSize, index+sSize*2);


				

				
				index+=sSize*2;
			}
			for(int i=index, i1=0 , i2=0; i<sSize*2; i++){		//dichiara tre variabili: i=index di tmp, i1 =index di v1, i2=index di v2
				//confronta gli elementi all'indice degli array, che poi sposta in tmp nella posizione del suo indice. n.b. l'indice viene poi incrementato


					if(i1>=v1.length){
						v[i]=v2[i2++];
					}
					else if(i2>=v2.length)
						v[i]=v1[i1++];
					else if(v1[i1].compareTo(v2[i2])<0)
						v[i]=v1[i1++];
					else
						v[i]=v2[i2++];
				}
			sSize=2;
			index=0;

		}
		return v;
	}
	*/
	public static  <T extends Comparable<T>> T[] mergeSort(T[] v){
		int size=v.length;

		if(size==0)
			throw new IllegalArgumentException("Array Vuoto!");
		if(size==1)
			return v;
		if(size==2){
			if(v[0].compareTo(v[1])>0){		//se il primo elemento è più grande del secondo li inverte
				T tmp=v[0];
				v[0]=v[1];
				v[1]=tmp;
			}

			return v;	//ritorna l'array ordinato
		}
		/*Splitto l'array in due parti e le ordino: v1, v2*/

		int a=0;
		T[] v1=mergeSort((T[])Arrays.copyOfRange(v, 0, size/2));
		T[] v2=mergeSort((T[])Arrays.copyOfRange(v, size/2, size));
		

		for(int i=0, i1=0 , i2=0; i<size; i++){		//dichiara tre variabili: i=index di tmp, i1 =index di v1, i2=index di v2
			//confronta gli elementi all'indice degli array, che poi sposta in tmp nella posizione del suo indice. n.b. l'indice viene poi incrementato


			if(i1>=v1.length){
				v[i]=v2[i2++];
			}
			else if(i2>=v2.length)
				v[i]=v1[i1++];
			else if(v1[i1].compareTo(v2[i2])<0)
				v[i]=v1[i1++];
			else
				v[i]=v2[i2++];
		}

		return (T[])v;
	
	}
		
	



}
