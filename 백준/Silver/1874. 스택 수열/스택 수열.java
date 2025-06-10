import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for(int i=0; i<n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		int idx = 0; 
		
		StringBuilder sb = new StringBuilder();
		while(idx<n) {
			if(!stack.isEmpty() && stack.peek() == input[idx]) {
				stack.pop();
				sb.append("-").append("\n");
				idx++;
			}else if (num <= n) {
				stack.push(num);
				sb.append("+").append("\n");
				num++;
			}else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}