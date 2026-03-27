package boj.MST;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class G4_1647 {
	static int V, E;
	static List<long[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V+1];
        for(int i = 0; i < V+1; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < E;i++) {
        	st = new StringTokenizer(br.readLine());
        	int v = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	long c = Long.parseLong(st.nextToken());
        	
        	graph[v].add(new long[] {e, c});
        	graph[e].add(new long[] {v, c});
        }
        visited = new boolean[V+1];
        mst();
        
    }
    static boolean[] visited;
    
    public static void mst() {
    	List<long[]> mstResult = new ArrayList<>();
    	long total = (long)0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
        pq.offer(new long[] {1, 0});
        
        while(!pq.isEmpty()) {
        	long[] cur = pq.poll();
        	int curNode = (int)cur[0];
        	long curCost = cur[1];
        	
        	if(visited[curNode]) continue;
        	
        	visited[curNode] = true;
        	total += curCost;
        	mstResult.add(cur);
        	
        	for(long[] next : graph[curNode]) {
        		if(!visited[(int)next[0]]) {
        			pq.offer(new long[] {next[0], next[1]});
        		}
        	}
        	
        }
        long max =Long.MIN_VALUE;
        for(long[] l : mstResult) {
        	if(l[1] > max) max = l[1];
        }
        System.out.println(total-max);
        
        
    }
}


