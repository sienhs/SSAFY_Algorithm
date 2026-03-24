package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1251 {
	public static int N;
	public static double E;
	
	public static class Node implements Comparable<Node>{
		int idx;
		long powDist;
		public Node(int idx, long powDist) {
			this.idx = idx;
			this.powDist = powDist;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.powDist, o.powDist);
		}
		
	}
	
	public static long[] x;
	public static long[] y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1;tc++) {
			N = Integer.parseInt(br.readLine());
			
			x = new long[N];
			y = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N;i ++) {
				y[i] = Long.parseLong(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N];
			
			pq.offer(new Node(0, 0));
			
			Long totalDistance = (long)0;
			int cnt = 0;
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				if(visited[n.idx]) continue;
				
				visited[n.idx] = true;
				totalDistance += n.powDist;
				
				cnt++;
				if(cnt == N) break;
				
				for(int i = 0; i < N; i++) {
					if(!visited[i]) {
						long l = (x[n.idx]-x[i]) * (x[n.idx]-x[i]) + (y[n.idx] - y[i]) * (y[n.idx] - y[i]);
						pq.offer(new Node(i, l));
					}
				}
			}
			
			System.out.println("#" + tc + " "+Math.round((double)totalDistance * E));
			
			
		}
	}
}
