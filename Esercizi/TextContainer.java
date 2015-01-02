import java.util.Scanner;
import java.util.NoSuchElementException;
public class TextContainer implements Container{
  private String[] stack;

  private int size, index;

  private final int START_LEN=1;

  public TextContainer(){

    stack=new String[START_LEN];
    size=START_LEN;
    index=-1; //non ci sono elementi nello stack
  }

  public TextContainer(Scanner reader, String delimiter){

    stack=new String[START_LEN];
    size=START_LEN;
    index=-1; //non ci sono elementi nello stack

    //reader.useDelimiter(delimiter);

    while(reader.hasNext())
      add(reader.next());

  }

  public boolean isEmpty(){
    return index<0;

  }

  public void makeEmpty(){
    index=-1;
  }

  public int size(){
    return index+1;
  }
  public void add(String aWord){
   
    if(++index>=size)
      doubleSize();
    stack[index]=aWord;
    
  }

  public void sort(){
    String[] tmp=new String[index+1];
    for(int i=0;i<=index;i++)
      tmp[i]=stack[i];
    tmp=mergeSort(tmp);
    for(int i=0;i<=index;i++)
      stack[i]=tmp[i];
  }

  public String removeLast(){
    if(isEmpty())
      throw new NoSuchElementException("Non ci sono elementi");
    String t=stack[index];
    stack[index]=null;
    index--;
    return t;
  }

  private void doubleSize(){
    String[] tmp=new String[size];
    

    for(int a=0;a<index;a++)
      tmp[a]=stack[a];



    
    size*=2;
    stack=new String[size];

    for(int a=0;a<index;a++)
      stack[a]=tmp[a];
    
  }

  //La dichiaro static, così non corro il rischio di andare a toccare variabili di istanza, e nel caso lo facessi otterrei un errore di compilazione.
  private static String[] mergeSort(String[] v){
    int size=v.length;

    if(size==0)
      throw new IllegalArgumentException("Array vuoto!");
    if(size==1)
      return v;
    if(size==2){
      if(v[0].compareTo(v[1])>0){
        String tmp=v[0];
        v[0]=v[1];
        v[1]=tmp;
      }
      return v;

    }

    String[] v1=new String[size/2],v2=null; //Array di supporto. v1 sara' sempre uguale alla meta' dell'rai originale. Invece v2 dipende se 'array originale e' pari o dispari
    String[] newV=new String[size]; //nuovo array ordinato;

    if((size%2) == 0)
      v2=new String[size/2];
    
    else
      v2=new String[size/2+1];

    //divido l'array in due part
    for(int a=0;a<size;a++){

      if(a<size/2)
        v1[a]=v[a];
      else
        v2[a-(size/2)]=v[a];
        
    }
    //ordino le due parti
    v1=mergeSort(v1);
    v2=mergeSort(v2);

    //Rimetto insieme i pezzi

    for(int i=0, i1=0, i2=0;i<size;i++){

      /*
       * Prima un po' di controlli sulla lunghezza dei due  array di supporto, poi il controllo vero e proprio*/

      if(i1>=v1.length)
        newV[i]=v2[i2++];
      else if(i2>=v2.length)
        newV[i]=v1[i1++];
      else if(v1[i1].compareTo(v2[i2])>0)
        newV[i]=v2[i2++];
      else
        newV[i]=v1[i1++];

    }
    return newV;
  }
}