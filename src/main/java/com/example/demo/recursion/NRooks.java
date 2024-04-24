package com.example.demo.recursion;

public class NRooks {

	public static void main(String[] args) {

		int size = 4;
		boolean[][] board = new boolean[size][size];
		int ans = placeRook(board, 0);
		System.out.println(ans);
	}

	private static int placeRook(boolean[][] board, int r) {
		int count = 0;
		if(r==board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		
		for(int col=0;col<board[0].length;col++) {
			if(isSafe(board, r, col)) {
				board[r][col]=true;
				count+=placeRook(board, r+1);
				board[r][col]=false;
			}
		}
		
		return count;
	}

//	private static int placeRook(boolean[][] board, int r, int c, int rooks) {
//		int count = 0;
//		
//		if(rooks==0) {
//			display(board);
//			System.out.println();
//			return 1;
//		}
//		if(r==board.length) {
//			return 0;
//		}
//		if(c==board[0].length) {
//			placeRook(board, r+1, 0,rooks);
//			return 0;
//		}
//		if(isSafe(board,r,c)) {
//			board[r][c]=true;
//			count+=placeRook(board, r+1, 0,rooks-1);
//			board[r][c]=false;
//		}
//		count+=placeRook(board, r, c+1, rooks);
//		return count;
//		
//	}

	private static boolean isSafe(boolean[][] board, int r, int c) {

		// vertically above check
		for (int row = 0; row < r; row++) {
			if (board[row][c]) {
				return false;
			}
		}
		// check in the same row for earlier columns.
		for (int col = 0; col < c; col++) {
			if (board[r][col]) {
				return false;
			}
		}
		return true;
	}

	private static void display(boolean[][] board) {
		for (boolean[] row : board) {
			for (boolean ele : row) {
				if (ele) {
					System.out.print("R  ");
				} else {
					System.out.print("X  ");
				}
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}

}
