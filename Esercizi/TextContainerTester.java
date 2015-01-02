import java.util.Scanner;
public class TextContainerTester{


	//container "ordinato"
	private TextContainer container=null;
	//Container "disordunato"
	private TextContainer container2=null;
	//container senza doppie
	private TextContainer container3=null;


	public static void main(String[] args){
		TextContainerTester tester=new TextContainerTester();
	}

	public TextContainerTester(){
		/*inizializzo un po' di cosette*/
		container=new TextContainer(new Scanner(System.in), " \t\n\r,.;:?!\\-()");
		//copio il container, cos da salvare l'ordine delle parole
		
		container3=new TextContainer();

		/*ordino*/

		
		/*Stampo*/
		System.out.println("!!STAMPA CONTAINER DISORDINATO!!");
		stamp(container);

		container.sort();

		System.out.println("!!STAMPA CONTAINER ORDINATO!!");
		stamp(container);

		/*Cancello le doppie parole*/
		int i=0;
		String[] tmp=new String[container.size()];
		//porto tutto su un array di stringhe
		while(!container.isEmpty()){
			tmp[i++]=container.removeLast();
			
		}
		//n.b.:riutilizzo 

		String compare=tmp[tmp.length-1];
		for(i=tmp.length-2;i>=0;i--){
			
			if(!compare.equals(tmp[i])){
				
				container3.add(compare);
				compare=tmp[i];
			}

		}
		container3.add(tmp[0]);
		System.out.println("!!STAMPA CONTAINER SENZA DOPPIE!!");
		stamp(container3);

	}

	public void stamp(TextContainer c){
		TextContainer tmp=new TextContainer();
		int i=0;



		while(!c.isEmpty()){
			String t=c.removeLast();
			//System.out.println(t);
			tmp.add(t);
		}

		while(!tmp.isEmpty()){
			String t=tmp.removeLast();
			System.out.printf("[%2d] => %s\n", i++, t);
			c.add(t);
		}

	}

}