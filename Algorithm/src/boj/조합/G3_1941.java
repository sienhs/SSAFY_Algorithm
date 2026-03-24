package boj.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1941 {
	public static int[][] map = new int[5][5];
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5;i++) {
			String s = br.readLine();
			for(int j = 0; j < 5;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		combine(0,0);
		System.out.println(result);
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static boolean isFamousSeven(int seven, boolean[][] isS) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[25];
		visited[seven] = true;
		q.offer(seven);
		int depth = 1;
		while(!q.isEmpty()) {
			int temp = q.poll();
			int x = temp/5;
			int y = temp%5;
			
			
			
			for(int t = 0; t < 4; t ++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= 5 || ny >= 5 || nx < 0 || ny < 0) continue;
				if(isS[nx][ny] && !visited[nx*5+ny]) {
					visited[nx*5+ny] = true;
					q.offer(nx*5+ny);
					depth++;
				}
				
				
				
			}
			
		}
		if(depth == 7) return true;
		else return false;
	}
	public static int[] seven = new int[7];
	public static void combine(int cnt, int start) {
		if(cnt == 7) {
			// 구현
			int pCnt = 0;
			boolean[][] isSelected = new boolean[5][5];
			for(int s : seven) {
				isSelected[s/5][s%5] = true;
				if(map[s/5][s%5] == 'S') pCnt++;
			}
			if(pCnt >= 4) {
				if(isFamousSeven(seven[0], isSelected)) {
					result ++;
				}
			}
			return;
		}
		for(int i = start; i < 25; i ++) {
			seven[cnt] = i;
			combine(cnt+1, i+1);
		}
	}
}
