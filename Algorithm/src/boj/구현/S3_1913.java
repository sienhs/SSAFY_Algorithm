package boj.구현;

import java.util.*;
import java.io.*;

public class S3_1913 {
	public static int N;
	public static int[][] board;
	public static int[] targetLocation;
	public static int target;
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		int x = 0, y = 0;
		int t = 0;
		for(int i = (N*N); i > 0;i--) {
			board[x][y] = i;
			
			if(i == target) targetLocation = new int[]{x+1, y+1};
			
			int nx = x + dx[t];
			int ny = y + dy[t];
			
			if(nx >= N || ny >= N || nx < 0 || ny < 0 || board[nx][ny] != 0) {
				t = (t + 1)%4;
				
				nx = x + dx[t];
				ny = y + dy[t];
			}
			x = nx;
			y = ny;
			
		}
			 
			
		
		StringBuilder sb = new StringBuilder();
		for(int[] arr : board) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			
		}
		System.out.print(sb);
		System.out.println(targetLocation[0] +" " + targetLocation[1]);
		
	}
}
