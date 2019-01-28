import java.math.BigInteger;
public class SeniorGenerator 
{
public static void main(String[] args) 
{
	BigInteger a=new BigInteger("510");
	BigInteger b=new BigInteger("790");
	BigInteger m=new BigInteger("7919");
	BigInteger x1=new BigInteger("6619");
    BigInteger y1=new BigInteger("6688");
	System.out.println("P1 ("+x1+","+y1+") ");
    // compute numerator and denominator of tangent slope
	BigInteger numerator=(x1.multiply(x1).multiply(new BigInteger("3"))).add(a);
	BigInteger denominator=y1.add(y1);
	// check for negative slope
	if (denominator.signum()==-1)
		{
         numerator=numerator.multiply(new BigInteger("-1"));
         denominator=denominator.multiply(new BigInteger("-1"));
        }
    // use FISH algorithm to compute the slope
	BigInteger slope=f(denominator,BigInteger.ZERO,numerator,m);
	BigInteger x2 = (((slope.multiply(slope)).subtract(x1)).subtract(x1)).mod(m);
	BigInteger y2 = (slope.multiply(x1.subtract(x2)).subtract(y1)).mod(m);
	System.out.println("P2 ("+x2+","+y2+") ");
	BigInteger x3=x2;
	BigInteger y3=y2;
	// change value of c< "x" as per your requirement of output
	for (int c=3;c<600;c++)
		{
			// computer numerator and denominator of slope of two points
			numerator=y3.subtract(y1);
			denominator=x3.subtract(x1);
			// check for negative slope
			if (denominator.signum()==-1)
			{
                numerator=numerator.multiply(new BigInteger("-1"));
                denominator=denominator.multiply(new BigInteger("-1"));
            }
            slope=f(denominator,BigInteger.ZERO,numerator,m);
			// check for slope zero and denominator zero 
            if (slope.equals(BigInteger.ZERO) && denominator.equals(BigInteger.ZERO))
            break;
            x3 = (((slope.multiply(slope)).subtract(x1)).subtract(x3)).mod(m);
			y3 =   (slope.multiply(x1.subtract(x3))).subtract(y1).mod(m);
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