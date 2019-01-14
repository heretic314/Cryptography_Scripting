import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Demo {

	public static void main(String[] args) 
	{
		   @SuppressWarnings("resource")
		   Scanner in = new Scanner(System.in);
		   System.out.println("Enter the Integer");
		   int a;
		   a = in.nextInt();
		   System.out.println("You entered integer "+a);
		   List<Integer> c= primeFactor(a);
		   System.out.println("Prime factors of number are:"+c);
		 }
		   
		   public static List<Integer> primeFactor(long number)
		   {
		     List<Integer> primefactor = new ArrayList<>();
			 long xyz = number;
			 for (int i = 2; i <= xyz; i++) 
			 {
			  if (xyz % i == 0) 
			  { 
			   primefactor.add(i); // prime factor 
			   xyz /= i;
			   i--; 
			  } 
			 } 
			  return primefactor; 
		    }
		}

