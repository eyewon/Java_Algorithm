import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String isbn = br.readLine();
		int starIdx = -1;
		int sum = 0;
		
		for(int i=0; i<12; i++) {
			char ch = isbn.charAt(i);
			if(ch=='*') {
				starIdx=i;
				continue;
			}
			int digit = ch - '0';
			sum += (i%2 == 0)? digit: digit*3;
		}
		
		int checkDigit = isbn.charAt(12)-'0'; // 마지막 자리 m
		for(int i=0; i<=9; i++) {
			int tempSum = sum + ((starIdx%2==0)? i: i*3);
			int total = tempSum + checkDigit;
			if (total % 10==0) {
				System.out.println(i);
				return;
			}
		}
 	}
}