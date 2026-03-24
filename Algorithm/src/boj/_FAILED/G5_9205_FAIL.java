package boj._FAILED;

import java.util.*;
import java.io.*;

public class G5_9205_FAIL {
	public static int hx, hy;
	static class Node implements Comparable<Node>{
		int x, y;
		int hx, hy;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	public static List<Node> stores;
	public static List<Node> sortedStores;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc < T+1;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			
			for(int i = 0;i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int tempX = Integer.parseInt(st.nextToken());
				int tempY = Integer.parseInt(st.nextToken());
				stores.add(new Node(tempX, tempY));
			}
			
			for(Node s : stores) {
				
			}
		}
	}
	public static void dfs(Node home) {
		int currentX = home.x;
		int currentY = home.y;
		
		
	}
}
