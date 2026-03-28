package boj.DFS_BFS;
import java.util.*;
import java.io.*;

public class S1_14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[] start = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) start = new int[]{i, j, 0};
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == 1) result[i][j] = -1; 

        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], count = cur[2];

            for (int t = 0; t < 4; t++) {
                int nx = x + dx[t];
                int ny = y + dy[t];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == 0) continue; 
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                result[nx][ny] = count + 1;
                q.offer(new int[]{nx, ny, count + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
                if (j < M - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}