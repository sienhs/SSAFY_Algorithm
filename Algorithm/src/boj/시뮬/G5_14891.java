package boj.시뮬;

import java.io.*;
import java.util.*;

public class G5_14891{
	public static class Gear{
		private int[] arr;
		public Gear(int[] arr) {
			this.arr = arr;
		}
		public void pushRight() {
			int temp = arr[7];
			for(int i = 6; i >= 0;i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = temp;
		}
		public void pushLeft() {
			int temp = arr[0];
			for(int i = 1; i <= 7;i++) {
				arr[i-1] = arr[i];
			}
			arr[7] = temp;
		}
		public int getBin() {
			return this.arr[0];
		}
		public int getRight() {
			return this.arr[2];
		}
		public int getLeft() {
			return this.arr[6];
		}
	}
	public static List<Gear> gears = new ArrayList<>();
	public static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0; i < 4;i++) {
			int[] info = new int[8];
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				info[j] = str.charAt(j)-'0';
			}
			gears.add(new Gear(info));
		}
		
		// 작업 횟수
		K = Integer.parseInt(br.readLine());
		
		// 작업 받기
		for(int i = 0; i < K; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int orderNum = Integer.parseInt(st.nextToken());
			int orderDir = Integer.parseInt(st.nextToken());
			
			// 구현
			order(orderNum, orderDir);
			
		}
		int result = 0;
		int product = 1;
		for(int i = 1; i <= 4;i++) {
			if(gears.get(i-1).getBin() == 1) {
				result += product;
			}
			product*=2;
		}
		System.out.println(result);
		
	}
	
	public static void order(int select, int direction) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {select-1, direction});
		switch(select){
		case 1:
			if(gears.get(0).getRight() == gears.get(1).getLeft()) break;
			direction = direction*-1;
			q.offer(new int[] {1, direction});
			if(gears.get(1).getRight() == gears.get(2).getLeft()) break;
			direction = direction*-1;
			q.offer(new int[] {2, direction});
			if(gears.get(2).getRight() == gears.get(3).getLeft()) break;
			direction = direction*-1;
			q.offer(new int[] {3, direction});
			break;
		case 2:
			if(gears.get(0).getRight() != gears.get(1).getLeft()) {
				q.offer(new int[] {0, direction*-1});
			}
			if(gears.get(1).getRight() == gears.get(2).getLeft()) break;
			direction = direction*-1;
			q.offer(new int[] {2, direction});
			if(gears.get(2).getRight() == gears.get(3).getLeft()) break;
			direction = direction*-1;
			q.offer(new int[] {3, direction});
			break;
		case 3:
			if(gears.get(3).getLeft() != gears.get(2).getRight()) {
				q.offer(new int[] {3, direction*-1});
			}
			if(gears.get(2).getLeft() == gears.get(1).getRight()) break;
			direction = direction*-1; 
			q.offer(new int[] {1, direction});
			if(gears.get(1).getLeft() == gears.get(0).getRight()) break;
			direction = direction*-1;
			q.offer(new int[] {0, direction});
			break;
		case 4:
			if(gears.get(3).getLeft() == gears.get(2).getRight()) break;
			direction = direction*-1;
			q.offer(new int[] {2, direction});
			if(gears.get(2).getLeft() == gears.get(1).getRight()) break;
			direction = direction*-1;
			q.offer(new int[] {1, direction});
			if(gears.get(1).getLeft() == gears.get(0).getRight()) break;
			direction = direction*-1;
			q.offer(new int[] {0, direction});
			break;
		}
		while(!q.isEmpty()) {
			int[] work = q.poll();
			if(work[1] == 1) gears.get(work[0]).pushRight();
			else gears.get(work[0]).pushLeft();
		}
	}
	
	
}
