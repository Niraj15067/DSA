package com.example.demo.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char[][] board = new char[3][3];
		// initialize with blank
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				board[r][c] = ' ';
			}
		}
		char player = 'X';
		boolean gameOver = false;
		Scanner sc = new Scanner(System.in);
		while(!gameOver) {
			display(board);
			System.out.println("Player "+ player+" enter: ");
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(board[row][col]==' ') {
				board[row][col]= player;//after placing check if player has won.
				gameOver = hasWon(board,player);
				if(gameOver) {
					System.out.println("Player "+ player+" has won!");
					break;
				}else {
					//he didn't win so change the player for their turn.
					player = (player=='X')?'O':'X';
				}
			}else {
				System.out.println("Invalid move! please try again.");
			}
		}
		display(board);
		sc.close();
	}

	private static boolean hasWon(char[][] board, char player) {
		
		//check horizontally
		for(int row = 0; row<board.length; row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		
		//check vertically
		for(int col = 0; col<board[0].length;col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		//check both diagonals
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		if(board[2][0]==player && board[1][1]==player && board[0][2]==player) {
			return true;
		}
		return false;
	}

	private static void display(char[][] board) {
		for(int r = 0;r<board.length;r++) {
			System.out.println("------------");
			for(int c = 0; c<board[0].length;c++) {
				System.out.print(board[r][c]+" | ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
}
