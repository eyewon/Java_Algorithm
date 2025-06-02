import java.io.*;
import java.util.*;

class Main{	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[] num;
	static int[] op = new int[4]; // +, -, x, %
	
	public static void backtracking(int idx, int result) {
		if(idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				op[i]--;
				int next = operation(i, result, num[idx]);
				backtracking(idx+1, next);
				op[i]++;
			}
		}
	}
	
	public static int operation(int i, int num1, int num2) {
		if(i==0)
			return num1+num2;
		else if(i==1)
			return num1-num2;
		else if(i==2)
			return num1*num2;
		else {
			if(num1<0)
				return (Math.abs(num1)/num2) *(-1);
			else 
				return num1/num2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(1, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
}