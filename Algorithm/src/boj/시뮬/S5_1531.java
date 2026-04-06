package boj.시뮬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class S5_1531 {
	static int[][] board = new int[100][100];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			sticker(x1,y1,x2,y2);
//			for(int[] arr : board) {
//				for(int a : arr) {
//					System.out.print(a+" ");
//				}
//				System.out.println();
//			}
		}
		
		int result = 0;
		for(int i = 0; i < 100;i++) {
			for(int j = 0;j < 100; j++) {
				if(board[i][j] > M) result++;
			}
		}
		System.out.println(result);
	}
	public static void sticker(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2;i++) {
			for(int j = y1; j <= y2;j++) {
				board[i][j]++;
			}
		}
	}
}
