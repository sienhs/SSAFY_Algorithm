package boj.플로이드워셜;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class G4_2219 {
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
    	 	
    	for(int i = 0; i < M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		dist[a][b] = Math.min(dist[a][b], c);
    		dist[b][a] = Math.min(dist[b][a], c); // 쌍방향으로 중복 검열
    	}
    	
    	floyed();
    	find();
    }
    public static void floyed() {
    	for(int k = 1; k < N+1;k++) 
    		for(int i = 1; i < N+1;i++) 
    			for(int j = 1; j < N+1;j++) 
    				if(dist[i][k] + dist[k][j] < dist[i][j]) 
    					dist[i][j] = dist[i][k] + dist[k][j];
    }
    public static void find() {
    	int min = Integer.MAX_VALUE;
    	int minNode = 1;
    	for(int i = 1; i < N+1;i++) {
    		int sum = 0;
    		for(int j = 1; j < N+1;j++) sum+= dist[i][j];
    		if(min > sum) {
    			min = sum;
    			minNode = i;
    		}else if(min == sum) { // 최소값이 같으면 번호가 작은 컴퓨터를 출력
    			if(i < minNode) {
    				minNode = i;
    			}
    		}
    		
    	}
    	System.out.println(minNode);
    }
}


