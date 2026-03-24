package swea;

import java.util.*;
import java.io.*;


public class D5_1247 {
	public static int N;
	public static List<Node> customs;
	public static Node home;
	public static Node company;
	public static class Node implements Comparable<Node>{
		public int x, y;
		boolean visited;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.visited = false;
		}
		public int distance(Node n) {
			int targetX = n.x;
			int targetY = n.y;
			return Math.abs(this.x -targetX) + Math.abs(this.y - targetY);
		}
		// Test
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "xy : ("+this.x+", "+this.y+")";
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(Math.abs(target.x - x) + Math.abs(target.y - y) < Math.abs(target.x - o.x) + Math.abs(target.y - o.y)) {
				return 1;
			}
			return -1;
		}
		
		
	}
	public static Node target;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			customs = new ArrayList<>();
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			company = new Node(cx, cy);
			
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			home = new Node(hx, hy);
			
			for(int i = 0; i < N; i++) {
				int tx = Integer.parseInt(st.nextToken());
				int ty = Integer.parseInt(st.nextToken());
				customs.add(new Node(tx, ty));
			}

			minDistance = Integer.MAX_VALUE;
			dfs(company, 0, 0);
			System.out.println("#"+tc+" "+minDistance);
		}
	}
	public static int minDistance;
	public static void dfs(Node prev, int dist, int depth) {
		if(dist >= minDistance) return;
		if(depth == N) {
			// 다 뽑았으니까 계산시작
			dist += prev.distance(home);
			minDistance = Math.min(dist, minDistance);
		}
		for(int i = 0; i < N; i++) {
			Node pick = customs.get(i);
			if(!pick.visited) {
				customs.get(i).visited = true;
				dfs(customs.get(i), dist+(prev.distance(customs.get(i))), depth+1);
				customs.get(i).visited = false;
			}
		}
	}
}
