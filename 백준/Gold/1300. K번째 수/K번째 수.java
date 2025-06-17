import java.io.*;
import java.util.*;

class Main {
	
	public static long count(long N, long mid) {
		long cnt = 0;
		for(int i=1; i<=N; i++) {
			cnt += Math.min(mid/i, N);
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = N*N;
		long result = 0;
		
		while(left <= right) {
			long mid = left + (right - left)/2;
			if(count(N, mid) >= k) {
				result = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(result);
	}
}