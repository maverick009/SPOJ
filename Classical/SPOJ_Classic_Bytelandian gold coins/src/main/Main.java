package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long []arr = new long[1000000];
	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long n = 1000000;
		long i;
		for(i = 0;i < n;i++) {
			long r = arr[(int)i/2] + arr[(int)i/3] + arr[(int)i/4];
			arr[(int) i] = Math.max(r, i);
		}
		
		while(true) {
			try {
				String str = reader.readLine();
				n = Long.parseLong(str);
				
			} catch(IOException ioException) {
				break;
			}
			System.out.println(val(n));
		}
	}
	
	public static long val(long n) {
		if(n == 0)
			return 0;
		else if(n <= 1000000 && arr[(int) n] != 0)
			return arr[(int) n];
		else
			return Math.max(n, val(n/2) + val(n/3) + val(n/4));
	}
}