import java.math.BigInteger;
import java.util.Scanner;
public class SRGenerator
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
		System.out.println("Enter the value of g");
		int g=in.nextInt();
		for(BigInteger x= new BigInteger("0");x.compareTo(p)<0;x=x.add(BigInteger.ONE))
		    {
		        BigInteger y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(p);	
		        BigInteger c = p.add(new BigInteger("1")); //(P+1)/4
			    BigInteger exponent=( c.divide(new BigInteger("4")));
				BigInteger result1 = y.modPow(exponent, p);
				BigInteger result2 =p.subtract(result1);
				BigInteger x2=result1.modPow(new BigInteger("2"),p);
				BigInteger y2=result2.modPow(new BigInteger("2"),p);
				if((y.equals(x2)) && (y.equals(y2)))
			    

               {					
					
				
				
				// For result1
				//System.out.print("P1 ("+x+","+result1+") ");
				// compute numerator and denominator of tangent slope
				BigInteger sn=(x.multiply(x).multiply(new BigInteger("3"))).add(a);
				BigInteger sd=result1.add(result1);
					int count=0;
					if (sd.signum()==-1)
					{

						sn=sn.multiply(new BigInteger("-1"));

						sd=sd.multiply(new BigInteger("-1"));

						}
					// use FISH algorithm to compute the slope
					BigInteger slope=f(sd,BigInteger.ZERO,sn,p);
					
					x2 = (((slope.multiply(slope)).subtract(x)).subtract(x)).mod(p);
					y2 = (slope.multiply(x.subtract(x2)).subtract(result1)).mod(p);
					
					count++;
					//System.out.print("P2 ("+x2+","+y2+") ");
					
					BigInteger lastx=x2;
					BigInteger lasty=y2;
					
					for (count=3;;count++)
					{
						// computer numerator and denominator of slope of two points
						sn=lasty.subtract(result1);
						sd=lastx.subtract(x);
						
						if (sd.signum()==-1)
						{
                            sn=sn.multiply(new BigInteger("-1"));
                            sd=sd.multiply(new BigInteger("-1"));
                         }
			            
						slope=f(sd,BigInteger.ZERO,sn,p);
				        if (slope.equals(BigInteger.ZERO) && sd.equals(BigInteger.ZERO))
			            			break;
			            
						lastx = (((slope.multiply(slope)).subtract(x)).subtract(lastx)).mod(p);
						lasty =   (slope.multiply(x.subtract(lastx))).subtract(result1).mod(p);
						/*if (slope.compareTo(BigInteger.ZERO)<1)
						   {break;}*/
						
						//System.out.print("P"+c1+" ("+lastx+","+lasty+")");
						}
					System.out.println(count-1);
					if((count-1)==g)
						System.out.print("P"+(count-1)+" ("+lastx+","+lasty+")");	
					}
				
				
				
		    
		// For result2
		System.out.print("P1 ("+x+","+result2+") ");
		// compute numerator and denominator of tangent slope
		BigInteger sn=(x.multiply(x).multiply(new BigInteger("3"))).add(a);
		BigInteger sd=result2.add(result2);
			int count=0;
			if (sd.signum()==-1)
			{

				sn=sn.multiply(new BigInteger("-1"));

				sd=sd.multiply(new BigInteger("-1"));

				}
			// use FISH algorithm to compute the slope
			BigInteger slope=f(sd,BigInteger.ZERO,sn,p);
			
			x2 = (((slope.multiply(slope)).subtract(x)).subtract(x)).mod(p);
			y2 = (slope.multiply(x.subtract(x2)).subtract(result2)).mod(p);
			
			count++;
			//System.out.print("P2 ("+x2+","+y2+") ");
			
			BigInteger lastx=x2;
			BigInteger lasty=y2;
			
			for (count=3;;count++)
			{
				// computer numerator and denominator of slope of two points
				sn=lasty.subtract(result2);
				sd=lastx.subtract(x);
				
				if (sd.signum()==-1)
				{
                    sn=sn.multiply(new BigInteger("-1"));
                    sd=sd.multiply(new BigInteger("-1"));
                 }
	            
				slope=f(sd,BigInteger.ZERO,sn,p);
		        if (slope.equals(BigInteger.ZERO) && sd.equals(BigInteger.ZERO))
	            			break;
	            
				lastx = (((slope.multiply(slope)).subtract(x)).subtract(lastx)).mod(p);
				lasty =   (slope.multiply(x.subtract(lastx))).subtract(result2).mod(p);
				/*if (slope.compareTo(BigInteger.ZERO)<1)
				   {break;}*/
				
				//System.out.print("P"+c1+" ("+lastx+","+lasty+")");
				}
			System.out.println(count-1);
			if((count-1)==g)
				System.out.print("P"+(count-1)+" ("+lastx+","+lasty+")");	
			}
		
		
		
    
				
				
	
}

public static BigInteger f(BigInteger n, BigInteger adder, BigInteger mult, BigInteger m) {


	BigInteger  t,newt,r,newr,temp, quotient, answer;
	
		
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

