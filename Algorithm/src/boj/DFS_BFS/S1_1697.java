package boj.DFS_BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1697 {
	public static int N, K, cnt;
	public static Queue<Integer> que = new LinkedList<>();
	public static HashSet<Integer> visited = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		find(N);
	}
	public static void find(int dot) {
		que.offer(dot);
		visited.add(dot);
		while(!que.isEmpty()) {
			
			int s = que.size();
			for(int i = 0; i < s;i++) {
				int temp = que.poll();
				if(temp == K) {
					System.out.println(cnt);
					return;
				}
				int[] findList = {temp +1, temp-1, temp*2};
				for(int t : findList) {
					if(t < 100001 && t >= 0 && !visited.contains(t)) {
						que.offer(t);
						visited.add(t);
					}
				}
				
			}
			
			cnt++;
		}
		System.out.println(cnt);
		return;
	}
}
