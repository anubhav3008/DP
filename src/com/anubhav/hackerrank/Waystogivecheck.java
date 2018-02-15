package com.anubhav.hackerrank;
import java.util.Scanner;

public class Waystogivecheck {


	static int waysToGiveACheck(char[][] board) {
		int n=8;   
		int whitePawnRow=Integer.MAX_VALUE,whitePawncolumn=0;
		int blackKingRow=0,blackKingColumn=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]=='P' && i==1) {
					whitePawnRow=i-1; whitePawncolumn=j;
				}
				if(board[i][j]=='k') {
					blackKingRow=i;blackKingColumn=j;
				}
			}
		}
		boolean knight=promoteKnight(whitePawnRow, whitePawncolumn, blackKingRow, blackKingColumn, board);
		if(knight) return 1;
		boolean rook= promoteRook(whitePawnRow, whitePawncolumn, blackKingRow, blackKingColumn, board);
		if(rook) return 2;
		boolean bishop=promoteBishop(whitePawnRow, whitePawncolumn, blackKingRow, blackKingColumn, board);
		if(bishop) return 2;
		return 0;
	}
	private static boolean promoteKnight(int whitePawnRow, int whitePawncolumn, int blackKingRow, int blackKingColumn, char[][]board ) {
		if( (blackKingRow==1 && blackKingColumn==whitePawncolumn-2) || (blackKingRow==1 && blackKingColumn==whitePawncolumn+2)  
				|| (blackKingRow==2 && blackKingColumn==whitePawncolumn-1) || (blackKingRow==2 && blackKingColumn==whitePawncolumn+1)
				)
			return true;
		return false;


	}
	private static boolean promoteRook(int whitePawnRow, int whitePawncolumn, int blackKingRow, int blackKingColumn, char[][]board ) {
		int row=1;
		for(int i=whitePawncolumn+1;i<8;i++) {
			if(board[row][i]!='#' && board[row][i]!='k')
				break;
			if(board[row][i]=='k')
				return true;
			row++;
		}
		row=1;
		for(int i=whitePawncolumn-1;i>=0;i--) {
			if(board[row][i]!='#' && board[row][i]!='k')
				break;
			if(board[row][i]=='k')
				return true;
			row++;
		}
		return false;


	}
	private static boolean promoteBishop(int whitePawnRow, int whitePawncolumn, int blackKingRow, int blackKingColumn, char[][]board ) {
		for(int i=2;i<8;i++) {
			if(board[i][whitePawncolumn]!='#' && board[i][whitePawncolumn]!='k')
				break;
			if(board[i][whitePawncolumn]=='k')
				return true;
		}
		for(int i=whitePawncolumn+1;i<8;i++) {
			if(board[0][i]!='#' && board[0][i]!='k')
				break;
			if(board[0][i]=='k')
				return true;
		}
		for(int i=whitePawncolumn-1;i>=0;i--) {
			if(board[0][i]!='#' && board[0][i]!='k')
				break;
			if(board[0][i]=='k')
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			char[][] board = new char[8][8];
			for(int board_i = 0; board_i < 8; board_i++){
				String next=in.next();
				for(int board_j = 0; board_j < 8; board_j++){
					
					board[board_i][board_j] = next.charAt(board_j);
				}
			}
			int result = waysToGiveACheck(board);
			System.out.println(result);
		}
		in.close();
	}

}
