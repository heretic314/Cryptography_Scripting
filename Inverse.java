import java.math.BigInteger;
import java.util.Scanner;
public class Inverse 
{
    public static void main(String[] args) 
	{
     BigInteger a,b,c;	
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of e");
        a = in.nextBigInteger();
       
        System.out.println("Enter the totient function ");
        b = in.nextBigInteger();
	    c = a.modInverse(b);
        String str = a + "^-1 mod " + b + " is " +c;
	    
        
        System.out.println( str );	
	}
    public static BigInteger sqrt1(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}
