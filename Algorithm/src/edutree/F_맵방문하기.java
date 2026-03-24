package edutree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F_맵방문하기 {
							// U  D  L R	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = { 0, 0,-1, 1};
	
	public static int curX;
	public static int curY;
	public static int cnt;
	public static int N;
	public static int M;
	
	public static int trace;
	public static char [][] grid;
	public static boolean[][] visited;
	public static ArrayList<Integer> maxWalks = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i ++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j);
				visited[i][j] = false;
			}
		}
		// 입력 끝
		
		// 1. 화살표 따라가기
		for(int i =0;i < N;i++) {
			for(int j=0;j <M;j++) {
				visited = new boolean[N][M];
				cnt = 0;
				walkGrid(i, j);
			}
		}
		System.out.println(maxWalks);
		// 2. 1번 + 마법 케이스 구하기
		
	}
	public static void walkMagicGrid(int x, int y, int magicLine, char magicWord) {
		visited[x][y] = true;
		setTrace(x, y);
		int nx = x + dx[trace];
		int ny = y + dy[trace];
		if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
			maxWalks.add(cnt);
			return;
		}
		nx = x + dx[trace];
		ny = y + dy[trace];
		
		curX = nx;
		curY = ny;
		cnt+=1;
		walkGrid(curX, curY);
	}
	public static void setMagic(int x, int y, int magicLine, char magicWord) {
		//
		// magic변수에 따라 아래있는 x, y값을 재 조정하면 됨
		//
		//if(); // 여기 수정해야댐
		// else if(grid[x][y] == 'U') trace = 0;
//		else if(grid[x][y] == 'D') trace = 1;
//		else if(grid[x][y] == 'L')trace = 2;
//		else if(grid[x][y] == 'R') trace = 3;
	}
	public static void setTrace(int x, int y) {
		if(grid[x][y] == 'U') trace = 0;
		else if(grid[x][y] == 'D') trace = 1;
		else if(grid[x][y] == 'L')trace = 2;
		else if(grid[x][y] == 'R') trace = 3;
	}

	public static void walkGrid(int x, int y) {
		visited[x][y] = true;
		setTrace(x, y);
		int nx = x + dx[trace];
		int ny = y + dy[trace];
		if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
			maxWalks.add(cnt);
			return;
		}
		nx = x + dx[trace];
		ny = y + dy[trace];
		
		curX = nx;
		curY = ny;
		cnt+=1;
		walkGrid(curX, curY);
	}
}