import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int sum=0;
		boolean minus = false;
		String num ="";
		
		for(int i=0; i<input.length(); i++) {
			char cur = input.charAt(i);
			if(cur=='-' || cur == '+') {
				int number = Integer.parseInt(num);
				if(minus)
					sum-=number;
				else
					sum+=number;
				num="";
				if(cur == '-') 
					minus = true;
			}else {
				num+=cur;
			}
		}
		int number = Integer.parseInt(num);
		sum = minus? sum-number: sum+number;
		System.out.println(sum);
 	}
}