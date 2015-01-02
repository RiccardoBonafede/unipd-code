/**
 * Classe Di Test per testare algoritmi di ordinamento(sort class)
 *
 * @author Riccardo Bonafede
 * @version 1.0 (finale)
 */
public class TestClass implements Comparable<TestClass>{

	private int anElement;

	public TestClass(){
		this.anElement=(int) (Math.random() * 100);
	}

	public static void main(String[] args){
		TestClass v[]=new TestClass[100];
		TestClass a[]=new TestClass[100];
		TestClass b[]=new TestClass[100];
		TestClass c[]=new TestClass[100];
		SortClass e=new SortClass();

		for(int i=0;i<100;i++){
			v[i]=new TestClass();
			System.out.printf("[%2d]=>%2d\t", i, v[i].getAnElement());

		}
			
		a=SortClass.MergeSort(v);

		for(int i=0;i<100;i++)
			System.out.printf("[%2d]=>%2d\t", i, a[i].getAnElement());
		/*b=SortClass.selectionSort(v);

		for(int i=0;i<100;i++)
			System.out.printf("[%2d]=>%2d\t", i, b[i].getAnElement());
		c=SortClass.insertionSort(v);

		for(int i=0;i<100;i++)
			System.out.printf("[%2d]=>%2d\t", i, c[i].getAnElement());*/

	}
	public int getAnElement(){return anElement;}

	public int compareTo(TestClass other){
		return anElement-other.getAnElement();
	}
	public int equals(TestClass t){
		return anElement;

	}
}