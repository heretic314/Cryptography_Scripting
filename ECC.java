import java.math.BigInteger;
import java.util.Scanner;

public class ECC
{

public static void main(String[] args) 
{
	BigInteger slope, x2,y2,lastx, lasty;
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the value of a");
	BigInteger a=in.nextBigInteger();
    System.out.println("Enter the value of m");
	BigInteger m=in.nextBigInteger();
	System.out.println("Enter the value of x");
	BigInteger x1=in.nextBigInteger();
	System.out.println("Enter the value of y");
	BigInteger y1=in.nextBigInteger();

	int c;
	search:
		for( int i=1;;i=(c=(i+2)+1))
	{
		
	    	
	System.out.println("P"+i+" ("+x1+","+y1+") ");

		// compute numerator and denominator of tangent slope
	BigInteger sn=(x1.multiply(x1).multiply(new BigInteger("3"))).add(a);
	BigInteger sd=y1.add(y1);
		
		if (sd.signum()==-1)
		{

			sn=sn.multiply(new BigInteger("-1"));

			sd=sd.multiply(new BigInteger("-1"));

			}

		
		
		
		// use FISH algorith to compute the slope
		slope=f(sd,BigInteger.ZERO,sn,m);
		
		x2 = (((slope.multiply(slope)).subtract(x1)).subtract(x1)).mod(m);
		y2 = (slope.multiply(x1.subtract(x2)).subtract(y1)).mod(m);
		
		
		System.out.println("P"+(i+1)+" ("+x2+","+y2+") ");
		
		lastx=x2;
		lasty=y2;
		
		
		for ( c=(i+2);c<30;c++)
		{
			// computer numerator and denominator of slope of two points
			sn=lasty.subtract(y1);
			sd=lastx.subtract(x1);
			
			if (sd.signum()==-1)
			{

				sn=sn.multiply(new BigInteger("-1"));

				sd=sd.multiply(new BigInteger("-1"));

				}
            
			
			slope=f(sd,BigInteger.ZERO,sn,m);
			
			if (slope.equals(BigInteger.ZERO)&& sd.equals(BigInteger.ZERO))
			   {break search;}


			lastx = (((slope.multiply(slope)).subtract(x1)).subtract(lastx)).mod(m);
			lasty =   (slope.multiply(x1.subtract(lastx))).subtract(y1).mod(m);
			
			System.out.println("P"+c+" ("+lastx+","+lasty+")");
			
			
			}
		}
}
	public static BigInteger f(BigInteger n, BigInteger adder, BigInteger mult, BigInteger m) {

		// this is working
		//slope=f(sd,BigInteger.ZERO,sn,m);
		BigInteger  t,newt,r,newr,temp, quotient, answer;
		
		//n     =new BigInteger("1973");
		//adder =new BigInteger("25678");
		//mult  =new BigInteger("23");
		//m     =new BigInteger("2004");
		
		// the format of the variables is 1973x + 25678 = 23    mod 2004
		// the variable names would be    n   x + adder = mult  mod m
		
				
		t     = new BigInteger("0");
		newt  = new BigInteger("1");    
	    r = m;  
	    newr = n;    

	    while (!(newr.equals(BigInteger.ZERO)))
	    {
	        quotient = r.divide(newr);
	        temp=newr;
	        newr = r.subtract(quotient.multiply(newr));
	        r=temp;
	        
	        temp=newt;
	        newt=t.subtract(quotient.multiply(newt));
	        t=temp;
	    }
	    
	    if (r.compareTo(BigInteger.ONE) == 1)
	       return(BigInteger.ZERO);
	    else
	    	{
	    		if (t.compareTo(BigInteger.ZERO) == -1) t.add(m); 
	    	    answer =t.multiply(mult.subtract(adder.mod(m).add(m))).mod(m);
	    	    return(answer);
	    	}   
	    		
	}


}
