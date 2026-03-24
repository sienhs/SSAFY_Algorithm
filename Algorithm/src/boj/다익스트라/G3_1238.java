package boj.다익스트라;

import java.util.*;
import java.io.*;
public class G3_1238 {
	static int V, E, Middle;
	static final int INF = Integer.MAX_VALUE;
	static List<int[]>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Middle = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V+1]; // 정점의 갯수만큼 간선 인접리스트 초기화
		for(int i = 0; i < V+1; i++) {
			graph[i] = new ArrayList<>();
		}
//		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new int[] {v,  w});
		}
		int MAX = 0;
		for(int i = 1; i < V+1;i++) {
			int total = 0;
			total += dijkstra(i, Middle);
			total += dijkstra(Middle, i);
			MAX = Math.max(MAX, total);
		}
		System.out.println(MAX);
	}
	
	public static int dijkstra(int start, int end) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		pq.offer(new int[] {0, start}); // {거리, 노드번호}
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curDist = cur[0], curNode = cur[1];
			
			// 들어온 거리값이 현재까지 기록된 거리값보다 크다면 pass (필요없기 때문)
			if(curDist > dist[curNode]) continue;
			
			for(int[] next : graph[curNode]) {
				int nextNode = next[0], cost = next[1];
				int newDist = dist[curNode] + cost;
				
				if(newDist < dist[nextNode]) {
					dist[nextNode] = newDist;
					pq.offer(new int[] {newDist, nextNode});
				}
			}
		}
		return dist[end];
	}
}
