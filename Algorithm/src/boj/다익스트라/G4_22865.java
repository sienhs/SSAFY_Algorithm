package boj.다익스트라;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class G4_22865 {
    static List<int[]>[] graph;
    static int N, E;
    static List<Integer> saleHouses;
    static List<Integer> friendHouses;
    static int[] friends = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1;i++) {
        	graph[i] = new ArrayList<>();
        }
        saleHouses = new ArrayList<>();
        for(int i = 1; i < N+1;i++) saleHouses.add(i);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
       	int f1 = Integer.parseInt(st.nextToken());
       	int f2 = Integer.parseInt(st.nextToken());
       	int f3 = Integer.parseInt(st.nextToken());
       	friendHouses = Arrays.asList(f1, f2, f3);
        saleHouses.removeAll(friendHouses);
        
        E = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < E;i++) {
        	st = new StringTokenizer(br.readLine());
        	int v = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	graph[v].add(new int[] {e, c});
        	graph[e].add(new int[] {v, c});
        }
        
        
        int[] dist1 = dijkstra(f1);
        int[] dist2 = dijkstra(f2);
        int[] dist3 = dijkstra(f3);
        int max = 0;
        int result = 0;
        for(int sale : saleHouses) {
        	int min = Integer.MAX_VALUE;
        	min = Math.min(dist1[sale], Math.min(dist2[sale], Math.min(dist3[sale], min)));
        	if(min > max) {
        		max = min;
        		result = sale;
        	}
        }
        System.out.println(result);
    }

    static final int INF = Integer.MAX_VALUE;
    public static int[] dijkstra(int start) {
    	int[] dist = new int[N+1];
    	Arrays.fill(dist, INF);
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

    	return dist;
    	
    }
}


