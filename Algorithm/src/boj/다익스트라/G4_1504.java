package boj.다익스트라;

import java.util.*;
import java.io.*;
public class G4_1504 {
	static int V, E;
	static List<int[]>[] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		for(int i = 0; i < V+1;i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < E;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v].add(new int[] {e, c});
			graph[e].add(new int[] {v, c});
		}
		st = new StringTokenizer(br.readLine());
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());
		
		System.out.println(excuteDijk(V1, V2));
		
	}
	public static int excuteDijk(int V1, int V2) {
		int min = 0;
		
		int ret = dijkstra(1, V1);
		if (ret == -1) return -1;
		else min += ret;
		
		ret = dijkstra(V2, V);
		if (ret == -1) return -1;
		else min += ret;

		
		int total = 0;
		ret = dijkstra(1, V2);
		if (ret == -1) return -1;
		else total += ret;
		
		ret = dijkstra(V1, V);
		if (ret == -1) return -1;
		else total += ret;
		
		min = Math.min(min, total);
		ret = dijkstra(V1, V2);
		if (ret == -1) return -1;
		else min += ret;
		
		
		return min;
	}
	public static int dijkstra(int start, int end) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.offer(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0], curCost = cur[1];
			
			if(curCost > dist[curNode]) continue;
			
			for(int[] next : graph[curNode]) {
				int nextNode = next[0], nextCost = next[1];
				int newCost = dist[curNode] + nextCost;
				if(newCost < dist[nextNode]) {
					dist[nextNode] = newCost;
					pq.offer(new int[] {nextNode, newCost});
				}
			}
		}
		if(dist[end] == Integer.MAX_VALUE) return -1;
		else return dist[end];

	}

}

