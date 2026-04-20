package SAMSUNG_A;

import java.util.*;
import java.io.*;

public class A_헌터 {
	static int T, N;
	static int[][] board;
	static List<int[]> M;
	static List<int[]> C;
	static int[][][] mDist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1;tc++) {
			
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			M = new ArrayList<>();
			C = new ArrayList<>();
			
			for(int i = 0; i < N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for(int j = 0; j < N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] > 0) M.add(new int[] {board[i][j], i, j});
					if(board[i][j] < 0) C.add(new int[] {-board[i][j], i, j});
				}
			}
			
			M.sort((a, b)-> a[0] - b[0]);
			C.sort((a, b)-> a[0] - b[0]);
			
			mDist = new int[M.size()+1][N][N];
			mDist[0] = bfs(0, 0);
			for(int i = 1; i < M.size()+1;i++) {
				int[] cur = M.get(i);
				cur[]
			}
			
			
		}
		
	}
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static int[][] bfs(int sx, int sy) {
		int[][] dist = new int[N][N];
		for(int i = 0; i < N; i ++) Arrays.fill(dist[i], -1);
		dist[sx][sy] = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0], y = n[1];
			
			for(int t = 0; t < 4; t ++) {
				int nx = x + dx[t], ny = y + dy[t];
				
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				if(dist[nx][ny] != -1) continue;
				
				dist[nx][ny] = dist[x][y] + 1;
				q.offer(new int[] {nx, ny});
			}
			
		}
		
		return dist;
	}
}
