package com.example.demo.recursion;

public class NKnights {

	public static void main(String[] args) {
		
		int size = 4;
		boolean board[][] = new boolean[size][size];
		placeNKnights(board, 0, 0, 4);
	}

	private static void placeNKnights(boolean[][] board, int r,int c, int knights) {
		if(knights==0) {
			displayBoard(board);
			System.out.println();
			return;
		}
		if(r==board.length-1 && c==board.length) {
			return;
		}
		if(c==board.length) {
			placeNKnights(board, r+1, 0, knights);
			return;
		}
		if(isSafe(board, r, c)) {
			board[r][c]=true;
			placeNKnights(board, r, c+1, knights-1);
			board[r][c]=false;
		}
		placeNKnights(board, r, c+1, knights);
		return;
	}
	
	private static void displayBoard(boolean[][] board) {
		for(boolean[] row: board) {
			for(boolean ele:row) {
				if(ele) {
					System.out.print("K  ");
				}else {
					System.out.print("X  ");
				}
			}
			System.out.println();
		}	
		System.out.println("-------------------------------------");	
	} 
	
	private static boolean isSafe(boolean[][] board, int r, int c) {
		//check  for above left.
		if(isValid(board,r-2,c-1)) {
			if(board[r-2][c-1]) {
				return false;
			}
		}
		if(isValid(board,r-2,c+1)) {
			if(board[r-2][c+1]) {
				return false;
			}
		}
		if(isValid(board,r-1,c-2)) {
			if(board[r-1][c-2]) {
				return false;
			}
		}
		if(isValid(board,r-1,c+2)) {
			if(board[r-1][c+2]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValid(boolean[][] board, int r, int c) {
		if(r>=0 && r<board.length && c>=0 && c<board.length) {
			return true;
		}
		return false;
	}


}
