package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1227 {
	public static int[][] miro;
	public static boolean result;

	public static int fx = 13, fy =13;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int tc = 1;tc < T+1;tc++) {
			br.readLine();
			result = false;
			miro = new int[100][100];
			for(int i =0;i<100;i++) {
				String line = br.readLine();
				char[] chars = line.toCharArray();
				
				for(int j = 0; j < 100;j++) {
					miro[i][j] = chars[j]-'0';
					if(chars[j]-'0' == 3) {
						fx = i;
						fy = j;
					}
				}
			}
			move(1,1);	
			int r = 0;
			if(result) r= 1;
			System.out.println("#"+tc+" "+r);
			
			
			
			
		}
		
	}
	public static void move(int x, int y) {
		if(x == fx && y == fy) {
			result = true;
			return;
		}
		miro[x][y] = 1;
		for(int t = 0; t < 4;t++) {
			int nx = x + dx[t];
			int ny = y + dy[t];
			
			if(nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
				if(miro[nx][ny] != 1) {
					move(nx, ny);
					
				}
			}
				
				
				
		}
		
	}
}
