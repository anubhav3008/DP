package com.anubhav.leetcode;
//https://leetcode.com/problems/predict-the-winner/#/submissions/1
public class PredictWinner {

	public static void main(String[] args) {

		int x[]={1,5,2};
		boolean ans=new PredictWinner().PredictTheWinner(x);
		System.out.println(ans);


	}

	public boolean PredictTheWinner(int[] nums) {
		int n=nums.length;
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++){
			dp[i][i]=nums[i];
		}
	
		
		for(int count=1;count<n;count++){
			int i=0;
			for(int j=count;j<n;j++){
			//	System.out.print(i+","+j+" ") ;
				dp[i][j]=Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
				i++;
			}
			//System.out.println();
		}
		/*
		 for (int len = 1; len < n; len++) {
		        for (int i = 0; i < n - len; i++) {
		            int j = i + len;
		            dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
		        }
		    }*/
		
	
/*		System.out.println("************");

		for(int x=0;x<n;x++){
			for(int y=0;y<n;y++){
				System.out.print(dp[x][y]+ " ");
			}
			System.out.println();
		}
		
		*/
		return dp[0][n-1]>=0;
		
		
	}

}
