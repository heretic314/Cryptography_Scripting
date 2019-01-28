import java.util.Scanner;
public class Generator 
{

      public static void main(String[] args) 
      {
       @SuppressWarnings("resource")
	   Scanner s = new Scanner(System.in);
       System.out.print("Enter a number : ");
       long n = s.nextLong();
       if (isPrime(n)) 
       {
        System.out.println(n + " is a prime number");
       } 
       else
       {
        System.out.println(n + " is not a prime number");
       }
       long p = (n-1)/2;
       if (isPrime(p)) 
       {
        System.out.println(p + " is a prime number");
       } 
       else
       {
        System.out.println(p + " is not a prime number");
       }
       
   }

   public static boolean isPrime(Long n) 
   {
       if (n <= 1) 
       {
       return false;
       }
       for (int i = 2; i < Math.sqrt(n); i++) {
           if (n % i == 0) {
               return false;
           }
       }
       return true;
   }
}


