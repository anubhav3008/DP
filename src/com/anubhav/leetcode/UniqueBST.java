package com.anubhav.leetcode;
//https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBST {

	public static void main(String[] args) {
		int ans=new UniqueBST().numTrees(4);
		System.out.println(ans);

	}
		public int numTrees(int n) {
			if(n<=1) return 1;
			if(n==2) return 2;
			int dp[]=new int[n+1];
			dp[0]=1;
			dp[1]=1;
			dp[2]=2;
			
			for(int i=3;i<=n;i++){
				
				int s=0;
				for(int j=0;j<n;j++){
					if(i-j-1 >=0)
						s+=dp[j]*dp[i-j-1];
					else
						s+=dp[j];
				}
				dp[i]=s;
			}
			return dp[n];
        
    }
	

}
