package com.anubhav.hackerrank;
import java.util.Scanner;

public class CoinChange {

    static long getWays(long n, long[] c){
        
    	long dp[][]= new long[c.length+1][(int) (n+1)];
        
    	for(int i=0;i< dp.length;i++)
    		dp[i][0]=1;
   // 	print(dp);
        for(int i=0;i<=c.length;i++){
            for(int j=1;j<=n;j++) {
            	if(i-1>=0 && i<c.length && j-c[i]>=0)
            		dp[i][j]+=dp[i][(int) (j-c[i])]+ dp[i-1][j];
            	else if(i<c.length && j-c[i] >=0)
            		dp[i][j]+=dp[i][(int) (j-c[i])];
            	else if(i-1>=0)
            		dp[i][j]+=dp[i-1][j];
            }
        }
    //    print(dp);
        return dp[c.length][(int)n];
    }

    private static  void print(long dp[][]) {
    	
        for(int i=0;i<dp.length;i++) {
        	for(int j=0;j<dp[0].length;j++) {
        		System.out.print(dp[i][j]+ " ");
        		
        	}
        	System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
