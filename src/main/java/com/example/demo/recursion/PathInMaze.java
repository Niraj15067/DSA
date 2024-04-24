package com.example.demo.recursion;

public class PathInMaze {

	public static void main(String[] args) {
		boolean maze[][] = new boolean[4][4];
		int[][] path = new int[maze.length][maze.length];
		findPath(maze,0,0,"",1,path);
	}

	private static void findPath(boolean[][] maze, int r, int c, String p,int count, int[][] path) {
		if(r==maze.length-1 && c==maze.length-1) {
			for(int[] row:path) {
				path[r][c]=count;
				for(int col:row) {
					System.out.print(col+" ");
				}
				System.out.println();
			}
			System.out.println(p);
			return;
		}
		if(maze[r][c]) {
			return;
		}
		if(r<maze.length-1) {
			maze[r][c]=true;
			path[r][c]=count;
			findPath(maze, r+1, c, p+"D", count+1,path);
		}
		if(c<maze.length-1) {
			maze[r][c]=true;
			path[r][c]=count;
			findPath(maze, r, c+1, p+"R", count+1,path);
		}
		path[r][c]=0;
		maze[r][c]=false;
	}

}
