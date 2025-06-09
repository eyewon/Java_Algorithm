import java.io.*;
import java.util.*;

class Main {
	public static String getFizzBuzz(int i) {
		if(i%3==0 && i%5==0) return "FizzBuzz";
		else if(i%3==0) return "Fizz";
		else if(i%5==0)	return "Buzz";
		else return String.valueOf(i);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[3];
		for(int i=0; i<3; i++) {
			input[i] = br.readLine();
		}
		
		int base = -1;
		for(int i=0; i<3;i++) {
			if(isNumeric(input[i])) base = Integer.parseInt(input[i])-i;
				
		}
		System.out.print(getFizzBuzz(base+3));
 	}
	
	static boolean isNumeric(String s) {
		return s.chars().allMatch(Character::isDigit);
	}
}