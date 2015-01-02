/**
	Classe per strotture stack
	@author Bonafede Riccardo
*/
	public class Stack<E>{
		private Object[] stack;
		private int index;
		public int size=1;

		public Stack(){
			stack=new Object[size];
			index=-1;
		}

		public <E> void push(E element){
			if(index+1>=size){
				
				int i=0;
				Object[] tmp=new Object[size];
				for(Object item : stack)
					tmp[i++]=item;
					
				
				size*=2;i=0;
				stack=new Object[size];
				for(Object item: tmp){
					stack[i++]=item;
				}
			}

			stack[++index]=element;
		}
		public E pop(){
			index--;
			return (E) stack[index+1];
		}

	}