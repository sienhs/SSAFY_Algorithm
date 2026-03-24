package boj.DFS_BFS;

import java.io.*;
import java.util.*;
    
public class G4_14502 {
	public static int N, M;
	public static int grid[][];
	public static Queue<int[]> virus;
	public static List<int[]> walls;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		virus = new LinkedList<>();
		walls = new ArrayList<>();
		for(int i =0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 2) virus.offer(new int[] {i ,j});
				else if(grid[i][j] == 1) walls.add(new int[] {i, j}); 
			}
		}
		
		wall(0, 0, 0);
		System.out.println(result);
	}
	public static int result = 0;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void bfsVirus() {
		Queue<int[]> inBfsVirus = new LinkedList<>();
		for(int[] v : virus) inBfsVirus.offer(v);
		boolean[][] visited = new boolean[N][M];
		while(!inBfsVirus.isEmpty()) {
			 int[] q = inBfsVirus.poll();
			 int vx = q[0];
			 int vy = q[1];
			 visited[vx][vy] = true;
			 
			 for(int trace = 0; trace < 4; trace++) {
				 int nx = vx + dx[trace];
				 int ny = vy + dy[trace];
				 
				 if(nx >= N || ny >= M || nx < 0|| ny <0) continue;
				 if(grid[nx][ny] != 0 || visited[nx][ny]) continue;
				 
				 inBfsVirus.offer(new int[] {nx, ny});
			 }
		}
		int vCnt = 0;
		for(boolean[] visit : visited) {
			for(boolean vis : visit) {
				if(vis) vCnt++;
			}
		}
		
		int cnt = (N*M) - (vCnt + walls.size() + 3);
		result = Math.max(result, cnt);
	}
	public static void wall(int cnt, int startI, int startJ) {
		if (cnt == 3) {
			bfsVirus();
			return;
		}
		for(int i= startI; i < N; i++) {
			int jStart = (i==startI) ? startJ : 0;
			for(int j = jStart;j < M;j++) {
				if(grid[i][j] == 0) {
					grid[i][j] = 1;
					if(j+1<M) wall(cnt+1, i, j + 1);
					else wall(cnt+1, i + 1, 0);
					grid[i][j] = 0;
				}
			}
		}
	}
}
