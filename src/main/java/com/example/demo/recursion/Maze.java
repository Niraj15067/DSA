package com.example.demo.recursion;

public class Maze {

	public static void main(String[] args) {
		boolean[][] maze = new boolean[4][4];
		findPath(maze, 0, 0, "");
	}

	private static void findPath(boolean[][] maze, int r, int c, String path) {
		if (r == 3 && c == 3) {
			System.out.println(path);
			return;
		}
		if(c<maze[0].length) {
			findPath(maze,r,c+1,path+"R");
		}
		if(r<maze.length) {
			findPath(maze,r+1,c,path+"D");
		}
	}
}
