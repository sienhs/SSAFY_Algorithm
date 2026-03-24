package swea;

import java.util.*;
import java.io.*;
public class D4_1868 {
	
	public static int N;
	public static char[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
		
			N = Integer.parseInt(br.readLine());
			
			board = new char[N][N];
			visited = new boolean[N][N];
			q = new LinkedList<>(); 
			works = new LinkedList<>();
			tnts = new int[N][N];
			for(int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
				board[i] = br.readLine().toCharArray();
			}
			int zerotntblock = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N;j ++) {
					if(board[i][j] == '.') {
						zerotntblock++;
						int tntCnt = 0;
						for(int l = 0; l < 8; l++) {
							int nx = i + dx[l];
							int ny = j + dy[l];
							
							if(nx >= N || ny >= N || nx < 0 || ny < 0 ) continue;
							
							if(board[nx][ny] == '*') {
								tntCnt++;
								
							}
						}
						tnts[i][j] = tntCnt;
						if(tntCnt == 0){
							q.offer(new int[] {i, j});
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			if(q.isEmpty()) {
				System.out.println("0");
				System.out.println(zerotntblock);
			}else {
				bfs();
			}
			// 입력 끝
			
			
		}
		
	}
	public static boolean[][] visited;
	public static int[][] tnts;
	public static Queue<int[]> q; // 지뢰가 없는 칸들을 순차적으로 저장할 큐
	public static Queue<int[]> works;
	public static int[] dx = new int [] {0,0,1,-1,1,1,-1,-1};
	public static int[] dy = new int [] {1,-1,0,0,-1,1,-1,1};

	public static void bfs() {
		int result = 0;
		for(int[] node : q) {
			if(!visited[node[0]][node[1]]) {
				works.offer(node); // 일단 1클릭째 시작
				result++;
				visited[node[0]][node[1]] = true;
				
				
				
				while(!works.isEmpty()) {
					int[] n = works.poll();
					int x = n[0], y = n[1];
					
					if(tnts[x][y] == 0) {
						for(int i = 0; i < 8; i++) {
							int nx = x + dx[i];
							int ny = y + dy[i];
							
							if(nx >= N || ny >= N || nx < 0 || ny < 0 ) continue;
							
							if(board[nx][ny] == '*') {
								continue;
							}
							if(visited[nx][ny]) continue;
							
							
							visited[nx][ny] = true;
							
							works.offer(new int [] {nx, ny});
							
							
						}
					}

					
				}
			}
		}
		for(int i = 0;i < N; i ++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == '.' && !visited[i][j]) result++;
			}
		}
		System.out.println(result);
	}
}
