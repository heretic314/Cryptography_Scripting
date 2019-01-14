import java.math.BigInteger;
import java.util.Scanner;
public class StepOne 
{
	public static void main(String[] args) 
	{
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of a");
		BigInteger a=in.nextBigInteger();
	    System.out.println("Enter the value of b");
		BigInteger b=in.nextBigInteger();
		System.out.println("Enter the value of p");
		BigInteger p=in.nextBigInteger();
		int count=0;
		for(BigInteger x= new BigInteger("0");x.compareTo(p)<0;x=x.add(BigInteger.ONE))
		    {
		        
			    BigInteger y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(p);	
		        //(P+1)/4
		        BigInteger c = p.add(new BigInteger("1")); 
			    BigInteger exponent=( c.divide(new BigInteger("4")));
				
			    BigInteger result1 = y.modPow(exponent, p);
				BigInteger result2 =p.subtract(result1);
				BigInteger x2=result1.modPow(new BigInteger("2"),p);
				BigInteger y2=result2.modPow(new BigInteger("2"),p);
				if((y.equals(x2)) && (y.equals(y2)))
			    {
					System.out.println(x+","+result2);
					System.out.println(x+","+result1);
    				count++;
				}
		}
		count=(count*2);
		System.out.println(count);
	}
}