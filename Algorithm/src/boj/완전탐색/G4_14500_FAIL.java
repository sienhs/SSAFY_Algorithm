package boj.완전탐색;

import java.io.*;
import java.util.*;


// index = (r-1)*W + (c-1)	row = (index/W) + 1

public class G4_14500_FAIL {
	static int[][] board;
	static int N, M;
	// 일자 제외 모든 도형
	static int[][] shapes = {

		    // ㅁ (O)
		    {0,1,4,5}, {1,2,5,6}, {2,3,6,7},
		    {4,5,8,9}, {5,6,9,10}, {6,7,10,11},
		    {8,9,12,13}, {9,10,13,14}, {10,11,14,15},

		    // T
		    {1,4,5,6}, {2,5,6,7},
		    {5,8,9,10}, {6,9,10,11},
		    {4,5,6,9}, {5,6,7,10},
		    {1,5,9,6}, {2,6,10,7},
		    {5,9,13,10}, {6,10,14,11},

		    // S / Z
		    {1,2,4,5}, {2,3,5,6},
		    {5,6,8,9}, {6,7,9,10},
		    {9,10,12,13}, {10,11,13,14},

		    {0,1,5,6}, {1,2,6,7},
		    {4,5,9,10}, {5,6,10,11},
		    {8,9,13,14}, {9,10,14,15},

		    // L / J
		    {0,4,8,9}, {1,5,9,10}, {2,6,10,11}, {3,7,11,12},
		    {4,8,12,13}, {5,9,13,14}, {6,10,14,15},

		    {1,2,3,7}, {0,1,2,6},
		    {4,5,6,10}, {5,6,7,11},
		    {8,9,10,14}, {9,10,11,15},

		    {3,6,9,10}, {2,5,8,9},
		    {6,9,12,13}, {7,10,13,14},

		    {0,1,5,9}, {1,2,6,10}, {2,3,7,11},
		    {4,5,9,13}, {5,6,10,14}, {6,7,11,15}
		};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int [N][M];
		
		int cnt =0;
		for(int i = 0; i< N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <= N-4;i++) {
			for(int j = 0; j <= M-4;j++) {
				
				Queue<Integer> q = new LinkedList<>();
				
				for(int x = i; x < i+4;x++) {
					for(int y = j; y < j+4;y++) {
						q.offer(board[x][y]);
						
					}
				}
				
				
				int[][] slicedBoard = new int[4][4];
				for(int i2 = 0; i2 < 4; i2++) {
					for(int j2 = 0; j2 < 4; j2++) {
						slicedBoard[i2][j2] = q.poll();
					}
				}
				findMaxShape(slicedBoard);
				
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= M-4;j++) {
				
				int total = 0;
				for(int x = j; x < j+4;x++) {
					total+=board[i][x];
				}
				max = Math.max(max, total);
			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j <= N-4;j++) {
				
				int total = 0;
				for(int x = j; x < j+4;x++) {
					total+=board[x][i];
				}
				max = Math.max(max, total);
			}
		}
		System.out.println(max);
		
	}
	public static int max = 0;
	
	public static void findMaxShape(int [][] sb) {
		for(int [] shape : shapes) {
			
			int total = 0;
			for(int idx : shape) {
				int row = idx/4;
				int col = idx%4;
				
				total += sb[row][col];
				
				
			}
			
			max = Math.max(max, total);
			
			
		}
	}

}
