import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
		
		while(end < arr.length) {
			sum += arr[end++];
			while(sum >= S && start < end) {
				minLen = Math.min(end-start, minLen);
				sum -= arr[start++];
			}
		}
		
		System.out.println(minLen==Integer.MAX_VALUE? 0: minLen);
	}
}