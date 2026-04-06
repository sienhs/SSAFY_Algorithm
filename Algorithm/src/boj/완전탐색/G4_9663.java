package boj.완전탐색;

import java.util.*;
import java.io.*;

public class G4_9663 {
	static int N;
	static int[] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N];
		
		dfs(0);
		
		System.out.println(count);
	}
	
	static int count = 0;
	public static boolean isValid(int row, int col) {
		for(int i = 0; i < row; i++) {
			if(board[i]==col) return false;
			if(Math.abs(row - i) == Math.abs(col - board[i])) {
				return false;
			}
		}
		return true;
	}
	public static void dfs(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isValid(depth, i)) { // depth==row, i==col
				board[depth] = i;
				dfs(depth+1);
				
			}
		}
		
	}
}
