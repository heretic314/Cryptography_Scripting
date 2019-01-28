import java.math.BigInteger;
import java.util.Scanner;
public class SquareAndMultiply 
	{
		 public static void main(String[] args) 
		 {
		  @SuppressWarnings("resource")
		  Scanner in = new Scanner(System.in);
	      System.out.println("Enter the base"); 
		  String base= in.next();
		  System.out.println("Enter the exponent");
		  String exponent= in.next();
		  System.out.println("Enter the mod");
		  String mod= in.next();
		  BigInteger bm=new BigInteger(mod);
		  BigInteger m=new BigInteger(exponent);
		  BigInteger u=new BigInteger(base);
		  BigInteger a=new BigInteger("1");
		  u=u.mod(new BigInteger(mod));
		  while (m.compareTo(BigInteger.ZERO) > 0)
		  {
		   if (!m.mod(new BigInteger("2")).equals(BigInteger.ZERO))
		   a=(a.multiply(u)).mod(bm);
		   m=m.divide(new BigInteger("2"));
		   u=u.modPow(new BigInteger("2"),bm);
		  }
		  System.out.println(base+"^"+exponent+" mod"+mod);
		  System.out.println("\nAnswer:"+a);
		 }
		}

