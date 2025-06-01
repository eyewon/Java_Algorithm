import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int k=0;
	
	public static void hanoi(int n, int from, int to, int via) {
		if(n==1) {
			k++;
			sb.append(from + " " + to).append("\n");
		}else {
			hanoi(n-1, from, via, to);
			hanoi(1, from, to, via);
			hanoi(n-1, via, to, from);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 3, 2);
		System.out.println(k);
		System.out.println(sb);
	}
}