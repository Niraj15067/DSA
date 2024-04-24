package com.example.demo.dynamicProgramming;

public class TotalWaysToFomrmN {
	public static void main(String[] args) {
		int solve = solve1(7);
		System.out.println("Number of ways to form are : "+solve);
	}

		// Returns the number of arrangements to 
		// form 'n'. 
		public static int solve(int n) 
		{ 
			// base case 
			if (n < 0) 
				return 0; 
			if (n == 0) 
				return 1; 

			return solve(n - 1) + solve(n - 3) + solve(n - 5); 
		} 
		public static int solve1(int n) {
		    if (n < 0) {
		        return 0;
		    }
		    
		    int[] dp = new int[n + 1];
		    dp[0] = 1; // Base case

		    for (int i = 1; i <= n; i++) {
		        dp[i] += i - 1 >= 0 ? dp[i - 1] : 0;
		        dp[i] += i - 3 >= 0 ? dp[i - 3] : 0;
		        dp[i] += i - 5 >= 0 ? dp[i - 5] : 0;
		    }

		    return dp[n];
		}

}
