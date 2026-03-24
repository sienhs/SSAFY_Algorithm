package boj.완전탐색;
import java.io.*;
import java.util.*;


public class G1_12100 {
	static int[][] board;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		
		dfs(0, board);
		
		System.out.println(max);
//		for(int[] i : board) {
//			System.out.println(Arrays.toString(i));
//		}
	}
	public static int max;
	public static void dfs(int depth, int[][] curBoard) {
		if(depth == 5) {
			for(int i =0;i < N; i ++) {
				for(int j = 0; j < N;j++) {
					if(curBoard[i][j] > max) max = curBoard[i][j];
				}
			}
			
			return;
		}
		for(int i = 0; i < 4;i++) {
			int[][] cloneBoard = new int[N][N];
			for(int r = 0; r < N; r++) {
				cloneBoard[r] = curBoard[r].clone();
			}
			if(i!=0) {
				cloneBoard = rotate(cloneBoard, 90*i);
			}
			cloneBoard = pushNsum(cloneBoard);
			
			dfs(depth+1, cloneBoard);
			
//			if(i!=0) {
//				cloneBoard = rotate(cloneBoard, 90*(4-i));
//			}
		}
	}
	public static int[][] pushNsum(int[][] arr){
		for(int i = 0; i < N;i++) {
			int target = 0;
			boolean isMerged = false;
			for(int j = 1; j < N; j++) {
				if(arr[j][i] == 0) continue;
				
				if(arr[target][i]==arr[j][i] && !isMerged) {
					arr[target][i] *= 2;
					arr[j][i] = 0;
					isMerged = true;
					target ++;
					
					
				}
				else if(arr[target][i] == 0) {
					arr[target][i] = arr[j][i];
					arr[j][i] = 0;
					isMerged = false;
				}
				else {
					target++;
					if(target != j) {
						arr[target][i] = arr[j][i];
						arr[j][i] = 0;
					}
					isMerged = false;
				}
			}
		}
		return arr;
	}
	public static int[][] rotate(int[][] arr, int degree){
		if(degree == 0) return arr;
		
		int[][] rotate = new int[N][N];
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            switch (degree) {
	                case 90:
	                    rotate[i][j] = arr[N-1-j][i];
	                    break;
	                case 180:
	                    rotate[i][j] = arr[N-1-i][N-1-j];
	                    break;
	                case 270:
	                    rotate[i][j] = arr[j][N-1-i];
	                    break;
	            }
	        }
	    }
		return rotate;
	}
}
