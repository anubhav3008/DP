package com.anubhav.leetcode;
//https://leetcode.com/problems/is-subsequence/#/description
public class IsSubsequence {

	public static void main(String[] args) {
		boolean ans=new IsSubsequence().isSubsequence("acb","ahbgdc");
		System.out.println(ans);

	}


	public boolean isSubsequence(String s, String t) {
		int i=0, j=0;
		if(s.length()>t.length()) return false;
		while(i<s.length() && j < t.length()){
			while(j<t.length() && t.charAt(j)!=s.charAt(i) ){
				j++;
			}
			if(j==t.length() && i!=s.length()) return false;
			i++;
			j++;
		}
		if(i==s.length() && j!=s.length()) return false;
		return true;


	}

}
