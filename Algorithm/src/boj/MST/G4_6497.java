package boj.MST;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class G4_6497 {
	static int V, E;
	static List<long[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine())!=null) {
        	StringTokenizer st = new StringTokenizer(line);
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if (V == 0 && E == 0) break;
            graph = new ArrayList[V];
            
            long result = (long)0;
            for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
            for(int i = 0; i < E;i++) {
            	st = new StringTokenizer(br.readLine());
            	int v = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	long c = Long.parseLong(st.nextToken());
            	result += c;
            	graph[v].add(new long[] {e, c});
            	graph[e].add(new long[] {v, c});
            }
            
            boolean[] visited = new boolean[V];
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
            pq.offer(new long[] {0, 0});
            
            Long total = (long)0;
            while(!pq.isEmpty()) {
            	long[] cur = pq.poll();
            	int curNode = (int)cur[0];
            	long curCost = cur[1];
            	
            	if(visited[curNode]) continue;
            	
            	visited[curNode] = true;
            	total+=curCost;
            	
            	for(long[] next : graph[curNode]) {
            		if(!visited[(int)next[0]]) {
            			pq.offer(new long[] {next[0], next[1]});
            		}
            	}
            }
            System.out.println(result-total);
        }
        
    }
}


