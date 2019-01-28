import java.math.BigInteger;
import java.util.Scanner;
public class PointMultiplicationTwo
{
public static void main(String[] args) 
{
 @SuppressWarnings("resource")
 Scanner in = new Scanner(System.in);
 System.out.println("Enter the order of a");
 BigInteger a=in.nextBigInteger();
 System.out.println("Enter the value of b");
 BigInteger b=in.nextBigInteger();
 System.out.println("Enter the value of p");
 BigInteger p=in.nextBigInteger();
 for(BigInteger x= new BigInteger("0");x.compareTo(p)<0;x=x.add(BigInteger.ONE))
 {
  BigInteger y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(p);	
  BigInteger c = p.add(new BigInteger("1")); //(P+1)
  BigInteger exponent=( c.divide(new BigInteger("4"))); //(P+1)/4
  BigInteger result1 = y.modPow(exponent, p);
  BigInteger result2 =p.subtract(result1);
  BigInteger x2=result1.modPow(new BigInteger("2"),p);
  BigInteger y2=result2.modPow(new BigInteger("2"),p);
  if((y.equals(x2)) && (y.equals(y2)))
  {					
   // For result1
   System.out.print("P1 ("+x+","+result1+") ");
   // compute numerator and denominator of tangent slope
   BigInteger numerator=(x.multiply(x).multiply(new BigInteger("3"))).add(a);
   BigInteger denominator=result1.add(result1);
   int count=0;
   //check or negative slope
   if (denominator.signum()==-1)
   {
    numerator=numerator.multiply(new BigInteger("-1"));
    denominator=denominator.multiply(new BigInteger("-1"));
    }
   // use FISH algorithm to compute the slope
   BigInteger slope=f(denominator,BigInteger.ZERO,numerator,p);
   x2 = (((slope.multiply(slope)).subtract(x)).subtract(x)).mod(p);
   y2 = (slope.multiply(x.subtract(x2)).subtract(result1)).mod(p);
   count++;
   BigInteger x3=x2;
   BigInteger y3=y2;
   for (count=3;;count++)
   {
	// computer numerator and denominator of slope of two points
	numerator=y3.subtract(result1);
	denominator=x3.subtract(x);
	// check for negative slope
	if (denominator.signum()==-1)
	{
	 numerator=numerator.multiply(new BigInteger("-1"));
	 denominator=denominator.multiply(new BigInteger("-1"));
	 }
	// Fish algorithm to compute the slope 
	slope=f(denominator,BigInteger.ZERO,numerator,p);
	if (slope.equals(BigInteger.ZERO) && denominator.equals(BigInteger.ZERO))
	break;
	x3 = (((slope.multiply(slope)).subtract(x)).subtract(x3)).mod(p);
	y3 =   (slope.multiply(x.subtract(x3))).subtract(result1).mod(p);
	}
   //compute the order
   System.out.println(count-1);
   }
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