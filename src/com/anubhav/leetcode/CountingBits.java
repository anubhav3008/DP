package com.anubhav.leetcode;
//https://leetcode.com/problems/counting-bits/#/description
public class CountingBits {

	public static void main(String[] args) {
		int x[]=(new Solution().countBits(1));
		for(int i : x){
			System.out.print(i+ " ");
		}

	}

}
class Solution {
    public int[] countBits(int num) {
        int ans[]=new int[num+1];
        ans[0]=0;
        int i=1;
        while(i<num+1){
        	ans[i]=1;
        	i=i*2;
        }
        int valTilNow=2;
        for(i=3;i<num+1;i++){
        	if(ans[i]!=1){
        		ans[i]=valTilNow;
        	}
        	else
        		valTilNow=i;
        }
        
        for(i=3;i<num+1;i++){
        	if(ans[i]!=1){
        		ans[i]=1+ans[i-ans[i]];
        	}
        }
        return ans;
    }
}

/*0 = >0
 * 1 => 1
 * 01= > 1
 * 10 = > 1
 * 11 => 2
 * 100=> 1
 * 101=> 2
 * 110 =>2
 * 111=>3
 * 1000=>1
 * 1001=>2
 * 1010=>2
 * 1011=>3
 * 1100=>2
 * 
 * 
 * 		0,1,2,3,4,5,6,7,8,9,10,11,12,13,14
 * i = {0,1,1,2,1,4,4,4,1,8, 8, 8 ,8, 8,8 
 */



