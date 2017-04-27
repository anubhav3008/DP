package com.anubhav.leetcode;

public class TargetSum {

	public static void main(String[] args) {
		int ans=new TargetSum().findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1);
		System.out.println(ans);
	}
	

    public int findTargetSumWays(int[] nums, int S) {
		if(S>1000) return 0;
    	int n=nums.length;
    	int totalSum=0;
    	for(int i=0;i<n;i++){
    		totalSum+=nums[i];
    	}
    	if(((totalSum+S)%2)!=0) return 0;
    	
    	int sumReq=(totalSum+S)/2;
    	if(sumReq <0){
    		int scale=-sumReq;
    		for(int i=0;i<n;i++){
    			nums[i]=nums[i]+scale;
    		}
    	}
    	
    	
    	int dp[][]=new int[n+1][sumReq+1];
    	

    	for(int i=0;i<=n;i++) dp[i][0]=1;
    	
    	
    	
    	
    	for(int i=1;i<=n;i++){
    		for(int j=0;j<=sumReq;j++){
    			dp[i][j]=dp[i-1][j];
    			if(j>=nums[i-1])
    					dp[i][j]+=dp[i-1][j-nums[i-1]];
    		}
    	}
    	return dp[n][sumReq];
        
    }


}
