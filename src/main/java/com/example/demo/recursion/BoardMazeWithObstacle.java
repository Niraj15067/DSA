package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardMazeWithObstacle {

	public static void main(String[] args) {

		boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true } };
//		List<String> ans = generatePath(0, 0, board, "");
//		List<String> ans = generatePathAllDirections(0, 0, board, "");
		int[][] paths = new int[3][3];
		generatePathAllDirections2(0, 0, board,paths,1);
	}

	private static List<String> generatePath(int r, int c, boolean[][] board, String path) {

		List<String> ans = new ArrayList<>();

		if (r == board.length-1 && c == board[0].length-1) {
			ans.add(path);
		}
		
		if(!(board[r][c])) {
			return new ArrayList<>();
		}
		
		if (r < board.length-1) {
			ans.addAll(generatePath(r + 1, c, board, path + "D"));
		}
		if (c < board[0].length-1) {
			ans.addAll(generatePath(r, c + 1, board, path + "R"));
		}
		return ans;
	}
	
	private static List<String> generatePathAllDirections(int r, int c, boolean[][] board, String path) {

		List<String> ans = new ArrayList<>();

		if (r == board.length-1 && c == board[0].length-1) {
			ans.add(path);
			return ans;
		}
		
		if(!(board[r][c])) {
			return new ArrayList<>();
		}
 		board[r][c]=false;
		
		if (r < board.length-1) {
			ans.addAll(generatePathAllDirections(r + 1, c, board, path + "D"));
		}
		if (c < board[0].length-1) {
			ans.addAll(generatePathAllDirections(r, c + 1, board, path + "R"));
		}
		if (r > 0) {
			ans.addAll(generatePathAllDirections(r-1, c , board, path + "U"));
		}
		if (c > 0) {
			ans.addAll(generatePathAllDirections(r, c - 1, board, path + "L"));
		}
		board[r][c]=true;
		return ans;
	}
	
	private static  void generatePathAllDirections2(int r, int c, boolean[][] board, int[][] path,int level) {

		List<String> ans = new ArrayList<>();

		if (r == board.length-1 && c == board[0].length-1) {
			path[r][c]=level;
			for(int[] arr:path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
			return;
		}
		
		if(!(board[r][c])) {
			return;
		}
 		board[r][c]=false;
		path[r][c]=level;
		if (r < board.length-1) {
			generatePathAllDirections2(r + 1, c, board,path,level+1);
		}
		if (c < board[0].length-1) {
			generatePathAllDirections2(r, c + 1, board,path,level+1);
		}
		if (r > 0) {
			generatePathAllDirections2(r-1, c , board,path,level+1);
		}
		if (c > 0) {
			generatePathAllDirections2(r, c - 1, board, path,level+1);
		}
		board[r][c]=true;
		path[r][c]=0;
		return;
	}

}
