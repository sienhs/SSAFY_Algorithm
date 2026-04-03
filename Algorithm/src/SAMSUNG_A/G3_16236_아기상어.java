package SAMSUNG_A;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_16236_아기상어 {
    static int N;
    static int[][] board;
    static Shark baby = null;

    static class Fish implements Comparable<Fish>{
        int x, y, size, dist;
        public Fish(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }
        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }

    static class Shark {
        int x, y, size;
        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    baby = new Shark(i, j);
                    board[i][j] = 0; // 초기 상어 위치 0으로
                }
            }
        }

        PriorityQueue<Fish> candidates;
        int totalTime = 0;
        int eatCount = 0;
        while(!(candidates = bfs()).isEmpty()) {
        	Fish target = candidates.poll();
        	totalTime += target.dist;
        	int x = target.x, y = target.y; 
        	board[x][y] = 0;
        	baby.x = x;
        	baby.y = y;
        	eatCount ++;
        	if(eatCount == baby.size) {
        		baby.size++;
        		eatCount = 0;
        	}
        }
        System.out.println(totalTime);
    }

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static PriorityQueue<Fish> bfs() {
    	PriorityQueue<Fish> candidates = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{baby.x, baby.y, 0}); // x, y, dist
        visited[baby.x][baby.y] = true;

        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            if (dist > minDist) break;

            if (board[cx][cy] != 0 && board[cx][cy] < baby.size) {
                candidates.add(new Fish(cx, cy, board[cx][cy], dist));
                minDist = dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] > baby.size) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        return candidates;
    }
}