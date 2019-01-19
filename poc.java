import java.math.BigInteger;
import java.util.Scanner;
public class poc
{
public static void main(String[] args)
{
	BigInteger a=new BigInteger("17");
	BigInteger b=new BigInteger("9");
	BigInteger m=new BigInteger("7951");
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the order of x1");
	BigInteger x1=in.nextBigInteger();
	System.out.println("Enter the order of y1");
	BigInteger y1=in.nextBigInteger();
	System.out.println("Enter the order of 'X'P");
	int p=in.nextInt();
	// compute numerator and denominator of tangent slope
	BigInteger numerator=(x1.multiply(x1).multiply(new BigInteger("3"))).add(a);
	BigInteger denominator=y1.add(y1);
	if (denominator.signum()==-1)
		{
         numerator=numerator.multiply(new BigInteger("-1"));
         denominator=denominator.multiply(new BigInteger("-1"));
        }
    // use FISH algorithm to compute the slope
    BigInteger slope=f(denominator,BigInteger.ZERO,numerator,m);
	BigInteger x2 = (((slope.multiply(slope)).subtract(x1)).subtract(x1)).mod(m);
	BigInteger y2 = (slope.multiply(x1.subtract(x2)).subtract(y1)).mod(m);
	BigInteger x3=x2;
	BigInteger y3=y2;
	for (int c=3;;c++)
		{
			// computer numerator and denominator of slope of two points
			numerator=y3.subtract(y1);
			denominator=x3.subtract(x1);
			if (denominator.signum()==-1)
			{
                numerator=numerator.multiply(new BigInteger("-1"));
                denominator=denominator.multiply(new BigInteger("-1"));
            }
            slope=f(denominator,BigInteger.ZERO,numerator,m);
			 if (slope.equals(BigInteger.ZERO) && denominator.equals(BigInteger.ZERO))
             break;
            x3 = (((slope.multiply(slope)).subtract(x1)).subtract(x3)).mod(m);
			y3 =   (slope.multiply(x1.subtract(x3))).subtract(y1).mod(m);
			if(p==c)
			System.out.println("P"+c+" ("+x3+","+y3+")");
			}
		}
//Fish algorithm
public static BigInteger f(BigInteger n, BigInteger addition, BigInteger multiplication, BigInteger m)
{
  BigInteger q     = new BigInteger("0");
	BigInteger p  = new BigInteger("1");
	BigInteger r = m;
	BigInteger newr = n;
	while (!(newr.equals(BigInteger.ZERO)))
  {
  	BigInteger quotient = r.divide(newr);
      BigInteger temp=newr;
      newr = r.subtract(quotient.multiply(newr));
      r=temp;
      temp=p;
      p=q.subtract(quotient.multiply(p));
      q=temp;
  }

  if (r.compareTo(BigInteger.ONE) == 1)
     return(BigInteger.ZERO);
  else
  	{
  		if (q.compareTo(BigInteger.ZERO) == -1) q.add(m);
  		BigInteger answer =q.multiply(multiplication.subtract(addition.mod(m).add(m))).mod(m);
  	    return(answer);
  	}
  }
}
