package com.anubhav.leetcode;
//https://leetcode.com/problems/counting-bits/#/description
public class CountingBits {

	public static void main(String[] args) {
		int x[]=(new Solution().countBits(5));
		for(int i : x){
			System.out.print(i);
		}

	}

}
class Solution {
    public int[] countBits(int num) {
        int ans[]=new int[num+1];
        for(int i=0;i<=num;i++){
        	if(i==0) ans[i]=0;
        	else if(i==1) ans[i]=1;
        	else{
        		
        		int lastPowOfTwo=(int) Math.floor(Math.log(i)/Math.log(2));
        		int lastPowOfTwoVal=(int) Math.pow(2, lastPowOfTwo);
        		if(i==lastPowOfTwoVal) ans[i]=1;
        		else{
        			ans[i]=ans[lastPowOfTwoVal]+ans[i-lastPowOfTwoVal];
        		}
        	}
        	
        }
        
        return ans;
    }
}