package com.anubhav.leetcode;

import com.anubhav.leetcode.printarray.PrintArray;

public class SubsetSum {

	public static void main(String ...args){
		boolean ans=new SubsetSum().isSubset(new int[]{1,1,1,1,1}, 5);
		System.out.println(ans);
	}
	
	
	public boolean isSubset(int A[], int sum){
		int N=A.length;
		boolean dp[][]=new boolean[N+1][sum+1];
		for(int i=0;i<=sum;i++) dp[0][i]=false;
		for(int i=0;i<=N;i++) dp[i][0]= true;
		
		for(int i=1;i<N+1;i++){
			for(int j=1;j<sum+1;j++){
				System.out.println(i+ " "+j);
				if(sum-A[i-1]>=0)
					dp[i][j]=dp[i-1][sum-A[i-1]] || dp[i-1][sum];
				else
					dp[i][j]=dp[i-1][sum];
			}
		}
		PrintArray.print(dp);
		return dp[N][sum];
	}
}
