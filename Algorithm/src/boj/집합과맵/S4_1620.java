package boj.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 맞춰야 하는 문제의 개수 M이 주어진다.

N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수

둘째 줄부터 N개의 줄에 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어온다.

그 다음 줄부터 총 M개의 줄에 맞춰야하는 문제가 입력으로 들어온다. 문제가 알파벳으로만 들어오면 포켓몬 번호를 
말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야한다.

 

( 첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 출력. 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 
포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력 )
 * */
public class S4_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] dogam = new String[N];
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String n = br.readLine();
			dogam[i] = n;
			map.put(n, i);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M;i++) {
			String input = br.readLine();
			
			if(Character.isDigit(input.charAt(0))) {
				sb.append(dogam[Integer.parseInt(input)-1]+"\n");
				
			}else {
				sb.append((map.get(input)+1)+"\n");
				
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
