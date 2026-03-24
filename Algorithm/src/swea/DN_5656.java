package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class DN_5656 {
	public static int N, W, H;
	public static List<Queue<Integer>> brickBoard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			brickBoard = new ArrayList<>();
			for(int i = 0; i < H;i++) {
				brickBoard.add(new LinkedList<>());
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W;j++) {
					brickBoard.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(Queue<Integer> q : brickBoard) {
				System.out.println(q);
			}
			
			
			
		}
		
		
	}
}
