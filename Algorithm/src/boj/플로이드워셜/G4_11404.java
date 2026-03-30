package boj.플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_11404 {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 노드 수
        int m = Integer.parseInt(br.readLine()); // 간선 수

        int[][] dist = new int[n + 1][n + 1];
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 1; i <= n; i++) dist[i][i] = 0;

        for (int i = 0; i < m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c); // 중복 간선 대비 min 처리
        }

        // 플로이드 워셜
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= n; i++) {
        	for(int j = 1;j<= n;j++) {
        		if(dist[i][j] == INF) {
        			sb.append("0").append(" ");
        			continue;
        		}
        		sb.append(dist[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
