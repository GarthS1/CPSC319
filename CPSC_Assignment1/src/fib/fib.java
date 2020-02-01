//Make javadoc documentation 
// all public static except the array for alg.2 and matrix power (make functions) 
package fib;
public class fib {
// medain 
	public static void main(String[] args) {
		
		for(long i = 0; i < 10; i++)
		{
			long timePast = System.currentTimeMillis();
			long num = fibRec(i);
			long timeTaken = System.currentTimeMillis() - timePast;
			System.out.println(timeTaken + " time to compute F" + i + " with alg.1 and got the result " + num);
		}
		
		long arr[] = new long[5000];
		for(int i = 0; i < 101; i++)
			arr[i] = -1;
		
		for(int i = 0; i < 100; i++)
		{
			long timePast = System.nanoTime();
			long num = fibMem(i, arr);
			long timeTaken = System.nanoTime()- timePast;
			System.out.println(timeTaken + " time to compute F" + i + " with alg.2 and got the result " + num);
		}
	}
	
	public static long fibRec(long n){
		long num = 0;
		if(n == 1) 
			num = 1;
		else if (n==0)
			num = 0;
		else 
			num = fibRec(n-1) + fibRec(n-2);
		return num; 
	}
	
	public static long fibMem(int n, long[] arr) {
		long num = 0;
		if(arr[n] != -1)
			num = arr[n];
		else if(n == 1) 
			arr[n] = num = 1;
		else if (n==0)
			arr[n] = num = 0;
		else 
			arr[n] = num = fibMem(n-1, arr) + fibMem(n-2, arr);
		return num; 	
	}

}
