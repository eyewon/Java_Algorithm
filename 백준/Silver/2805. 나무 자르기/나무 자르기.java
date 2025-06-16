import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int M;
	static long[] arr;
	
	public static boolean isPossible(long len) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i]>len?(arr[i] - len):0;
		}
		return sum >= M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long low = 1, high = arr[N-1];
		long result = 0;
		while(low <= high) {
			long mid = low + (high-low)/2;
			if(isPossible(mid)) {
				result = mid;
				low = mid+1;
			}
			else high = mid-1;
		}
		System.out.println(result);
	}
}