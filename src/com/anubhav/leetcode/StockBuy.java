package com.anubhav.leetcode;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class StockBuy {

	public static void main(String[] args) {
		int as=new StockBuy().maxProfit(new int [] {6,7});
		System.out.println(as);
	}
	
	public int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
        int mins[]=new int[prices.length];
        int maxs[]=new int[prices.length];
        
        int minima=Integer.MAX_VALUE;
        int maxima=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
        	if(minima > prices[i]){
        		minima=prices[i];
        	}
        	mins[i]=minima;
        }
        for(int i=prices.length-1;i>=0;i--){
        	if(prices[i]>maxima)
        		maxima=prices[i];
        	maxs[i]=maxima;
        }
        maxima=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
        	maxima=Math.max(maxima, maxs[i]-mins[i]);
        }
        return maxima;
    }

}
