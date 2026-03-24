package boj.그리디;

import java.util.Scanner;

public class S4_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = 0;
		if(N != 4 && N !=7) {
			while(N!=0) {
				if(N%5!=0) {
					N -=3;
					R++;
				}else{
					N-=5;
					R++;
				}
			}
			System.out.println(R);
		}
		else System.out.println(-1);
	}
}
