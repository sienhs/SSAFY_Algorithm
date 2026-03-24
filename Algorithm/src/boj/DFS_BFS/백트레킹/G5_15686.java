package boj.DFS_BFS.백트레킹;
import java.util.*;
import java.io.*;

public class G5_15686 {
	public static int N, M;
	public static int [][] grid;
	
	public static List<Integer> ckDistance = new ArrayList<>();
	public static int getDistance(int[] currentLocation, int[] targetLocation) {
		return Math.abs(currentLocation[0]-targetLocation[0]) + Math.abs(currentLocation[1]-targetLocation[1]);
	}
	public static List<int[]> houses = new ArrayList<>();
	public static List<int[]> chickens = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][N];
//		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N;j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 1) houses.add(new int[] {i, j});
				else if(grid[i][j] == 2) chickens.add(new int[] {i,j});
			}
		}
//		for(int[] test : grid) {
//			System.out.println(Arrays.toString(test));
//		}
//		System.out.println("============================");
//		System.out.println("houses = ");
//		for(int[] cktest : houses) {
//			System.out.println(Arrays.toString(cktest));
//		}
		//////////////////////////////////////////////////
		
//		System.out.println(ckDistance);
		
		selected = new int[M];
		dfs(0, 0);
		System.out.println(result);
	}	
	public static int[] selected;
	public static int result = Integer.MAX_VALUE;
	public static void dfs(int depth, int idx) {
		if(depth == M) {
			int total = 0;
			for(int j = 0; j < houses.size();j++) {
				int minHouse = Integer.MAX_VALUE;
				for(int l = 0; l < M;l++) {
					minHouse = Math.min(minHouse, getDistance(houses.get(j), chickens.get(selected[l])));
				}
				total+=minHouse;
			}
			result = Math.min(result, total);
			return;
		}
		
		for(int i = idx; i < chickens.size();i++) {
			selected[depth] = i;
			dfs(depth+1, i+1);
		}
	}
}		 
		
//		Collections.sort(ckDistance);
//		System.out.println(ckDistance);
//		int endCount = 0;
//		int result = 0;
//		for(int i = 0; i < ckDistance.size();i++) {
//			if(endCount >= M) break;
//			if(ckDistance.get(i) == 0) continue;
//			result+=ckDistance.get(i);
//			endCount++;
//		}
//		System.out.println(result);
		
		
		
		
	
	
//	public static boolean[][] visited;
//	public static int[] dx = {0,0,1,-1,-1,1,1,-1};
//	public static int[] dy = {1,-1,0,0,1,-1,1,-1};
//	public static void bfs() {
//		
//		while(!houses.isEmpty()) {
//			Queue<int[]> q = new LinkedList<>();
//			int[] curCalc = houses.poll();
//			visited = new boolean[N][N];
//			q.offer(curCalc);
//			boolean isBreak = false;
//			while(!q.isEmpty()) {
//				if(isBreak) break;
//				
//				int[] inWhileCurCalc = q.poll();
//				
//				int x = inWhileCurCalc[0];
//				int y = inWhileCurCalc[1];
//				
//				visited[x][y] = true;
//				
//				for(int t = 0; t < 8; t++) {
//					int nx = x + dx[t];
//					int ny = y + dy[t];
//					
//					if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
//					if(visited[nx][ny]) continue;
//					
//					if(grid[nx][ny] == 2) {
//						// 이 부분에서 치킨집 마다 거리를 더해줘야함 지금 그냥 냅다 거리만 모아뒀음.
//						ckDistance.add(getDistance(curCalc, new int[] {nx, ny}));
//						isBreak = true;
//						break;
//					}
//					
//					q.offer(new int[] {nx, ny});
//				}
//			}
//		
//		}
//	}

