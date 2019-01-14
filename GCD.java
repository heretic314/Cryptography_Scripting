import java.math.BigInteger;
import java.util.Scanner;
public class GCD{
public static void main(String[] args) 
{
	   @SuppressWarnings("resource")
	   Scanner in = new Scanner(System.in);
	   System.out.println("Enter the Integer");
	   Long a;
	   a = in.nextLong();
	   System.out.println("You entered integer "+a);
	   System.out.println("Enter the Integer");
	   Long b;
	   b = in.nextLong();
	   System.out.println("You entered integer "+b);
	   long c= gcd(a,b);
	   System.out.println("Prime factors of number are:"+c);
	 }
public static long gcd(Long a, Long b)
{
   return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
}
}