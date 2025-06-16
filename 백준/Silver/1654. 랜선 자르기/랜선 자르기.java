import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int K;
	static long[] arr;
	
	public static boolean isPossible(long len) {
		int cnt = 0;
		for(int i=0; i<K; i++) {
			long sum = arr[i];
			while(len <= sum) {
				sum -= len;
				cnt++;
			}
		}
		if(cnt >= N) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long low = 1, high = arr[K-1];
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