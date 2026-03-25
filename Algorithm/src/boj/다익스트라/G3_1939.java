package boj.다익스트라;
import java.util.*;
import java.io.*;

public class G3_1939 {
    static int V, E;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, c});
            graph[v].add(new int[]{u, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    static long dijkstra(int start, int end) {
        long[] dist = new long[V + 1]; // dist[i] = start~i 경로의 최대 병목값
        Arrays.fill(dist, 0);
        dist[start] = Long.MAX_VALUE;

        // 최대 힙 (중량 큰 것 우선)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));
        pq.offer(new long[]{start, Long.MAX_VALUE});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNode = (int) cur[0];
            long curCost = cur[1];

            if (curCost < dist[curNode]) continue;

            for (int[] next : graph[curNode]) {
                int nextNode = next[0];
                long nextCost = next[1];
                long newCost = Math.min(dist[curNode], nextCost); // 병목값 갱신
                if (newCost > dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new long[]{nextNode, newCost});
                }
            }
        }
        return dist[end];
    }
}


