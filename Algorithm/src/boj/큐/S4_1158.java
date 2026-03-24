package boj.큐;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class S4_1158 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i < N+1;i++) list.add(i);
		
		
		for(int i = 0;i < N;i++) {
//			System.out.println("i = "+i+" list = " + list + "\nresult : " + result);
			int idx = (K -1) % list.size();
			result.add(list.get(idx));
			LinkedList<Integer> arr = new LinkedList<>();
			arr.addAll(list.subList(idx+1, list.size()));
			arr.addAll(list.subList(0, idx));
			list=arr;
		}
		
		System.out.print("<");
		for(int i =0;i < result.size()-1;i++) System.out.print(result.get(i)+", ");
		System.out.println(result.get(result.size()-1)+">");
	}
}
