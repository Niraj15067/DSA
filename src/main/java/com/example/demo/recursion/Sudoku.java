package com.example.demo.recursion;

public class Sudoku {

	public static void main(String[] args) {
		
		int[][] board = {
	            {5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };
		solve(board);
	}

	private static boolean solve(int[][] board) {
		
		int r=-1,c=-1;
		boolean isEmpty=true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]==0) {
					r=i;
					c=j;
					isEmpty=false;
					break;
				}
			}
			if(!isEmpty) {
				break;
			}
		}
		if(isEmpty) {
			return true;
		}
		
		for(int val=1;val<=9;val++) {
			if(isSafe(board, r, c, val)) {
				board[r][c]=val;
				if(solve(board)) {
					display(board);
					return true;
				}else {
					board[r][c]=0;	
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int r, int c, int val) {
		//checking horizontally in the same row
		
		for(int i=0;i<board[0].length;i++) {
			if(board[r][i]==val) {
				return false;
			}
		}
		//check vertically in the same column
		for(int i=0;i<board.length;i++) {
			if(board[i][c]==val) {
				return false;
			}
		}
		//check inside the 3 by 3 sub block
		int startR = 3*(r/3), startC = 3*(c/3);
		int endR = startR+2,endC=startC+2;
		
		for(int i=startR;i<=endR;i++) {
			for(int j=startC;j<=endC;j++) {
				if(board[i][j]==val) {
					return false;
				}
			}
		}
		return true;
	}

	private static void display(int[][] board) {
	    for (int[] row : board) {
	        for (int ele : row) {
	            if (ele == 0) {
	                System.out.print(".  "); // or any other character to represent an empty cell
	            } else {
	                System.out.print(ele + "  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println();
	}

}
