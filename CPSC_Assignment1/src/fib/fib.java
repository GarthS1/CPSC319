package fib;
/**
 * Contains five different ways to calculate the Fibonacci series 
 * @ author Garth Slaney 
 * @ Version 1.0
 */
public class fib {
	public static void main(String[] args) {
		
		// for loop to test all five algorithms 
		// cycles through each one to avoid processor disruptions 
		for(int i = 0; i <= 50; i++) 
		{
			//arrays to store times 
			long rec[] = new long [5];
			long mem[] = new long [5];
			long dyn[] = new long [5];
			long itr[] = new long [5];
			long mat[] = new long [5];
			
			//average time for each process 
			long rec_average = 0;
			long mem_average = 0;
			long dyn_average = 0;
			long itr_average = 0;
			long mat_average = 0;
			
			// runs each index five times and averages it in an array 
			for(int j = 0; j < 5; j++)
			{

				// getting time for Alg.1
				long timePast = System.nanoTime();
				long num = fibRec(i);
				long timeTaken = System.nanoTime() - timePast;
				rec[j] = timeTaken;
				
				// getting time for Alg.2
			  timePast = System.nanoTime();
				num = fibMem(i);
				timeTaken = System.nanoTime()- timePast;
				mem[j] = timeTaken;
					
				//getting time for Alg. 3
			  timePast = System.nanoTime();
				num = fibDyn(i);
				timeTaken = System.nanoTime()- timePast;
				dyn[j] = timeTaken;
				
				//getting time for Alg. 4
			  timePast = System.nanoTime();
				num = fibItr(i);
				timeTaken = System.nanoTime()- timePast;
				itr[j] = timeTaken;
				
				//getting time for Alg. 5
			  timePast = System.nanoTime();
				num = fibMat(i);
				timeTaken = System.nanoTime()- timePast;
				mat[j] = timeTaken;
			}
			
			//sum up the arrays 
			for(int a = 0; a < 5; a++)
				rec_average += rec[a];			
			for(int a = 0; a < 5; a++)
				mem_average += mem[a];			
			for(int a = 0; a < 5; a++)
				dyn_average += dyn[a];
			for(int a = 0; a < 5; a++)
				itr_average += itr[a];
			for(int a = 0; a < 5; a++)
				mat_average += mat[a];
			
			//caculate the average time 
			rec_average /= 5;
			mem_average /= 5;
			dyn_average /= 5;
			itr_average /= 5;
			mat_average /= 5;
			
			//print out times taken
			System.out.println(rec_average + " time to compute F" + i + " with alg.1");
			System.out.println(mem_average + " time to compute F" + i + " with alg.2");
			System.out.println(dyn_average + " time to compute F" + i + " with alg.3");
			System.out.println(itr_average + " time to compute F" + i + " with alg.4");
			System.out.println(mat_average + " time to compute F" + i + " with alg.5\n");
		}
		
		//going up by powers of 2 for alg.2-5 stops at 16384 otherwise encounters stack overflow in alg.2 
		for(int i = 2; i <= 16384; i *=2)
		{
			//arrays to store times 
			long mem[] = new long [5];
			long dyn[] = new long [5];
			long itr[] = new long [5];
			long mat[] = new long [5];
			
			//average time for each process 
			long mem_average = 0;
			long dyn_average = 0;
			long itr_average = 0;
			long mat_average = 0;
			
			// runs each index five times and averages it in an array 
			for(int j = 0; j < 5; j++)
			{
				
				// getting time for Alg.2
			  long timePast = System.nanoTime();
				long num = fibMem(i);
				long timeTaken = System.nanoTime()- timePast;
				mem[j] = timeTaken;
					
				//getting time for Alg. 3
			  timePast = System.nanoTime();
				num = fibDyn(i);
				timeTaken = System.nanoTime()- timePast;
				dyn[j] = timeTaken;
				
				//getting time for Alg. 4
			  timePast = System.nanoTime();
				num = fibItr(i);
				timeTaken = System.nanoTime()- timePast;
				itr[j] = timeTaken;
				
				//getting time for Alg. 5
			  timePast = System.nanoTime();
				num = fibMat(i);
				timeTaken = System.nanoTime()- timePast;
				mat[j] = timeTaken;
			}
			
			//sum up the arrays 		
			for(int a = 0; a < 5; a++)
				mem_average += mem[a];			
			for(int a = 0; a < 5; a++)
				dyn_average += dyn[a];
			for(int a = 0; a < 5; a++)
				itr_average += itr[a];
			for(int a = 0; a < 5; a++)
				mat_average += mat[a];
			
			//caculate the average time 
			mem_average /= 5;
			dyn_average /= 5;
			itr_average /= 5;
			mat_average /= 5;
			
			//print out times taken
			System.out.println(mem_average + " time to compute F" + i + " with alg.2");
			System.out.println(dyn_average + " time to compute F" + i + " with alg.3");
			System.out.println(itr_average + " time to compute F" + i + " with alg.4");
			System.out.println(mat_average + " time to compute F" + i + " with alg.5\n");
		}
		
		//going up by powers of 2 for alg.3-5 
		for(int i = 2; i <= 134217728; i *=2)
		{
			//arrays to store times 
			long dyn[] = new long [5];
			long itr[] = new long [5];
			long mat[] = new long [5];
			
			//average time for each process 
			long dyn_average = 0;
			long itr_average = 0;
			long mat_average = 0;
			
			// runs each index five times and averages it in an array 
			for(int j = 0; j < 5; j++)
			{
				//getting time for Alg. 3
			  long timePast = System.nanoTime();
				long num = fibDyn(i);
				long timeTaken = System.nanoTime()- timePast;
				dyn[j] = timeTaken;
				
				//getting time for Alg. 4
			  timePast = System.nanoTime();
				num = fibItr(i);
				timeTaken = System.nanoTime()- timePast;
				itr[j] = timeTaken;
				
				//getting time for Alg. 5
			  timePast = System.nanoTime();
				num = fibMat(i);
				timeTaken = System.nanoTime()- timePast;
				mat[j] = timeTaken;
			}
			
			//sum up the arrays 				
			for(int a = 0; a < 5; a++)
				dyn_average += dyn[a];
			for(int a = 0; a < 5; a++)
				itr_average += itr[a];
			for(int a = 0; a < 5; a++)
				mat_average += mat[a];
			
			//caculate the average time 
			dyn_average /= 5;
			itr_average /= 5;
			mat_average /= 5;
			
			//print out times taken
			System.out.println(dyn_average + " time to compute F" + i + " with alg.3");
			System.out.println(itr_average + " time to compute F" + i + " with alg.4");
			System.out.println(mat_average + " time to compute F" + i + " with alg.5\n");
		}
	}	

