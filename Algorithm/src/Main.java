
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc < T+1;tc++) {
			////////////////////////////
			ArrayList<String> fid = new ArrayList<>();
			int N = sc.nextInt();
			for(int i = 0;i<N;i++) {
				fid.add(sc.next());
			}
			ArrayList<String> front = new ArrayList<>();
			ArrayList<String> back = new ArrayList<>();
			if(fid.size()%2!=0) for(int i = 0;i < N/2+1;i++) front.add(fid.get(i));
			else for(int i =0; i < N/2;i++) front.add(fid.get(i));
			
			for(int i = 0; i < N/2; i++) {
				back.add(fid.get(i+((N+1)/2)));
				
			}
				
			fid.clear();
			
			for(int i = 0; i < back.size();i++) {
				fid.add(front.get(i));
				fid.add(back.get(i));
			}if(front.size()>back.size()) fid.add(front.get(front.size()-1));
			
			
			System.out.print("#"+tc);
			for(String a : fid) {
				System.out.print(" "+a);
			}System.out.println();
			
			///////////////////////////
		}
		
	}
}
