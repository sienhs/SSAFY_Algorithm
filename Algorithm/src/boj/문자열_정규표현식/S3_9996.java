package boj.문자열_정규표현식;

import java.util.ArrayList;
import java.util.Scanner;

public class S3_9996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String pt = sc.next();
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < N; i ++) {
			arr.add(sc.next());
		}
		
		for (String s : arr) {
			String result = "DA";
			int star = pt.indexOf("*");
			String startPat = pt.substring(0, star);
			String endPat = pt.substring(star+1);
			if (s.length() < startPat.length() + endPat.length()) {
		        System.out.println("NE");
		        continue;
		    }
			
			
			if (s.startsWith(startPat) && s.endsWith(endPat)) {
		        System.out.println("DA");
		    } else {
		        System.out.println("NE");
		    }
		}
		
	}
}
/*
 * public class S3_9996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String pt = sc.next();
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < N; i ++) {
			arr.add(sc.next());
		}
		int star = pt.indexOf("*");
		String prefix = pt.substring(0, star); 
		String suffix = pt.substring(star + 1); 
		for (String s : arr) {
		    if (s.length() < prefix.length() + suffix.length()) {
		        System.out.println("NE");
		        continue;
		    }

		    if (s.startsWith(prefix) && s.endsWith(suffix)) {
		        System.out.println("DA");
		    } else {
		        System.out.println("NE");
		    }
		}
	}
}
 * */