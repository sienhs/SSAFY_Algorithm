package boj.DFS_BFS;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5_1260 {
	
	public static int[][] graph;
	public static boolean[] visited;
	public static int N, M, V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i < M;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		dfs(V);
		visited = new boolean[N+1];
		System.out.println();
		bfs(V);
	}
	public static void dfs(int now) {
		visited[now] = true;
		System.out.print(now + " ");
		for(int i = 0; i < graph.length;i++) {
			if(graph[i][now] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(now);
		visited[now] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n + " ");
			for(int i = 1; i < graph.length;i++) {
				if(graph[i][n] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
