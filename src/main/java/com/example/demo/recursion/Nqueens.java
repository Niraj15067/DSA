package com.example.demo.recursion;

public class Nqueens {

	public static void main(String[] args) {
		int size=8;
		boolean board[][] = new boolean[size][size];
		int count = placeQueens(board,0);
		System.out.println("Total number of ways to place the queen: "+count);
	}

	private static int placeQueens(boolean[][] board, int r) {
		int count = 0;
		if(r==board[0].length) {
			displayBoard(board);
			return 1;
		}
		for(int col=0;col<board.length;col++) {
 			if(isSafe(board,r,col)) {
				board[r][col]=true;
				count+=placeQueens(board, r+1);
				board[r][col]=false;
			}
		}
		return count;
	}

	private static void displayBoard(boolean[][] board) {
		for(boolean[] row: board) {
			for(boolean ele:row) {
				if(ele) {
					System.out.print("Q  ");
				}else {
					System.out.print("X  ");
				}
			}
			System.out.println();
		}	
		System.out.println("-------------------------------------");	
	} 

	private static boolean isSafe(boolean[][] board, int r, int c) {
		//check vertically for above rows inside the same column
		for(int row=0;row<r;row++) {
			if(board[row][c]) {
				return false;
			}
		}
		//check diagonally for left side
		for(int row=r, col=c;row>=0 && col>=0;row--,col--) {
			if(board[row][col]) {
				return false;
			}
		}
		//check for diagonally for the right side.
		for(int row=r,col=c;row>=0 && col<board[0].length;row--,col++) {
			if(board[row][col]) {
				return false;
			}
		}
		return true;
	}

}
