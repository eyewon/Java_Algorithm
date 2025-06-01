import java.io.*;
import java.util.*;

class Main{
	static List<Integer> list = new ArrayList<>();
	
	public static void separate(char[] input, int i, int j) {
		if(i==j)
			return;
		if(i<j) {
			int len = (j-i+1)/3;
			for(int k=i+len; k<i+2*len; k++) {
				input[k] = ' ';
			}
			separate(input, i, i+len-1);
			separate(input, i+2*len, i+3*len-1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String st;
		while((st = br.readLine())!= null) {
			int N = Integer.parseInt(st);
			char[] input= new char[(int)Math.pow(3, N)];
			for(int i=0; i<(int)Math.pow(3, N); i++)
				input[i]='-';
			separate(input, 0, input.length-1);
	
			sb.append(input).append("\n");
		}
		System.out.print(sb);
	}
}