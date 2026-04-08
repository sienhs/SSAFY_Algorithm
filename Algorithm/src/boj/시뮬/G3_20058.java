package boj.시뮬;

import java.util.*;
import java.io.*;


public class G3_20058 {
	static int N, Q;
	static int[][] board;
	static int[][] newBoard;
	static boolean[][] visited;
	static int P;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		P = (int)Math.pow(2, N);
		
		board = new int[P][P];
		visited = new boolean[P][P];
		
		for(int i = 0; i < P;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < P;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> L = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q;i++) {
			int l = Integer.parseInt(st.nextToken());
			L.offer(l);
		}
		
		while(!L.isEmpty()) {
			int l = L.poll();
			if(l!=0) {
				newBoard = new int[P][P];
				int LP = (int)Math.pow(2, l); // LP = dvivied grid Size
				for(int row = 0; row < P;row+=LP) {
					for(int col = 0; col < P;col+=LP) {
						
						for(int i = 0;i < LP;i++) {
							for(int j = 0;j < LP;j++) {
								newBoard[row + j][col + LP - i - 1] = board[row + i][col + j];
							}
						}
						
					}
				}
				board = newBoard;
			}
			
			List<int[]> ices = new ArrayList<>();
			
			for(int i = 0; i < P;i++) {
				for(int j = 0; j < P;j++) {
					if(board[i][j] == 0) continue;
					
					int ice = 0;
					for(int t = 0; t < 4; t++) {
						int nx = i + dx[t];
						int ny = j + dy[t];
						
						if(nx >= P|| ny >= P || nx < 0 || ny < 0) continue;
						if(board[nx][ny]==0) continue;
						
						ice++;
					}
					if(ice < 3) ices.add(new int[] {i, j});
				}
			}
			
			for(int[] ice : ices) board[ice[0]][ice[1]]--;
		}
		
		int total = 0;
		for(int[] arr : board) {
			total += Arrays.stream(arr).sum();
		}
		System.out.println(total);
		
		for(int i = 0; i < P; i++) {
			for(int j = 0; j < P;j++) {
				if(board[i][j]==0) continue;
				if(visited[i][j]) continue;
				
				bfs(new int[] {i, j});
			}
		}
		
		System.out.println(maxWidth);
	}

	static int maxWidth = 0;
	public static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		int width = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];
			
			for(int t = 0; t < 4;t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= P|| ny >= P || nx < 0 || ny < 0) continue;
				if(board[nx][ny]==0) continue;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				width++;
				
				q.offer(new int[] {nx, ny});
			}
		}
		if(width > maxWidth) {
			maxWidth = width;
		}
	}
}

