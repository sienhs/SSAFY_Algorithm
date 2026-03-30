package boj.플로이드워셜;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class G4_1956 {
	static int N, M;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	dist = new int[N + 1][N + 1];
    	
    	for(int[] arr : dist) Arrays.fill(arr, INF);
    	
    	// i->i 사이클을 찾아야 하므로 0으로 초기화 안해도됌
//    	for(int i = 0; i < N+1;i++) dist[i][i] = 0;
    	
    	for(int i = 0; i < M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		dist[a][b] = Math.min(dist[a][b], c); // 중복 대비
    	}
    	
    	floyed();
    	
//    	StringBuilder sb = new StringBuilder();
//        for(int i = 1;i <= N; i++) {
//        	for(int j = 1;j<= N;j++) {
//        		if(dist[i][j] == INF) {
//        			sb.append("0").append("\t");
//        			continue;
//        		}
//        		sb.append(dist[i][j]).append("\t");
//        	}
//        	sb.append("\n");
//        }
//        System.out.println(sb);
    	
    	int result = findCycle();
    	if(result == INF) result = -1;
    	System.out.println(result);
    }
    public static void floyed() {
    	for(int k = 1; k < N+1;k++) 
    		for(int i = 1; i < N+1;i++) 
    			for(int j = 1; j < N+1;j++) 
    				if(dist[i][k] + dist[k][j] < dist[i][j]) 
    					dist[i][j] = dist[i][k] + dist[k][j];
    }
    public static int findCycle() {
    	int minCycle = Integer.MAX_VALUE;
    	for(int i = 1; i < N+1;i++) {
    		minCycle = Math.min(minCycle, dist[i][i]);
    	}
    	return minCycle;
    }
}


