package boj.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5_27433 {
	static long result = 1;
	public static long fact(int N) {
		if (N>=1) {
			result = result * N;
			return fact(N-1);
		}else return result;
		 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(fact(Integer.parseInt(st.nextToken())));
	}
}
