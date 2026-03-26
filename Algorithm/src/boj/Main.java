package boj;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
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
        }
        
        
    }
}