	/**
	 * Compute Fn using the recursive definition given above using recursive function calls.
	 * @param n the index of the Fibonacci series to be retrived 
	 * @return the vaule of the Fibonacci series at that point 
	 */
	public static long fibRec(int n){
		long num = 0;
		
		if(n == 1) 
			num = 1;
		else if (n == 0)
			num = 0;
		else 
			num = fibRec(n-1) + fibRec(n-2);
		
		return num; 
	}
	
	/**
	 * Compute Fn using memoization in an array.
	 * @param n the index of the Fibonacci series to be retrived  
	 * @return the vaule of the Fibonacci series at that point 
	 */
	public static long fibMem(int n) {
		
		//makes an array to store previous recursive calls
		long arr[] = new long[n + 1];
		for(int i = 0; i < n + 1; i++)
			arr[i] = -1;
		
		return cache(n, arr);	
	}
	
	/**
	 * Uses the array passed to do recursion and save previous results 
	 * @param n the index of the Fibonacci series to be retrived 
	 * @param arr the cache of prevouis results
	 * @return the vaule of the Fibonacci series at that point 
	 */
	private static long cache(int n, long arr[])
	{
		long num = 0; 
		
		if(arr[n] != -1)
			num = arr[n]; //gets value from previous recursive
		else if(n == 1) 
			arr[n] = num = 1;
		else if (n == 0)
			arr[n] = num = 0;
		else 
			arr[n] = num = cache(n-1, arr) + cache(n-2, arr); //makes recursive call 

		return num;
	}
		
	/**
	 * Compute Fn using an array from the bottom up (dynamic programming)
	 * @param n the index of the Fibonacci series to be retrived  
	 * @return the vaule of the Fibonacci series at that point 
	 */
	public static long fibDyn(int i) {
		long arr[] = new long[i + 1];
		
		//puts first two vaules in the array to caculate future ones 
		arr[0] = 0;
		if( i + 1 > 1) //need to make sure not caculating i = 0   
		{
			arr[1] = 1;
		}
		
		for(int k = 2; k < i + 1; k++)
		{
			arr[k] = arr[k-1] + arr[k-2];
		}
		return arr[i];
	}

	/**
	 * Compute Fn using an iterative loop without using an array 
	 * @param n the index of the Fibonacci series to be retrived  
	 * @return the vaule of the Fibonacci series at that point 
	 */
	public static long fibItr(int i) {
		long f1 = 1; 
		long f2 = 0;
		
		//base cases 
		if(i == 0)
			return f2;
		if(i == 1)
			return f1;
		
		//iterative loop
		for(int k = 0; k < i; k++)
		{
			long temp = f1;
			f1 += f2;
			f2 = temp;
		}
		return f1;
	}
	
	/**
	 * Computes Fn using matrix exponentiation 
	 * @param n the index of the Fibonacci series to be retrived  
	 * @return the vaule of the Fibonacci series at that point 
	 */
	public static long fibMat(int i) {
		
		if(i == 0) //base condition
			return 0;
		
		long fm[][] = new long[][] { {1,1}, {1,0} };
		matExp(i - 1, fm);
		return fm[0][0];
	}
	
	/** 
	 * Caculates the power of an matrix
	 * @param n intger to raise the power 
	 * @param arr 2x2 matrix
	 */
	private static void matExp(int n, long arr[][]) {
		if(n > 1) // if n = 1 don't do any multiplication 
		{
			matExp(n/2, arr);
			
			long temp[][] = new long[2][2]; // temp array for multiplication 
			for(int i = 0; i < 2; i++) 
			{
				for(int j = 0; j < 2; j++)
				{
					for(int k = 0; k < 2; k++)
						temp[i][j] += arr[i][k] * arr[k][j]; // matrix multiplication 
				}
			}
			
			//changes vaules into arr 
			for(int i = 0; i < 2; i++)
				for(int j = 0; j < 2; j++)
					arr[i][j] = temp[i][j];

			if(n % 2 == 1) // checking if n is odd 
			{
				long update[][]  = new long[2][2]; // temp array for multiplication
				long basic[][]	 = { {1,1}, {1,0}};
				for(int i = 0; i < 2; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						for(int k = 0; k < 2; k++)
							update[i][j] += arr[i][k] * basic[k][j]; // matrix multiplication 
					}
				}
				
			  //changes vaules into arr 
			  for(int i = 0; i < 2; i++)
					for(int j = 0; j < 2; j++)
						arr[i][j] = update[i][j];
			}
		}
	}
}