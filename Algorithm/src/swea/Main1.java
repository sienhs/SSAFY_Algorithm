package swea;
import java.util.Scanner;

/*
 * idx = 0 -> 1
 * 1 1 2 3 5
 * 100000
 * 100001
 * 100010
 * 100101
 * 100100
 * 
 * 101000
 * 101010
 * 101001
 *  
 * 10000
 * 10001
 * 10010
 * 10100
 * 10101
 * 
 * 5 
 * 
 * 10 0 10 1 10 2
*/

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		int base = (int)Math.pow(10, N-1), cnt = 1;
		
		for(int i = 0; i < N-2; i++) {
			String str = Integer.toString(base);
			for(int j =0;j < Integer.toString(base).length()-1;j++) {
				if(str.charAt(j) != str.charAt(j+1)) {
					cnt++;
				}
			}
			
			base += (int)Math.pow(10, i);
			
		}
		System.out.println(base);
	}
}
