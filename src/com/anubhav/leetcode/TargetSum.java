package com.anubhav.leetcode;

public class TargetSum {

	public static void main(String[] args) {
		int ans=new TargetSum().findTargetSumWays(new int[]{1,2,7,9,981}, 1000000000);
		System.out.println(ans);
	}
	
    public int findTargetSumWays(int[] nums, int S) {
		
    	int n=nums.length;
    	int totalSum=0;
    	for(int i=0;i<n;i++){
    		totalSum+=nums[i];
    	}
    	if(((totalSum+S)%2)!=0) return 0;
    	
    	int sumReq=(totalSum+S)/2;
    	System.out.println(sumReq);
    	if(sumReq <0){
    		int scale=-sumReq;
    		for(int i=0;i<n;i++){
    			nums[i]=nums[i]+scale;
    		}
    	}
    	
    	
    	
    	int dp[][]=new int[n+1][sumReq+1];
    	
    	for(int i=0;i<=sumReq;i++) dp[0][sumReq]=0;
    	for(int i=0;i<=n;i++) dp[i][0]=1;
    	
    	
    	
    	
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=sumReq;j++){
    			dp[i][j]=dp[i-1][j];
    			if(j>=nums[i-1])
    					dp[i][j]+=dp[i-1][j-nums[i-1]];
    		}
    	}
    	
    	
    	for(int i=0;i<dp.length;i++){
    		for(int j=0;j<dp[0].length;j++){
    			System.out.print(dp[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    	
    	return dp[n][sumReq];
        
    }


}
