package boj.시뮬;

import java.io.*;
import java.util.*;

public class G5_21610 {
	static int N, M; // N*N = 격자크기, M = 이동횟수
	static int[][] board; // 격자
	static int[][] movement;
	static final int[] dr = {0, -1,-1,-1, 0, 1, 1, 1};
	static final int[] dc = {-1,-1, 0, 1, 1, 1, 0,-1};
	
	static class Cloud {
		List<int[]> clouds = new ArrayList<>();
		public Cloud(List<int[]> c) {
			this.clouds = c;
		}
		public void move(int dir, int dis) {
			List<int[]> newList = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			q.addAll(clouds);
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int row = cur[0], col = cur[1];
				for(int i = 0; i < dis;i++) {				
					row = row + dr[dir-1];
					col = col + dc[dir-1];
					
					if(row < 0) row = N-1;
					if(row >= N) row = 0;
					if(col < 0) col = N-1;
					if(col >= N) col = 0;
					
					
				}
				newList.add(new int[] {row, col});
			}
			this.clouds = newList;
		}
		public void rain() {
			Queue<int[]> q = new LinkedList<>();
			q.addAll(clouds);
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int row = cur[0], col = cur[1];
				board[row][col]++;
			}
		}
		public void copyBug() {
			Queue<int[]> q = new LinkedList<>();
			q.addAll(clouds);
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int row = cur[0], col = cur[1];
				
				int cnt = 0;
				
				for(int i = 1; i < 8;i++) {
					if(i%2!=0) {
						int nr = row + dr[i];
						int nc = col + dc[i];
						
						if(nr >= N || nc >= N || nr < 0 || nc < 0 || board[nr][nc] < 1) continue;
						
						cnt++;
					}
				}
				board[row][col] += cnt;
			}
		}
		public void createCloud() {
			List<int[]> newClouds = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N;j++) {
					
					if(board[i][j] < 2) continue;
					
					boolean breakpoint = false;
					for(int c = 0; c < clouds.size();c++) {
						if(clouds.get(c)[0] == i &&clouds.get(c)[1] ==j) {
							breakpoint = true;
							break;
						}
					}
					if(breakpoint) continue;
					board[i][j] -= 2;
					newClouds.add(new int[] {i, j});
				}
			}
			this.clouds = newClouds;
		}
		
//		public void printClouds() {
//			StringBuilder sb = new StringBuilder();
//			int i = 1;
//			for(int[] arr : clouds) {
//				sb.append("arr").append(i++).append(" : ");
//				sb.append(Arrays.toString(arr)).append("\n");
//			}
//			System.out.println(sb);
//		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<int[]> li = new ArrayList<>();
		li.add(new int[] {N-1, 0});
		li.add(new int[] {N-1, 1});
		li.add(new int[] {N-2, 0});
		li.add(new int[] {N-2, 1});
		Cloud cloud = new Cloud(li);
		
		for(int i = 0; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			cloud.move(direction, distance);
			cloud.rain();
			cloud.copyBug();
			cloud.createCloud();
		}
		int total = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0;j < N;j++) {
				total+=board[i][j];
			}
		}
		System.out.println(total);
	}
}
