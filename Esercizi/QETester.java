import java.util.Scanner;
public class QETester
{  public static void main(String[] args) throws java.io.IOException  
   {  Scanner in = new Scanner(new java.io.FileReader(args[0]));
      QE q = new QE();
       
      while (in.hasNextLine())                     // prova del metodo enqueue()
         q.enqueue(in.nextLine());
      
      in.close();
         
      System.out.println("\nsize: " + q.size());      // prova del metodo size()
          
      Object[] a = q.toArray();                    // prova del metodo toArray()
      Object[] b = q.toSortedArray();        // prova del metodo toSortedArray()
      Object[] c = q.toSet();                        // prova del metodo toSet()  
      
      int j = 0;
      while (!q.isEmpty())
      {  System.out.println("front:   " + q.front());    // prova metodo front()
         System.out.println("dequeue: " + q.dequeue()); // prova metododequeue()
      }
      System.out.println();

      System.out.println("size: " + q.size());        // prova del metodo size()
      System.out.println();      
   
      for (int i = 0; i < a.length; i++)           // prova del metodo toArray()
         System.out.println("toArray: " + i + " " + a[i]);
      System.out.println();   
         
      for (int i = 0; i < b.length; i++)     // prova del metodo toSortedArray()
         System.out.println("toSortedArray: " + i + " " + b[i]);         
      System.out.println();
      
      System.out.println("toSet size" + " " +c.length);
      for (int i = 0; i < c.length; i++)             // prova del metodo toSet()
         System.out.println("toSet: " + i + " " + c[i]);
      System.out.println();  
   }     
} 