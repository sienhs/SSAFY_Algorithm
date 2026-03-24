package boj._FAILED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class G4_5427_FAIL {
	public static char [][] building;
	public static boolean [][] visited;
	public static List<List<Integer>> firePoint = new ArrayList<>();
	public static int startX = 0, startY = 0;
	public static int h, w;
	
	public static int[] dx = { 0, 1, 0,-1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int trace = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1;tc<T+1;tc++) {
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			building = new char[h][w];
			visited = new boolean[h][w];
			
			
			for(int i = 0; i < h; i++) {
				String s = br.readLine();
				for(int j =0; j < w;j++) {
					visited[i][j] = false;
					building[i][j] = s.charAt(j);
					if(building[i][j] == '@') {
						startX = i; startY = j;
					}else if(building[i][j] == '*') {
						List<Integer> inst = new ArrayList<>();
						inst.add(i);
						inst.add(j);
						firePoint.add(inst);
					}
					
				}
			}
			boolean isOut = false;
			while(!isOut) {
				
			}	
		}
	}
	public void burn(int x, int y) {
		
	}
	public void move(int x, int y) {
		for(List li : firePoint) {
			int fX = (int) li.get(0), fY = (int) li.get(1);
			building[fX][fY] = '*';
			// 4방향 검사후 .인 부분에 *로 바꾸기
			firePoint.add(li);
		}
		// 불이 붙으려는 칸을 제외하고자, 불이 붙은걸로 처리
		int nx = x + dx[trace];
		int ny = y + dy[trace];
		if(nx >= h || ny >=w || nx < 0 || ny < 0 || building[nx][ny] != '.') {
			trace = (trace+1) % 4;
			nx = x + dx[trace];
			ny = y + dy[trace];
		}
		move(nx, ny);
	}
}
