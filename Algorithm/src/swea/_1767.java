package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1767 {
	public static int N, maxCore, minWire;
	public static int[][] breadBoard;
	public static List<int[]> cores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			breadBoard = new int[N][N];
			cores = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N;j++) {
					breadBoard[i][j] = Integer.parseInt(st.nextToken());
					if(breadBoard[i][j] == 1) {
						if(i == 0 || i == N-1 || j == 0 || j ==N-1) continue;
						cores.add(new int[] {i, j});
					}
				}
			}
			maxCore = 0;
			minWire = 100;
			bt(0, 0, 0);
			
			System.out.println("#"+tc+" "+ minWire);
			
			
		}
	}
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = { 0, 1, 0,-1};
	public static void changed(int x, int y, int status, int cnt, int trace) {
		int tx = x, ty = y;
		for(int i = 0; i < cnt;i++) {
			tx += dx[trace];
			ty += dy[trace];
			breadBoard[tx][ty] = status;
		}
	}
	public static void bt(int idx, int coreCnt, int wireLength) {
	    if (idx == cores.size()) {
	        if (coreCnt > maxCore) {
	            maxCore = coreCnt;
	            minWire = wireLength;
	        } else if (coreCnt == maxCore) {
	            minWire = Math.min(minWire, wireLength);
	        }
	        return;
	    }

	    int x = cores.get(idx)[0];
	    int y = cores.get(idx)[1];

	    for (int trace = 0; trace < 4; trace++) {
	        int instCnt = 0;
	        int nx = x, ny = y;

	        while (true) {
	            nx += dx[trace];
	            ny += dy[trace];
	            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break; // 끝까지 닿음
	            if (breadBoard[nx][ny] != 0) { // 장애물
	                instCnt = -1;
	                break;
	            }
	            instCnt++;
	        }

	        if (instCnt != -1) {
	        	changed(x,y,2,instCnt,trace);
	            bt(idx + 1, coreCnt + 1, wireLength + instCnt);
	            changed(x,y,0,instCnt,trace);
	        }
	    }

	    bt(idx + 1, coreCnt, wireLength);
	}
	
}
