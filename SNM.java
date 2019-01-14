import java.math.*;
import java.util.Scanner;
public class SNM {
public static void main(String[] args) 
{
        BigInteger number,modulus,exponent,result;
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    System.out.println("enter number");
	    number = in.nextBigInteger();
        System.out.println("enter exponent");
        exponent = in.nextBigInteger();
        System.out.println("enter Modulus");
        modulus = in.nextBigInteger();
       
        
        
        result = number.modPow(exponent, modulus);
       
       String str = number + "^" +exponent+ " mod " + modulus + " is " +result;
        System.out.println( "result is "+str );
       
        	
    }
}