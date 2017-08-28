package com.anubhav.leetcode;

public class MinimumSumPath {

	public static void main(String[] args) {
		

		int grid[][]={
				{
					1,2,3,4
				},
				{
					5,6,7,8
				}
		};
		int ans=new MinimumSumPath().minPathSum(grid);
		System.out.println(ans);
	}
	
	 public int minPathSum(int[][] grid) {
		 int m=grid.length;
		 int n=grid[0].length;
	     int dp[][]=new int[m][n];
	     for(int i=0;i<m;i++){
	    	 for(int j=0;j<n;j++){
	    		 dp[i][j]=-1;
	    	 }
	     }
	     
	     return minPath(dp, 0, 0, m, n, grid);
	        
	 }
	 
	 
	 public int minPath(int dp[][],int i,int j, int m,int n, int[][]grid){
		 if(i>=m || j>=n) return -2;
		 if(i==m-1 && j==n-1) return grid[i][j];
		 if(dp[i][j]!=-1) return dp[i][j];
		 int minPath1=minPath(dp, i+1, j, m, n,grid);
		 int minPath2=minPath(dp, i, j+1, m, n, grid);
		 if(minPath1 !=-2 && minPath2 !=-2)
			 dp[i][j]=grid[i][j]+Math.min(minPath1,minPath2 );
		 else if(minPath1==-2)
			 dp[i][j]=grid[i][j]+minPath2;
		 else if(minPath2==-2)
			 dp[i][j]=grid[i][j]+minPath1;
		 else
			 dp[i][j]=grid[i][j];
		 return dp[i][j];
		 
	 }

}
